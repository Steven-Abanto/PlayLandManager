package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal montoApertura;

    private String usuCierre;

    @Column(precision = 15, scale = 2)
    private BigDecimal montoCierre;

    private String turno;
    private String estado;
}

