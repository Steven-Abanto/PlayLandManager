package com.playlandpark.playlandmanager.model.dto.carritodetalle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Este request es para agregar un producto al carrito

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDetalleAddRequest {
    private Integer idCarrito;
    private Integer idProducto;
    private Integer cantidad;
}
