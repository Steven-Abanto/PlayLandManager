package com.playlandpark.playlandmanager.model.dto.usuario;

import com.playlandpark.playlandmanager.model.dto.summary.ClienteSummary;
import com.playlandpark.playlandmanager.model.dto.summary.EmpleadoSummary;
import com.playlandpark.playlandmanager.model.enums.RolesUsuario;

public record UsuarioResponse(
        Integer idUsuario,
        String usuario,
        RolesUsuario rol,
        Boolean activo,
        EmpleadoSummary empleado,
        ClienteSummary cliente
) {}