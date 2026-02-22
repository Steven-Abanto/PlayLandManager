package com.playlandpark.playlandmanager.model.dto.movinventario;

import java.time.LocalDate;

public record MovInventarioRequest(
        Integer idBoleta,     // puede ser null si es AJUSTE manual
        Integer idProducto,
        Integer cantidad,
        LocalDate fecha,
        String tipoMovimiento
) {}

