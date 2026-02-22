package com.playlandpark.playlandmanager.model.dto.carrito;

import com.playlandpark.playlandmanager.model.dto.carritodetalle.CarritoDetalleResponse;
import com.playlandpark.playlandmanager.model.dto.summary.UsuarioSummary;

import java.time.LocalDateTime;
import java.util.List;

public record CarritoResponse(
        Integer idCarrito,
        UsuarioSummary usuario,
        String estado,
        LocalDateTime fechaCreacion,
        List<CarritoDetalleResponse> detalles
) {}