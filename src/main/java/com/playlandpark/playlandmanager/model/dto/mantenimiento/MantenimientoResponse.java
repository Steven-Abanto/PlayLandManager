package com.playlandpark.playlandmanager.model.dto.mantenimiento;

import com.playlandpark.playlandmanager.model.dto.summary.JuegoSummary;

import java.time.LocalDate;

public record MantenimientoResponse(
        Integer idMantenimiento,
        Integer idEmpleado,
        String empleadoNombre,
        JuegoSummary juego,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        String resultado,
        String observaciones
) {}