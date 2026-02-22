package com.playlandpark.playlandmanager.model.dto.summary;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PromocionSummary(
        Integer idPromocion,
        String codigo,
        String nombre,
        BigDecimal porcentaje,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Boolean activo
) {}
