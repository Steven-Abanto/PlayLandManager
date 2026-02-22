package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "boleta_detalle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBoletaDetalle;

    @ManyToOne
    @JoinColumn(name = "idBoleta", nullable = false)
    private Boleta boleta;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal precio;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal descuento;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal subtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPromocion")
    private Promocion promocion;
}

