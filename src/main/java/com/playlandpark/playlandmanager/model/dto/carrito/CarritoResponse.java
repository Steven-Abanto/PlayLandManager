package com.playlandpark.playlandmanager.model.dto.carrito;

import com.playlandpark.playlandmanager.model.dto.carritodetalle.CarritoDetalleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoResponse {
    private Integer idCarrito;
    private String estado;
    private List<CarritoDetalleResponse> items;
    private Double total;
}
