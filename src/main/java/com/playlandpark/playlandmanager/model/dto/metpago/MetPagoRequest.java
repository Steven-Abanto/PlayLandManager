package com.playlandpark.playlandmanager.model.dto.metpago;

import java.math.BigDecimal;

public record MetPagoRequest(
        String metodoPago,
        BigDecimal monto
) {}
