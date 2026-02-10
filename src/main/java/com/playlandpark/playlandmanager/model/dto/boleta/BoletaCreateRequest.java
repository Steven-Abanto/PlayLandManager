package com.playlandpark.playlandmanager.model.dto.boleta;

import com.playlandpark.playlandmanager.model.dto.boletadetalle.BoletaDetalleRequest;
import com.playlandpark.playlandmanager.model.dto.metpago.MetPagoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletaCreateRequest {
    private Integer idCaja;
    private Integer idEmpleado;
    private String tipoDoc;
//No se envia desde el cliente
//    private String numeDoc;
    private String tipoDocCli;
    private String numeDocCli;
    private List<MetPagoRequest> metodosPago;
    private List<BoletaDetalleRequest> detalles;
}
