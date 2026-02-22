package com.playlandpark.playlandmanager.model.dto.cargo;

import com.playlandpark.playlandmanager.model.enums.RolesEmpleado;

public record CargoResponse(
        Integer idCargo,
        RolesEmpleado rol
) {}
