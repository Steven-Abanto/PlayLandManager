package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(nullable = false)
    private String tipoDoc;

    @Column(nullable = false, unique = true)
    private String numeDoc;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String contraseña;
    private Boolean activo;
}

