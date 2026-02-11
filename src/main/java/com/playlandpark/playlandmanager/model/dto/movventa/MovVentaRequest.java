package com.playlandpark.playlandmanager.model.dto.movventa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovVentaRequest {
    private Integer caja;
    private Double monto;
    private LocalDate fecha;
}
