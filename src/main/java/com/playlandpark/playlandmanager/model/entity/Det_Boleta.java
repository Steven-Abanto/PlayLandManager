package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "det_boleta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Det_Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetBol;

    @ManyToOne
    @JoinColumn(name = "idBoleta")
    private Boleta boleta;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    private Double precio;
    private Integer cantidad;
    private Double dscto;
    private Double subtotal;
}

