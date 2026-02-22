package com.playlandpark.playlandmanager.controller;

import com.playlandpark.playlandmanager.model.dto.caja.CajaAperturaRequest;
import com.playlandpark.playlandmanager.model.dto.caja.CajaCierreRequest;
import com.playlandpark.playlandmanager.model.dto.caja.CajaResponse;
import com.playlandpark.playlandmanager.service.CajaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cajas")
@RequiredArgsConstructor
public class CajaController {

    private final CajaService cajaService;

    @PostMapping("/open")
    public ResponseEntity<CajaResponse> open(@RequestBody CajaAperturaRequest request) {
        CajaResponse response = cajaService.open(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/close")
    public ResponseEntity<CajaResponse> close(@RequestBody CajaCierreRequest request) {
        return ResponseEntity.ok(cajaService.close(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CajaResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(cajaService.findById(id));
    }

    @GetMapping("/code/{codCaja}")
    public ResponseEntity<CajaResponse> findByCode(@PathVariable String codCaja) {
        return ResponseEntity.ok(cajaService.findByCode(codCaja));
    }

    @GetMapping
    public ResponseEntity<List<CajaResponse>> findAll() {
        return ResponseEntity.ok(cajaService.findAll());
    }

    @GetMapping("/status/{estado}")
    public ResponseEntity<List<CajaResponse>> findByStatus(@PathVariable String estado) {
        return ResponseEntity.ok(cajaService.findByStatus(estado));
    }
}