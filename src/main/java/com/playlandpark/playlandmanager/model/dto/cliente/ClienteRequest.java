package com.playlandpark.playlandmanager.model.dto.cliente;

import java.time.LocalDate;

public record ClienteRequest(
        String tipoDoc,
        String numeDoc,
        String nombre,
        String apePaterno,
        String apeMaterno,
        String genero,
        LocalDate fechaNac,
        String correo,
        String telefono,
        String direccion,
        Boolean activo
) {}

