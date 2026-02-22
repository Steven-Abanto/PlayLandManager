package com.playlandpark.playlandmanager.model.dto.boleta;

import com.playlandpark.playlandmanager.model.dto.boletadetalle.BoletaDetalleRequest;
import com.playlandpark.playlandmanager.model.dto.metpago.MetPagoRequest;
import com.playlandpark.playlandmanager.model.enums.TipoDocuVenta;

import java.util.List;

public record BoletaRequest(
        Integer idCaja,
        Integer idEmpleado,

        // Tipo de documento de venta (BOL, FAC, etc.)
        TipoDocuVenta tipoDocuVenta,

        // Cliente opcional (venta rápida)
        Integer idCliente,

        List<BoletaDetalleRequest> detalles,
        List<MetPagoRequest> pagos
) {
}