package com.playlandpark.playlandmanager.model.dto.caja;

import java.math.BigDecimal;

public record CajaResponse (
    Integer idCaja,
    String codCaja,
    String usuApertura,
    BigDecimal montoApertura,
    String usuCierre,
    BigDecimal montoCierre,
    String turno,
    String estado
){
}
