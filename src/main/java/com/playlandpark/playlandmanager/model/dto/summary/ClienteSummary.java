package com.playlandpark.playlandmanager.model.dto.summary;

public record ClienteSummary(
        Integer idCliente,
        String tipoDoc,
        String numeDoc,
        String nombre,
        String apePaterno,
        String apeMaterno,
        String correo
) {}
