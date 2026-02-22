package com.playlandpark.playlandmanager.controller;

import com.playlandpark.playlandmanager.model.dto.promocion.PromocionRequest;
import com.playlandpark.playlandmanager.model.dto.promocion.PromocionResponse;
import com.playlandpark.playlandmanager.service.PromocionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promociones")
@RequiredArgsConstructor
public class PromocionController {

    private final PromocionService promocionService;

    @PostMapping
    public ResponseEntity<PromocionResponse> create(@RequestBody PromocionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(promocionService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromocionResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(promocionService.findById(id));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<PromocionResponse> findByCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(promocionService.findByCodigo(codigo));
    }

    @GetMapping
    public ResponseEntity<List<PromocionResponse>> findAll(
            @RequestParam(defaultValue = "false") boolean onlyActive) {
        return ResponseEntity.ok(promocionService.findAll(onlyActive));
    }

    @GetMapping("/active-today")
    public ResponseEntity<List<PromocionResponse>> findActiveToday() {
        return ResponseEntity.ok(promocionService.findActiveToday());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromocionResponse> update(
            @PathVariable Integer id,
            @RequestBody PromocionRequest request) {
        return ResponseEntity.ok(promocionService.update(id, request));
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<Void> logicDelete(@PathVariable Integer id) {
        promocionService.logicDelete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/add-producto/{idProducto}")
    public ResponseEntity<PromocionResponse> addProducto(
            @PathVariable Integer id,
            @PathVariable Integer idProducto) {
        return ResponseEntity.ok(promocionService.addProducto(id, idProducto));
    }

    @PatchMapping("/{id}/remove-producto/{idProducto}")
    public ResponseEntity<PromocionResponse> removeProducto(
            @PathVariable Integer id,
            @PathVariable Integer idProducto) {
        return ResponseEntity.ok(promocionService.removeProducto(id, idProducto));
    }
}
