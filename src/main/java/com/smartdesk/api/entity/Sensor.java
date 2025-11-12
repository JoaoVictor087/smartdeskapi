package com.smartdesk.api.entity;

import com.smartdesk.api.enums.StatusSensor;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "T_SD_SENSOR")
public class Sensor {
    @Id
    @Column(name = "ID_SENSOR")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ST_SENSOR", nullable = false)
    private StatusSensor statusSensor;

    @OneToOne
    @JoinColumn(name = "ID_MESA", nullable = false)
    private Mesa mesa;
}
