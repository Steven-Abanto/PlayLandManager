package com.playlandpark.playlandmanager.model.dto.juego;

import com.playlandpark.playlandmanager.model.enums.EstadoJuego;

import java.time.LocalDate;

public record JuegoResponse(
        Integer idJuego,
        String codigo,
        String nombre,
        String tipo,
        String descripcion,
        EstadoJuego estado,
        LocalDate ultMant,
        LocalDate proxMant,
        Boolean activo
) {}