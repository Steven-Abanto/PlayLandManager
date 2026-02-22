package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "promocion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPromocion;

    @Column(nullable = false, unique = true, length = 50)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal porcentaje;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal montoMax;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = false)
    private Boolean activo = true;

    @ManyToMany
    @JoinTable(
            name = "promocionProducto",
            joinColumns = @JoinColumn(name = "idPromocion"),
            inverseJoinColumns = @JoinColumn(name = "idProducto")
    )
    private Set<Producto> productos = new HashSet<>();
}