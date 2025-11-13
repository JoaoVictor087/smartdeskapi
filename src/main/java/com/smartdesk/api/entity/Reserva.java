package com.smartdesk.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "T_SD_RESERVA")
@Data
public class Reserva {
    @Id
    @Column(name = "ID_RESERVA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DT_INICIO", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "DT_FIM", nullable = false)
    private LocalDateTime dataFim;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "ID_MESA", nullable = false)
    private Mesa mesa;
}
