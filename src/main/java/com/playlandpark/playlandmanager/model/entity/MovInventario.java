package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "mov_inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovInv;

    @ManyToOne
    @JoinColumn(name = "idBoleta")
    private Boleta boleta;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    private Integer cantidad;
    private LocalDate fecha;
}

