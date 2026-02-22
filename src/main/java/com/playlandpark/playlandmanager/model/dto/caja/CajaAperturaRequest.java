package com.playlandpark.playlandmanager.model.dto.caja;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CajaAperturaRequest (
    String codCaja,
    String usuApertura,
    BigDecimal montoApertura,
    LocalDateTime horaApertura
){
}
