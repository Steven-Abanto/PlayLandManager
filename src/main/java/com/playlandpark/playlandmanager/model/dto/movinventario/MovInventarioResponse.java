package com.playlandpark.playlandmanager.model.dto.movinventario;

import com.playlandpark.playlandmanager.model.dto.summary.BoletaSummary;
import com.playlandpark.playlandmanager.model.dto.summary.ProductoSummary;

import java.time.LocalDate;

public record MovInventarioResponse(
        Integer idMovInv,
        BoletaSummary boleta, // puede ser null si es AJUSTE manual
        ProductoSummary producto,
        Integer cantidad,
        LocalDate fecha,
        String tipoMovimiento
) {}
