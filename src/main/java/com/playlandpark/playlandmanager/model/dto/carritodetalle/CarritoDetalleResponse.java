package com.playlandpark.playlandmanager.model.dto.carritodetalle;

import com.playlandpark.playlandmanager.model.dto.summary.ProductoSummary;

//Este response es necesario para mostrar el detalle de todos los productos al consultar el carrito

import java.math.BigDecimal;

public record CarritoDetalleResponse(
        Integer idCarritoDetalle,
        ProductoSummary producto,
        BigDecimal precio,
        Integer cantidad,
        BigDecimal descuento,
        BigDecimal subtotal
) {}
