package com.playlandpark.playlandmanager.model.dto.promocion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public record PromocionRequest(
        String codigo,
        String nombre,
        String descripcion,
        BigDecimal porcentaje,
        BigDecimal montoMax,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Boolean activo,
        Set<Integer> productosIds
) {}
