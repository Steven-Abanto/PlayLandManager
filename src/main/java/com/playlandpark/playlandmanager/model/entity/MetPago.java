package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "met_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetPago;

    @ManyToOne
    @JoinColumn(name = "idBoleta", nullable = false)
    private Boleta boleta;

    @Column(nullable = false)
    private String metodoPago;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal monto;
}

