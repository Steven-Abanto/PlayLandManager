package com.playlandpark.playlandmanager.model.dto.summary;

import java.math.BigDecimal;

public record ProductoSummary(
        Integer idProducto,
        String descripcion,
        BigDecimal precio,
        Boolean esServicio,
        Boolean activo
) {}