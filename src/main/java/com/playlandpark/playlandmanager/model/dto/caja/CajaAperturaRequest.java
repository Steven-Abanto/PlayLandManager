package com.playlandpark.playlandmanager.model.dto.caja;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CajaAperturaRequest {
    private String codCaja;
    private String usuApertura;
    private Double montoApertura;
    private String usuCierre;
    private Double montoCierre;
    private String turno;
}
