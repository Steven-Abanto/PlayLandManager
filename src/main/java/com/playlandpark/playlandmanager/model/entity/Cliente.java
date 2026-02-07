package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column(nullable = false)
    private String tipoDoc;

    @Column(nullable = false, unique = true)
    private String numeDoc;

    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String genero;
    private LocalDate fechaNac;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(unique = true)
    private String telefono;

    private String direccion;
    private Boolean activo;
}

