package com.playlandpark.playlandmanager.model.entity;

import com.playlandpark.playlandmanager.model.enums.RolesEmpleado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cargo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCargo;

    // CAJERO,
    // OPERARIO_JUEGO,
    // OPERARIO_MANTE,
    // GERENTE_LOCAL,
    // ADMINISTRADOR
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RolesEmpleado rol;
}

