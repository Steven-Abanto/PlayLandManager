package com.playlandpark.playlandmanager.model.dto.boletadetalle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletaDetalleRequest {
    private Integer idProducto;
    private Integer cantidad;
    private Double dscto;
}
