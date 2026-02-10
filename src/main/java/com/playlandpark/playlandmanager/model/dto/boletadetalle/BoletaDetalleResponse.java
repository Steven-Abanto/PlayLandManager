package com.playlandpark.playlandmanager.model.dto.boletadetalle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletaDetalleResponse {
    private Integer idBoleta;
    private Integer idProducto;
    private String descripcion;
    private Integer cantidad;
    private Double precio;
    private Double dscto;
    private Double subtotal;
}
