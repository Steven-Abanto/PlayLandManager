package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "caja")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Caja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCaja;

    @Column(nullable = false)
    private String codCaja;

    @Column(nullable = false)
    private String usuApertura;

    @Column(nullable = false)
    private Double montoApertura;

    @Column(nullable = false)
    private String usuCierre;

    @Column(nullable = false)
    private Double montoCierre;

    private String turno;
    private String estado;
}

