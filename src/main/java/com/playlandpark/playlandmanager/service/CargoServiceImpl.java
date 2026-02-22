package com.playlandpark.playlandmanager.service;

import com.playlandpark.playlandmanager.model.dto.cargo.CargoRequest;
import com.playlandpark.playlandmanager.model.dto.cargo.CargoResponse;
import com.playlandpark.playlandmanager.model.entity.Cargo;
import com.playlandpark.playlandmanager.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;

    @Override
    public CargoResponse create(CargoRequest request) {

        if (request == null || request.rol() == null) {
            throw new IllegalArgumentException("Role is required.");
        }

        if (cargoRepository.existsByRol(request.rol())) {
            throw new IllegalArgumentException("A cargo with this role already exists: " + request.rol());
        }

        Cargo cargo = new Cargo();
        cargo.setRol(request.rol());

        Cargo saved = cargoRepository.save(cargo);
        return mapToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public CargoResponse findById(Integer idCargo) {

        Cargo cargo = cargoRepository.findById(idCargo)
                .orElseThrow(() -> new IllegalArgumentException("Cargo no encontrado para el id: " + idCargo));

        return mapToResponse(cargo);
    }

    @Override
    @Transactional(readOnly = true)
    public CargoResponse findByRole(String rol) {

        Cargo cargo = cargoRepository.findByRol(rol)
                .orElseThrow(() -> new IllegalArgumentException("Cargo encontrado para el rol: " + rol));

        return mapToResponse(cargo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CargoResponse> findAll() {
        return cargoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public CargoResponse update(Integer idCargo, CargoRequest request) {
        if (request == null || request.rol() == null) {
            throw new IllegalArgumentException("Rol es requerido.");
        }

        Cargo cargo = cargoRepository.findById(idCargo)
                .orElseThrow(() -> new IllegalArgumentException("Cargo no encontrado para el id: " + idCargo));

        if (!cargo.getRol().equals(request.rol()) &&
                cargoRepository.existsByRol(request.rol())) {

            throw new IllegalArgumentException("Un cargo con este rol ya existe: " + request.rol());
        }

        cargo.setRol(request.rol());

        Cargo updated = cargoRepository.save(cargo);
        return mapToResponse(updated);
    }

    @Override
    public void delete(Integer idCargo) {

        Cargo cargo = cargoRepository.findById(idCargo)
                .orElseThrow(() -> new IllegalArgumentException("Cargo no encontrado para el id: " + idCargo));

        cargoRepository.delete(cargo);
    }

    private CargoResponse mapToResponse(Cargo cargo) {
        return new CargoResponse(
                cargo.getIdCargo(),
                cargo.getRol()
        );
    }
}