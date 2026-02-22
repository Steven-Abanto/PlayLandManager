//package com.playlandpark.playlandmanager.model.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "servicio")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Servicio {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer idServicio;
//
//    private String descripcion;
//    private String tipoServicio;
//    private Integer duracionHoras;
//
//    @Column(nullable = false)
//    private Integer capacidad;
//
//    @Column(precision = 15, scale = 2, nullable = false)
//    private BigDecimal precio;
//
//    @Column(nullable = false)
//    private Boolean reqReserva;
//
//    @Column(nullable = false)
//    private Boolean activo = true;
//}
//
