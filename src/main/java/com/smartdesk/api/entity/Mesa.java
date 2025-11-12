package com.smartdesk.api.entity;

import com.smartdesk.api.enums.StatusMesa;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "T_SD_MESA")
@Data
public class Mesa {
    @Id
    @Column(name = "ID_MESA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NM_MESA", nullable = false)
    private String nomeMesa;

    @Column(name = "ST_MESA", nullable = false)
    private StatusMesa StatusMesa;

    @Column(name = "CPD_MESA", nullable = false)
    private Integer capacidadeMesa;

    @OneToOne
    @JoinColumn(name = "T_SD_SENSOR")
    private Sensor sensor;
}