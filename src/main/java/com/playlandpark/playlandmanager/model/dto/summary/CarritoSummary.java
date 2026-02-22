package com.playlandpark.playlandmanager.model.dto.summary;

import java.time.LocalDateTime;

public record CarritoSummary(
        Integer idCarrito,
        String estado,
        LocalDateTime fechaCreacion
) {}
