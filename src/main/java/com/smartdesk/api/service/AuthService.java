package com.smartdesk.api.service;

import com.smartdesk.api.DTOs.request.CriarUsuarioRequestDTO;
import com.smartdesk.api.DTOs.request.LoginRequestDTO;
import com.smartdesk.api.DTOs.response.CriarUsuarioResponseDTO;
import com.smartdesk.api.DTOs.response.LoginResponseDTO;
import com.smartdesk.api.entity.Usuario;
import com.smartdesk.api.enums.ROLES;
import com.smartdesk.api.exceptions.ValidacaoException;
import com.smartdesk.api.repository.UsuarioRepository;
import com.smartdesk.api.security.JWT.JWTTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTTokenProvider jwtTokenProvider;

    @Transactional
    public CriarUsuarioResponseDTO cadastrarUsuario(CriarUsuarioRequestDTO dto){
        if (usuarioRepository.findByEmailIgnoreCase(dto.email()).isPresent()) {
            log.error("Erro ao criar usuario. Email {} já cadastrado", dto.email());
            throw new ValidacaoException("Já existe um usuário cadastrado com este e-mail.");
        }

        Usuario usuario = Usuario.builder()
                .nomeUsuario(dto.nome())
                .email(dto.email())
                .senha(passwordEncoder.encode(dto.senha()))
                .role(dto.role())
                .build();

        usuarioRepository.save(usuario);
        log.debug("Usuario {} criado", usuario.getId());
        return new CriarUsuarioResponseDTO(usuario.getId(), usuario.getEmail(), usuario.getEmail() );
    }

    public LoginResponseDTO loginUsuario(LoginRequestDTO dto){
        var usuarioSenha = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());

        var auth = authenticationManager.authenticate(usuarioSenha);

        var usuario = (Usuario) auth.getPrincipal();

        String accessToken = jwtTokenProvider.gerarToken(usuario);
        String refreshToken = jwtTokenProvider.gerarRefreshToken(usuario);

        log.debug("usuário {} logado com sucesso", usuario.getId());
        return new LoginResponseDTO(accessToken, refreshToken, usuario.getId(), usuario.getRole());
    }


}
