package com.playlandpark.playlandmanager.model.dto.rsvservicio;

import com.playlandpark.playlandmanager.model.enums.EstadoReserva;

import java.time.LocalDate;
import java.time.LocalTime;

public record RsvServicioResponse(
        Integer idReserva,

        Integer idProducto,
        String descripcionProducto,

        Integer idCliente,
        String nombreCliente,

        LocalDate fechaReserva,
        LocalTime horaInicio,
        LocalTime horaFin,

        Integer cntPersonas,
        EstadoReserva estado,
        String observaciones
) {}
