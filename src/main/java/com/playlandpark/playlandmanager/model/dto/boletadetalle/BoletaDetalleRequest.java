package com.playlandpark.playlandmanager.model.dto.boletadetalle;

import java.math.BigDecimal;

public record BoletaDetalleRequest (
        Integer idProducto,
        Integer cantidad,
        BigDecimal descuento
){
}
