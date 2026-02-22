package com.playlandpark.playlandmanager.model.dto.movventa;

import com.playlandpark.playlandmanager.model.dto.summary.CajaSummary;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovVentaResponse(
        Integer idMovVenta,
        CajaSummary caja,
        BigDecimal monto,
        LocalDate fecha,
        String tipoMovimiento
) {}
