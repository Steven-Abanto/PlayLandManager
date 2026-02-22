package com.playlandpark.playlandmanager.service;

import com.playlandpark.playlandmanager.model.dto.promocion.PromocionRequest;
import com.playlandpark.playlandmanager.model.dto.promocion.PromocionResponse;
import com.playlandpark.playlandmanager.model.dto.summary.PromocionSummary;

import java.util.List;

public interface PromocionService {

    PromocionResponse create(PromocionRequest request);

    PromocionResponse findById(Integer idPromocion);

    PromocionResponse findByCodigo(String codigo);

    List<PromocionResponse> findAll(boolean onlyActive);

    List<PromocionSummary> findAllSummary(boolean onlyActive);

    List<PromocionResponse> findActiveToday();

    PromocionResponse update(Integer idPromocion, PromocionRequest request);

    void logicDelete(Integer idPromocion);

    PromocionResponse addProducto(Integer idPromocion, Integer idProducto);

    PromocionResponse removeProducto(Integer idPromocion, Integer idProducto);
}
