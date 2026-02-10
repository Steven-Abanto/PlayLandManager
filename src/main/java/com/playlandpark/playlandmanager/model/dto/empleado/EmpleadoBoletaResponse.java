package com.playlandpark.playlandmanager.model.dto.empleado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoBoletaResponse {
    private Integer idEmpleado;
    private String nombre;
}
