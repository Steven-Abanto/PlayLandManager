package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//Esta entidad es el detalle del carrito, o sea, los productos

@Entity
@Table(name = "carrito_detalle",
        uniqueConstraints = @UniqueConstraint(name = "uk_carrito_producto",
                                              columnNames = {"idCarrito", "idProducto"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarritoDetalle;

    @ManyToOne
    @JoinColumn(name = "idCarrito", nullable = false)
    private Carrito carrito;

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
