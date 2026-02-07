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

    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String genero;
    private LocalDate fechaNac;
    private String correo;
    private String telefono;
    private String direccion;

    @Column(nullable = false)
    private Integer local;

    @Column(nullable = false)
    private Integer cargo;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    private LocalDate fechaFin;
    private Boolean activo;
}

