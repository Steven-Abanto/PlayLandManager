package com.playlandpark.playlandmanager.model.dto.carritodetalle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Este request es para actualizar la cantidad de un producto del carrito

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDetalleUpdateRequest {
    private Integer cantidad;
}
