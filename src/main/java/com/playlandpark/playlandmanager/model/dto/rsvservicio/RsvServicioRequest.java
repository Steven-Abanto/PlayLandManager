package com.playlandpark.playlandmanager.model.dto.rsvservicio;

import java.time.LocalDate;
import java.time.LocalTime;

public record RsvServicioRequest(
        Integer idProducto,
        Integer idCliente,
        LocalDate fechaReserva,
        LocalTime horaInicio,
        LocalTime horaFin,
        Integer cntPersonas,
        String observaciones
) {}