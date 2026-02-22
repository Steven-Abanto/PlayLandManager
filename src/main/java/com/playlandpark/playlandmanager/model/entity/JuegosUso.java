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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idJuego", nullable = false)
    private Juego juego;

    private String cantidadUso;

    @Column(nullable = false)
    private LocalDate fechaUso;
    private String descripcion;
}

