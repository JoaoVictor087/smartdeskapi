package com.smartdesk.api.entity;

import com.smartdesk.api.enums.StatusMesa;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "T_SD_MESA")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mesa {
    @Id
    @Column(name = "ID_MESA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NM_MESA", nullable = false)
    private String nomeMesa;

    @Column(name = "ST_MESA", nullable = false)
    private StatusMesa statusMesa;

    @Column(name = "CPD_MESA", nullable = false)
    private Integer capacidadeMesa;

    @Column(name = "LCL_MESA")
    private String localizacao;

    @OneToOne
    @JoinColumn(name = "T_SD_SENSOR")
    private Sensor sensor;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario empresa;
}