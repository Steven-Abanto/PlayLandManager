package com.playlandpark.playlandmanager.model.dto.caja;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CajaResponse (
    Integer idCaja,
    String codCaja,
    String usuApertura,
    BigDecimal montoApertura,
    LocalDateTime horaApertura,
    String usuCierre,
    BigDecimal montoCierre,
    LocalDateTime horaCierre,
    String estado
){
}
