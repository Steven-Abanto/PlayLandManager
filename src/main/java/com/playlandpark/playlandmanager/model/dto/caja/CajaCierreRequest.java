package com.playlandpark.playlandmanager.model.dto.caja;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CajaCierreRequest {
    private Integer idCaja;
    private String usuCierre;
    private Double montoCierre;
}