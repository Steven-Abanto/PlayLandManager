package com.playlandpark.playlandmanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    @JoinColumn(name = "idCaja", nullable = false)
    private Caja caja;

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    @Column(nullable = false)
    private String tipoDoc;

    @Column(nullable = false, unique = true)
    private String numeDoc;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "boleta", cascade = CascadeType.ALL)
    private List<MetPago> pagos;

    private Double subtotal;
    private Double dsctoTotal;
    private Double impuesto;
    private Double total;
    private String estado;

    @Column(nullable = false)
    private LocalDateTime fechaHora = LocalDateTime.now();
}

