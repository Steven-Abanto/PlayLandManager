package com.playlandpark.playlandmanager.service;

import com.playlandpark.playlandmanager.model.dto.cliente.ClienteRequest;
import com.playlandpark.playlandmanager.model.dto.cliente.ClienteResponse;
import com.playlandpark.playlandmanager.model.dto.summary.ClienteSummary;
import com.playlandpark.playlandmanager.model.entity.Cliente;
import com.playlandpark.playlandmanager.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse create(ClienteRequest request) {
        validateRequiredForCreate(request);

        String correoNorm = normalizeEmail(request.correo());

        if (clienteRepository.existsByNumeDoc(request.numeDoc())) {
            throw new IllegalArgumentException("El número de documento ya está registrado: " + request.numeDoc());
        }
        if (clienteRepository.existsByCorreoIgnoreCase(correoNorm)) {
            throw new IllegalArgumentException("El correo ya está registrado: " + request.correo());
        }
        if (request.telefono() != null && !request.telefono().isBlank()
                && clienteRepository.existsByTelefono(request.telefono().trim())) {
            throw new IllegalArgumentException("El teléfono ya está registrado: " + request.telefono());
        }

        Cliente cliente = new Cliente();
        applyRequestToEntity(cliente, request);

        if (cliente.getActivo() == null) cliente.setActivo(true);
        cliente.setCorreo(correoNorm);

        Cliente saved = clienteRepository.save(cliente);
        return mapToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteResponse findById(Integer idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con id: " + idCliente));
        return mapToResponse(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteResponse findByDocument(String numeDoc) {
        if (numeDoc == null || numeDoc.isBlank()) {
            throw new IllegalArgumentException("El número de documento es obligatorio.");
        }
        Cliente cliente = clienteRepository.findByNumeDoc(numeDoc.trim())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con documento: " + numeDoc));
        return mapToResponse(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteResponse findByEmail(String correo) {
        if (correo == null || correo.isBlank()) {
            throw new IllegalArgumentException("El correo es obligatorio.");
        }
        String correoNorm = normalizeEmail(correo);
        Cliente cliente = clienteRepository.findByCorreoIgnoreCase(correoNorm)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con correo: " + correo));
        return mapToResponse(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteResponse> findAll(boolean onlyActive) {
        List<Cliente> list = onlyActive ? clienteRepository.findByActivoTrue() : clienteRepository.findAll();
        return list.stream().map(this::mapToResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteSummary> findAllSummary(boolean onlyActive) {
        List<Cliente> list = onlyActive ? clienteRepository.findByActivoTrue() : clienteRepository.findAll();
        return list.stream().map(this::mapToSummary).toList();
    }

    @Override
    public ClienteResponse update(Integer idCliente, ClienteRequest request) {
        if (request == null) throw new IllegalArgumentException("El request no puede ser nulo.");

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con id: " + idCliente));

        // Unicidad si se intenta cambiar
        if (request.numeDoc() != null && !request.numeDoc().isBlank()
                && !request.numeDoc().trim().equals(cliente.getNumeDoc())
                && clienteRepository.existsByNumeDoc(request.numeDoc().trim())) {
            throw new IllegalArgumentException("El número de documento ya está registrado: " + request.numeDoc());
        }

        if (request.correo() != null && !request.correo().isBlank()) {
            String correoNorm = normalizeEmail(request.correo());
            if (!correoNorm.equalsIgnoreCase(cliente.getCorreo())
                    && clienteRepository.existsByCorreoIgnoreCase(correoNorm)) {
                throw new IllegalArgumentException("El correo ya está registrado: " + request.correo());
            }
        }

        if (request.telefono() != null && !request.telefono().isBlank()) {
            String tel = request.telefono().trim();
            if (cliente.getTelefono() == null || !tel.equals(cliente.getTelefono())) {
                if (clienteRepository.existsByTelefono(tel)) {
                    throw new IllegalArgumentException("El teléfono ya está registrado: " + request.telefono());
                }
            }
        }

        applyRequestToEntity(cliente, request);

        // Normaliza email si vino
        if (request.correo() != null && !request.correo().isBlank()) {
            cliente.setCorreo(normalizeEmail(request.correo()));
        }

        Cliente updated = clienteRepository.save(cliente);
        return mapToResponse(updated);
    }

    @Override
    public void logicDelete(Integer idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con id: " + idCliente));

        cliente.setActivo(false);
        clienteRepository.save(cliente);
    }

    // -------------------- helpers --------------------

    private void validateRequiredForCreate(ClienteRequest request) {
        if (request == null) throw new IllegalArgumentException("El request no puede ser nulo.");

        if (request.tipoDoc() == null || request.tipoDoc().isBlank())
            throw new IllegalArgumentException("El tipo de documento es obligatorio.");

        if (request.numeDoc() == null || request.numeDoc().isBlank())
            throw new IllegalArgumentException("El número de documento es obligatorio.");

        if (request.correo() == null || request.correo().isBlank())
            throw new IllegalArgumentException("El correo es obligatorio.");

        if (request.direccion() == null || request.direccion().isBlank())
            throw new IllegalArgumentException("La dirección es obligatoria.");
    }

    private void applyRequestToEntity(Cliente cliente, ClienteRequest request) {

        if (request.tipoDoc() != null) cliente.setTipoDoc(request.tipoDoc());
        if (request.numeDoc() != null) cliente.setNumeDoc(request.numeDoc().trim());

        if (request.nombre() != null) cliente.setNombre(request.nombre());
        if (request.apePaterno() != null) cliente.setApePaterno(request.apePaterno());
        if (request.apeMaterno() != null) cliente.setApeMaterno(request.apeMaterno());
        if (request.genero() != null) cliente.setGenero(request.genero());
        if (request.fechaNac() != null) cliente.setFechaNac(request.fechaNac());

        if (request.correo() != null) cliente.setCorreo(request.correo()); // se normaliza afuera
        if (request.telefono() != null) cliente.setTelefono(request.telefono().isBlank() ? null : request.telefono().trim());

        if (request.direccion() != null) cliente.setDireccion(request.direccion());

        if (request.activo() != null) cliente.setActivo(request.activo());
    }

    private String normalizeEmail(String correo) {
        return correo.trim().toLowerCase();
    }

    private ClienteResponse mapToResponse(Cliente c) {
        return new ClienteResponse(
                c.getIdCliente(),
                c.getTipoDoc(),
                c.getNumeDoc(),
                c.getNombre(),
                c.getApePaterno(),
                c.getApeMaterno(),
                c.getGenero(),
                c.getFechaNac(),
                c.getCorreo(),
                c.getTelefono(),
                c.getDireccion(),
                c.getActivo()
        );
    }

    private ClienteSummary mapToSummary(Cliente c) {
        return new ClienteSummary(
                c.getIdCliente(),
                c.getTipoDoc(),
                c.getNumeDoc(),
                c.getNombre(),
                c.getApePaterno(),
                c.getApeMaterno(),
                c.getCorreo()
        );
    }
}