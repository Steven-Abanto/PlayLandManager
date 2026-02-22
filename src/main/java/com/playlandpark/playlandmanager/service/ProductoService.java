package com.playlandpark.playlandmanager.service;

import com.playlandpark.playlandmanager.model.dto.producto.ProductoRequest;
import com.playlandpark.playlandmanager.model.dto.producto.ProductoResponse;
import com.playlandpark.playlandmanager.model.dto.summary.ProductoSummary;

import java.util.List;

public interface ProductoService {

    ProductoResponse create(ProductoRequest request);

    ProductoResponse findById(Integer idProducto);

    ProductoResponse findBySku(String sku);

    ProductoResponse findByUpc(String upc);

    List<ProductoResponse> findAll(boolean onlyActive);

    List<ProductoSummary> findAllSummary(boolean onlyActive);

    List<ProductoResponse> findByServiceType(boolean esServicio, boolean onlyActive);

    ProductoResponse update(Integer idProducto, ProductoRequest request);

    void logicDelete(Integer idProducto);
}
