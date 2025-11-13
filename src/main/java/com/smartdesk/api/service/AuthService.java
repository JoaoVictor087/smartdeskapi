package com.smartdesk.api.service;

import com.smartdesk.api.DTOs.request.CriarUsuarioRequestDTO;
import com.smartdesk.api.DTOs.response.CriarUsuarioResponseDTO;
import com.smartdesk.api.entity.Usuario;
import com.smartdesk.api.enums.ROLES;
import com.smartdesk.api.exceptions.ValidacaoException;
import com.smartdesk.api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

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
                .role(ROLES.ROLE_USER)
                .build();

        usuarioRepository.save(usuario);
        log.debug("Usuario {} criado", usuario.getId());
        return new CriarUsuarioResponseDTO(usuario.getId(), usuario.getEmail(), usuario.getEmail() );
    }


}
