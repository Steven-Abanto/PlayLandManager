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
    @JoinColumn(name = "idBoleta") // Nullable true para ajustes manuales
    private Boleta boleta;

    @ManyToOne
    @JoinColumn(name = "idProducto",   nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String tipoMovimiento;
}

