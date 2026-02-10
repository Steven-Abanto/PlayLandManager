package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "juegos_uso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JuegosUso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJuegosUso;

    @ManyToOne
    @JoinColumn(name = "idJuego")
    private Juego juego;

    private String cantidadUso;
    private LocalDate fechaUso;
    private String descripcion;
    private String estado;

    @Column(nullable = false)
    private LocalDate ultMant;

    @Column(nullable = false)
    private LocalDate proxMant;

    private Boolean activo;
}

