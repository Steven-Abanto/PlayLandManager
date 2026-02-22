package com.playlandpark.playlandmanager.model.dto.producto;

import java.math.BigDecimal;

public record ProductoResponse(
        Integer idProducto,
        String descripcion,
        String categoria,
        String marca,
        BigDecimal precio,
        Integer stockMin,
        Integer stockAct,
        String uniMedida,
        String upc,
        String sku,
        Boolean esServicio,
        Boolean activo
) {}