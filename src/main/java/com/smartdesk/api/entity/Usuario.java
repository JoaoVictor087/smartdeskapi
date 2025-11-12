package com.smartdesk.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "T_SD_USUARIO")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "NM_USUARIO", nullable = false)
    private String nomeUsuario;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "LOCAL")
    private String local;
}
