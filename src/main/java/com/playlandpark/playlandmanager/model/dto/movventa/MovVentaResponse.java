package com.playlandpark.playlandmanager.model.dto.movventa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovVentaResponse {
    private Integer idMovVenta;
    private String codCaja;
    private Double monto;
    private LocalDate fecha;
}
