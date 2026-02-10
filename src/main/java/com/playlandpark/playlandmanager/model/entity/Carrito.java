package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "carrito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarrito;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private String estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL)
    private List<CarritoDetalle> detalles;
}

