package com.playlandpark.playlandmanager.controller;

import com.playlandpark.playlandmanager.model.dto.cliente.ClienteRequest;
import com.playlandpark.playlandmanager.model.dto.cliente.ClienteResponse;
import com.playlandpark.playlandmanager.model.dto.summary.ClienteSummary;
import com.playlandpark.playlandmanager.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponse> create(@RequestBody ClienteRequest request) {
        ClienteResponse response = clienteService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @GetMapping("/document/{numeDoc}")
    public ResponseEntity<ClienteResponse> findByDocument(@PathVariable String numeDoc) {
        return ResponseEntity.ok(clienteService.findByDocument(numeDoc));
    }

    @GetMapping("/email/{correo}")
    public ResponseEntity<ClienteResponse> findByEmail(@PathVariable String correo) {
        return ResponseEntity.ok(clienteService.findByEmail(correo));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAll(
            @RequestParam(defaultValue = "false") boolean onlyActive
    ) {
        return ResponseEntity.ok(clienteService.findAll(onlyActive));
    }

    @GetMapping("/summary")
    public ResponseEntity<List<ClienteSummary>> findAllSummary(
            @RequestParam(defaultValue = "false") boolean onlyActive
    ) {
        return ResponseEntity.ok(clienteService.findAllSummary(onlyActive));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> update(
            @PathVariable Integer id,
            @RequestBody ClienteRequest request
    ) {
        return ResponseEntity.ok(clienteService.update(id, request));
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<Void> logicDelete(@PathVariable Integer id) {
        clienteService.logicDelete(id);
        return ResponseEntity.noContent().build();
    }
}