package com.smartdesk.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "T_SD_SALA")
@Data
@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_SALA")
    private Long id;

    @Column(name = "NM_SALA", nullable = false)
    private String nomeSala;

    @Column(name = "LOCAL")
    private String local;

    @Column(name = "CPD_SALA")
    private Integer capacidadeSala;
}
