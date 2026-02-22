package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
    @JoinColumn(name = "idCaja", nullable = false)
    private Caja caja;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal monto;

    private LocalDate fecha;
    private String tipoMovimiento;
}

