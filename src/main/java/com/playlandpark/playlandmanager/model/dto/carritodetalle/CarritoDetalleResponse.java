package com.playlandpark.playlandmanager.model.dto.carritodetalle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Este response es necesario para mostrar el detalle de todos los productos al consultar el carrito

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDetalleResponse {
    private Integer idCarritoDetalle;
    private Integer idProducto;
    private String producto;
    private Double precio;
    private Integer cantidad;
    private Double descuento;
    private Double subtotal;
}
