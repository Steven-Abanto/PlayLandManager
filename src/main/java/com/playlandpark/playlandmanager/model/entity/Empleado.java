package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    @Column(nullable = false)
    private String tipoDoc;

    @Column(nullable = false, unique = true)
    private String numeDoc;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apePaterno;

    @Column(nullable = false)
    private String apeMaterno;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private LocalDate fechaNac;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private Integer local;

    @ManyToOne
    @JoinColumn(name = "idCargo", nullable = false)
    private Cargo cargo;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @Column(nullable = false)
    private Boolean activo = true;
}

