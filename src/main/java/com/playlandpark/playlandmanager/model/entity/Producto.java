package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer stockMin;

    @Column(nullable = false)
    private Integer stockAct;

    private String uniMedida;

    @Column(nullable = false, unique = true)
    private String upc;

    @Column(nullable = false, unique = true)
    private String sku;

    private Boolean activo;
}

