package com.playlandpark.playlandmanager.model.dto.boleta;

import com.playlandpark.playlandmanager.model.dto.caja.CajaRequest;
import com.playlandpark.playlandmanager.model.dto.caja.CajaResponse;
import com.playlandpark.playlandmanager.model.dto.detboleta.DetBoletaResponse;
import com.playlandpark.playlandmanager.model.dto.empleado.EmpleadoRequest;
import com.playlandpark.playlandmanager.model.dto.empleado.EmpleadoResponse;
import com.playlandpark.playlandmanager.model.dto.metpago.MetPagoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletaResponse {
    private Integer idBoleta;
    private String tipoDoc;
    private String numeDoc;
    private String tipoDocCli;
    private String numeDocCli;
    private Double subtotal;
    private Double dsctoTotal;
    private Double impuesto;
    private Double total;
    private String estado;
    private LocalDateTime fechaHora;
    private CajaResponse caja;
    private EmpleadoResponse empleado;
    private List<MetPagoResponse> metodosPago;
    private List<DetBoletaResponse> detalles;
}
