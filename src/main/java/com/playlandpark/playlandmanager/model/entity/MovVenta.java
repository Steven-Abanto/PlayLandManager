package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "mov_venta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovVenta;

    @ManyToOne
    @JoinColumn(name = "idCaja")
    private Caja caja;

    private Double monto;
    private LocalDate fecha;
}

