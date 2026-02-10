package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Esta entidad es el detalle del carrito, o sea, los productos

@Entity
@Table(name = "carrito_detalle")
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

    private Double precio;
    private Integer cantidad;
    private Double descuento;
    private Double subtotal;
}
