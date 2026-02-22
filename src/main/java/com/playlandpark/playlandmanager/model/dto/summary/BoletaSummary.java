package com.playlandpark.playlandmanager.model.dto.summary;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BoletaSummary(
        Integer idBoleta,
        String numeDoc,
        BigDecimal total,
        String estado,
        LocalDateTime fechaHora
) {}
