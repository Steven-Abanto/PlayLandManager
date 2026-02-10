package com.playlandpark.playlandmanager.model.dto.boleta;

import com.playlandpark.playlandmanager.model.dto.detboleta.DetBoletaRequest;
import com.playlandpark.playlandmanager.model.dto.metpago.MetPagoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletaRequest {
    private Integer idCaja;
    private Integer idEmpleado;
    private String tipoDoc;
    private String numeDoc;
    private String tipoDocCli;
    private String numeDocCli;
    private List<MetPagoRequest> metodosPago;
    private List<DetBoletaRequest> detalles;
    private String estado;
}
