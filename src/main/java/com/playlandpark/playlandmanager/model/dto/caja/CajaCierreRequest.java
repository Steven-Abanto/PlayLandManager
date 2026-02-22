package com.playlandpark.playlandmanager.model.dto.caja;

public record CajaCierreRequest (
    Integer idCaja,
    String usuCierre,
    Double montoCierre
){
}