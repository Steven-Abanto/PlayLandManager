package com.playlandpark.playlandmanager.model.dto.summary;

import com.playlandpark.playlandmanager.model.enums.RolesUsuario;

public record UsuarioSummary(
        Integer idUsuario,
        String usuario,
        RolesUsuario rol,
        Boolean activo
) {}
