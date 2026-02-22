package com.playlandpark.playlandmanager.model.dto.summary;

import com.playlandpark.playlandmanager.model.dto.cargo.CargoResponse;

public record EmpleadoSummary(
        Integer idEmpleado,
        String tipoDoc,
        String numeDoc,
        String nombre,
        String apePaterno,
        String apeMaterno,
        String correo,
        CargoResponse cargo
) {}
