package com.playlandpark.playlandmanager.model.dto.carritodetalle;

import java.math.BigDecimal;

public record CarritoDetalleRequest(
        Integer idCarrito,
        Integer idProducto,
        BigDecimal precio,
        Integer cantidad,
        BigDecimal descuento
) {}
