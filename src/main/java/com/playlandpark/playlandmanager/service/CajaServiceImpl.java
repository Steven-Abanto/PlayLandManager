package com.playlandpark.playlandmanager.service;

import com.playlandpark.playlandmanager.model.dto.caja.CajaAperturaRequest;
import com.playlandpark.playlandmanager.model.dto.caja.CajaCierreRequest;
import com.playlandpark.playlandmanager.model.dto.caja.CajaResponse;
import com.playlandpark.playlandmanager.model.entity.Caja;
import com.playlandpark.playlandmanager.repository.CajaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CajaServiceImpl implements CajaService {

    private static final String ESTADO_ABIERTA = "ABIERTA";
    private static final String ESTADO_CERRADA = "CERRADA";

    private final CajaRepository cajaRepository;

    @Override
    public CajaResponse open(CajaAperturaRequest request) {
        validateOpenRequest(request);

        String codCaja = request.codCaja().trim();

        boolean cajaAbiertaExiste = cajaRepository
                .findFirstByCodCajaAndEstadoOrderByIdCajaDesc(codCaja, ESTADO_ABIERTA)
                .isPresent();

        if (cajaAbiertaExiste) {
            throw new IllegalArgumentException(
                    "Ya existe una caja ABIERTA con el código: " + codCaja
            );
        }

        Caja caja = new Caja();
        caja.setCodCaja(request.codCaja().trim());
        caja.setUsuApertura(request.usuApertura().trim());
        caja.setMontoApertura(request.montoApertura());
        caja.setHoraApertura(LocalDateTime.now());
        caja.setEstado(ESTADO_ABIERTA);

        Caja saved = cajaRepository.save(caja);
        return mapToResponse(saved);
    }

    @Override
    public CajaResponse close(CajaCierreRequest request) {
        validateCloseRequest(request);

        Caja caja = cajaRepository.findFirstByCodCajaAndEstadoOrderByIdCajaDesc(request.codCaja().trim(), ESTADO_ABIERTA)
                .orElseThrow(() -> new IllegalArgumentException("Caja no encontrada: " + request.codCaja()));

        if (!ESTADO_ABIERTA.equalsIgnoreCase(caja.getEstado())) {
            throw new IllegalArgumentException("Solo se puede cerrar una caja en estado ABIERTA.");
        }

        caja.setUsuCierre(request.usuCierre().trim());
        caja.setMontoCierre(request.montoCierre());
        caja.setHoraCierre(LocalDateTime.now());

        caja.setEstado(ESTADO_CERRADA);

        Caja saved = cajaRepository.save(caja);
        return mapToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public CajaResponse findById(Integer idCaja) {
        Caja caja = cajaRepository.findById(idCaja)
                .orElseThrow(() -> new IllegalArgumentException("Caja no encontrada con id: " + idCaja));
        return mapToResponse(caja);
    }

    @Override
    @Transactional(readOnly = true)
    public CajaResponse findByCode(String codCaja) {
        if (codCaja == null || codCaja.isBlank()) {
            throw new IllegalArgumentException("El código de caja es obligatorio.");
        }

        Caja caja = cajaRepository.findFirstByCodCajaAndEstadoOrderByIdCajaDesc(codCaja.trim(), ESTADO_ABIERTA)
                .orElseGet(() -> cajaRepository.findByCodCaja(codCaja.trim())
                        .orElseThrow(() -> new IllegalArgumentException("Caja no encontrada con código: " + codCaja)));

        return mapToResponse(caja);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CajaResponse> findAll() {
        return cajaRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CajaResponse> findByStatus(String estado) {
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado es obligatorio.");
        }
        return cajaRepository.findByEstado(estado.trim().toUpperCase())
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ---------------- helpers ----------------

    private void validateOpenRequest(CajaAperturaRequest request) {
        if (request == null) throw new IllegalArgumentException("El request no puede ser nulo.");

        if (request.codCaja() == null || request.codCaja().isBlank())
            throw new IllegalArgumentException("El código de caja es obligatorio.");

        if (request.usuApertura() == null || request.usuApertura().isBlank())
            throw new IllegalArgumentException("El usuario de apertura es obligatorio.");

        if (request.montoApertura() == null)
            throw new IllegalArgumentException("El monto de apertura es obligatorio.");

        if (request.montoApertura().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("El monto de apertura no puede ser negativo.");
    }

    private void validateCloseRequest(CajaCierreRequest request) {
        if (request == null) throw new IllegalArgumentException("El request no puede ser nulo.");

        if (request.codCaja() == null)
            throw new IllegalArgumentException("El idCaja es obligatorio.");

        if (request.usuCierre() == null || request.usuCierre().isBlank())
            throw new IllegalArgumentException("El usuario de cierre es obligatorio.");

        if (request.montoCierre() == null)
            throw new IllegalArgumentException("El monto de cierre es obligatorio.");

        if (request.montoCierre().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("El monto de cierre no puede ser negativo.");
    }

    private CajaResponse mapToResponse(Caja c) {
        return new CajaResponse(
                c.getIdCaja(),
                c.getCodCaja(),
                c.getUsuApertura(),
                c.getMontoApertura(),
                c.getHoraApertura(),
                c.getUsuCierre(),
                c.getMontoCierre(),
                c.getHoraCierre(),
                c.getEstado()
        );
    }
}