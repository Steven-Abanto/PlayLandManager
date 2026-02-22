package com.playlandpark.playlandmanager.model.dto.caja;

public record CajaAperturaRequest (
    String codCaja,
    String usuApertura,
    Double montoApertura,
    String turno
){
}
