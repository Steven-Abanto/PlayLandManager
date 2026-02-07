package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "boleta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBoleta;

    @ManyToOne
    @JoinColumn(name = "idCaja")
    private Caja caja;

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    @Column(nullable = false)
    private String tipoDoc;

    @Column(nullable = false, unique = true)
    private String numeDoc;

    private String tipoDocCli;
    private String numeDocCli;
    private String metodoPago;
    private Double subtotal;
    private Double dsctoTotal;
    private Double impuesto;
    private Double total;
    private String estado;
    private LocalDateTime fechaHora;
}

