package com.playlandpark.playlandmanager.model.dto.juegosuso;

import java.time.LocalDate;

public record JuegosUsoRequest(
        Integer idJuego,
        String cantidadUso,
        LocalDate fechaUso,
        String descripcion
) {}