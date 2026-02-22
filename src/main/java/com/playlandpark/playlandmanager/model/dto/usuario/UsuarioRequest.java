package com.playlandpark.playlandmanager.model.dto.usuario;

import com.playlandpark.playlandmanager.model.enums.RolesUsuario;

public record UsuarioRequest(
        String usuario,
        String contrasena,
        RolesUsuario rol,
        Integer idEmpleado,
        Integer idCliente,
        Boolean activo
) {}