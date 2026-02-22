package com.playlandpark.playlandmanager.model.entity;

import com.playlandpark.playlandmanager.model.enums.RolesUsuario;
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

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RolesUsuario rol;

    @Column(nullable = false)
    private Boolean activo = true;

    // Usuario puede ser de un empleado...
    @OneToOne(optional = true)
    @JoinColumn(name = "id_empleado", unique = true)
    private Empleado empleado;

    // ...o de un cliente
    @OneToOne(optional = true)
    @JoinColumn(name = "id_cliente", unique = true)
    private Cliente cliente;
}

