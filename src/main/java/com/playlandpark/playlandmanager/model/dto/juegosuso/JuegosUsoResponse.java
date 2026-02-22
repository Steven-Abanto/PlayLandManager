package com.playlandpark.playlandmanager.model.dto.juegosuso;

import com.playlandpark.playlandmanager.model.dto.summary.JuegoSummary;

import java.time.LocalDate;

public record JuegosUsoResponse(
        Integer idJuegosUso,
        JuegoSummary juego,
        String cantidadUso,
        LocalDate fechaUso,
        String descripcion
) {}