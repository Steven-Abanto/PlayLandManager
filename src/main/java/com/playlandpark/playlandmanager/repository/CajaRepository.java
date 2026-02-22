package com.playlandpark.playlandmanager.repository;

import com.playlandpark.playlandmanager.model.entity.Caja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CajaRepository extends JpaRepository<Caja, Integer> {

    Optional<Caja> findByCodCaja(String codCaja);

    boolean existsByCodCaja(String codCaja);

    List<Caja> findByEstado(String estado);

    Optional<Caja> findFirstByCodCajaAndEstadoOrderByIdCajaDesc(String codCaja, String estado);
}