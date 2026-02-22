package com.playlandpark.playlandmanager.model.dto.summary;

import com.playlandpark.playlandmanager.model.enums.EstadoJuego;

import java.time.LocalDate;

public record JuegoSummary(
        Integer idJuego,
        String codigo,
        String nombre,
        EstadoJuego estado,
        LocalDate proxMant,
        Boolean activo
) {}
