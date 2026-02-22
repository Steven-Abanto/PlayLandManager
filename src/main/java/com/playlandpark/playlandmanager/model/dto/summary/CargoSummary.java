package com.playlandpark.playlandmanager.model.dto.summary;

import com.playlandpark.playlandmanager.model.enums.RolesEmpleado;

public record CargoSummary(
        Integer idCargo,
        RolesEmpleado rol
) {}

