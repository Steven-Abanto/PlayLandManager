package com.playlandpark.playlandmanager.model.dto.detboleta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetBoletaResponse {
    private Integer idBoleta;
    private Integer idProducto;
    private String descripcion;
    private Integer cantidad;
    private Double precio;
    private Double dscto;
    private Double subtotal;
}
