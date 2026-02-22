package com.playlandpark.playlandmanager.service;

import com.playlandpark.playlandmanager.model.dto.juego.JuegoRequest;
import com.playlandpark.playlandmanager.model.dto.juego.JuegoResponse;
import com.playlandpark.playlandmanager.model.enums.EstadoJuego;

import java.util.List;

public interface JuegoService {

    JuegoResponse create(JuegoRequest request);

    JuegoResponse findById(Integer idJuego);

    JuegoResponse findByCodigo(String codigo);

    List<JuegoResponse> findAll(boolean onlyActive);

    List<JuegoResponse> findByEstado(EstadoJuego estado, boolean onlyActive);

    JuegoResponse update(Integer idJuego, JuegoRequest request);

    void logicDelete(Integer idJuego);
}
