package com.playlandpark.playlandmanager.service;

import com.playlandpark.playlandmanager.model.dto.cargo.CargoRequest;
import com.playlandpark.playlandmanager.model.dto.cargo.CargoResponse;

import java.util.List;

public interface CargoService {

    CargoResponse create(CargoRequest request);

    CargoResponse findById(Integer idCargo);

    CargoResponse findByRole(String rol);

    List<CargoResponse> findAll();

    CargoResponse update(Integer idCargo, CargoRequest request);

    void delete(Integer idCargo);
}
