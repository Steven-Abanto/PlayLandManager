package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    private String descripcion;
    private String categoria;
    private String marca;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal precio;

    @Column(nullable = false)
    private Integer stockMin;

    @Column(nullable = false)
    private Integer stockAct;

    private String uniMedida;

    @Column(nullable = false, unique = true)
    private String upc;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private Boolean esServicio = false;

    @Column(nullable = false)
    private Boolean activo = true;

    //Búsqueda inversa para promociones del producto
    @ManyToMany(mappedBy = "productos")
    private Set<Promocion> promociones = new java.util.HashSet<>();
}

