package com.playlandpark.playlandmanager.model.dto.caja;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CajaCierreRequest (
    String codCaja,
    String usuCierre,
    BigDecimal montoCierre,
    LocalDateTime horaCierre
){
}