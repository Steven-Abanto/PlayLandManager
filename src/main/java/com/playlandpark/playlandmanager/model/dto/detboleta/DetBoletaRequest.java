package com.playlandpark.playlandmanager.model.dto.detboleta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetBoletaRequest {
    private Integer idProducto;
    private Integer cantidad;
    private Integer dscto;
}
