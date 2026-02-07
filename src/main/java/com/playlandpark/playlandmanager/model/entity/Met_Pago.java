package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "met_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Met_Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetPago;

    @ManyToOne
    @JoinColumn(name = "idBoleta")
    private Boleta boleta;

    private String metodoPago;
    private Double monto;
}

