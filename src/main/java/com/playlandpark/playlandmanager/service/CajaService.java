package com.playlandpark.playlandmanager.service;

import com.playlandpark.playlandmanager.model.dto.caja.CajaAperturaRequest;
import com.playlandpark.playlandmanager.model.dto.caja.CajaCierreRequest;
import com.playlandpark.playlandmanager.model.dto.caja.CajaResponse;

import java.util.List;

public interface CajaService {

    CajaResponse open(CajaAperturaRequest request);      // Apertura

    CajaResponse close(CajaCierreRequest request);       // Cierre

    CajaResponse findById(Integer idCaja);

    CajaResponse findByCode(String codCaja);

    List<CajaResponse> findAll();

    List<CajaResponse> findByStatus(String estado);
}