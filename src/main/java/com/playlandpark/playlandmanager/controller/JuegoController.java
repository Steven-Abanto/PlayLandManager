package com.playlandpark.playlandmanager.controller;

import com.playlandpark.playlandmanager.model.dto.juego.JuegoRequest;
import com.playlandpark.playlandmanager.model.dto.juego.JuegoResponse;
import com.playlandpark.playlandmanager.model.enums.EstadoJuego;
import com.playlandpark.playlandmanager.service.JuegoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
@RequiredArgsConstructor
public class JuegoController {

    private final JuegoService juegoService;

    @PostMapping
    public ResponseEntity<JuegoResponse> create(@RequestBody JuegoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(juegoService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JuegoResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(juegoService.findById(id));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<JuegoResponse> findByCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(juegoService.findByCodigo(codigo));
    }

    @GetMapping
    public ResponseEntity<List<JuegoResponse>> findAll(
            @RequestParam(defaultValue = "false") boolean onlyActive) {
        return ResponseEntity.ok(juegoService.findAll(onlyActive));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<JuegoResponse>> findByEstado(
            @PathVariable EstadoJuego estado,
            @RequestParam(defaultValue = "false") boolean onlyActive) {

        return ResponseEntity.ok(juegoService.findByEstado(estado, onlyActive));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JuegoResponse> update(
            @PathVariable Integer id,
            @RequestBody JuegoRequest request) {

        return ResponseEntity.ok(juegoService.update(id, request));
    }

    @PatchMapping("/{id}/logic-delete")
    public ResponseEntity<Void> logicDelete(@PathVariable Integer id) {
        juegoService.logicDelete(id);
        return ResponseEntity.noContent().build();
    }
}