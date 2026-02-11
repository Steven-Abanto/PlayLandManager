package com.playlandpark.playlandmanager.model.dto.metpago;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetPagoResponse {
    private Integer idBoleta;
    private String metodoPago;
    private Double monto;
}
