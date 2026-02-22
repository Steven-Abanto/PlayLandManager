package com.playlandpark.playlandmanager.model.dto.metpago;

import java.math.BigDecimal;

public record MetPagoResponse(
        Integer idMetPago,
        String metodoPago,
        BigDecimal monto
) {}
