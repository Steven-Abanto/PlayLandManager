package com.playlandpark.playlandmanager.controller;

import com.playlandpark.playlandmanager.model.dto.cargo.CargoRequest;
import com.playlandpark.playlandmanager.model.dto.cargo.CargoResponse;
import com.playlandpark.playlandmanager.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService cargoService;

    @PostMapping
    public ResponseEntity<CargoResponse> create(@RequestBody CargoRequest request) {
        CargoResponse response = cargoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoResponse> findById(@PathVariable Integer id) {
        CargoResponse response = cargoService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/role/{rol}")
    public ResponseEntity<CargoResponse> findByRole(@PathVariable String rol) {
        CargoResponse response = cargoService.findByRole(rol);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CargoResponse>> findAll() {
        List<CargoResponse> response = cargoService.findAll();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoResponse> update(
            @PathVariable Integer id,
            @RequestBody CargoRequest request
    ) {
        CargoResponse response = cargoService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        cargoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
