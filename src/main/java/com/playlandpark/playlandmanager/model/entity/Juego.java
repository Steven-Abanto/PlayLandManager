package com.playlandpark.playlandmanager.model.entity;

import com.playlandpark.playlandmanager.model.enums.EstadoJuego;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "juego")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJuego;

    @Column(nullable = false, unique = true)
    private String codigo;

    private String nombre;
    private String tipo;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoJuego estado;

    @Column(nullable = false)
    private LocalDate ultMant;

    @Column(nullable = false)
    private LocalDate proxMant;

    @Column(nullable = false)
    private Boolean activo = true;
}

