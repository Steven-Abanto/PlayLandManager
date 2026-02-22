package com.playlandpark.playlandmanager.model.dto.boletadetalle;

import java.math.BigDecimal;

public record BoletaDetalleResponse (
    Integer idBoleta,
    Integer idProducto,
    String descripcion,
    Integer cantidad,
    BigDecimal precio,
    BigDecimal descuento,
    BigDecimal subtotal
){
}
