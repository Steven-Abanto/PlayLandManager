package com.playlandpark.playlandmanager.model.dto.summary;

public record EmpleadoSummary(
        Integer idEmpleado,
        String tipoDoc,
        String numeDoc,
        String nombre,
        String apePaterno,
        String apeMaterno,
        String correo,
        CargoSummary cargo
) {}
