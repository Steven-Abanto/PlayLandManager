package com.playlandpark.playlandmanager.model.dto.carrito;

import com.playlandpark.playlandmanager.model.dto.metpago.MetPagoRequest;

import java.util.List;

public record CarritoCheckoutRequest(
        Integer idCarrito,
        Integer idCaja,
        Integer idEmpleado,   // obligatorio
        Integer idCliente,    // opcional (puede venir null)
        List<MetPagoRequest> pagos
) {}

//Respuesta: BoletaResponse