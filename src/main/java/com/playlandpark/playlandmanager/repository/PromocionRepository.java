package com.playlandpark.playlandmanager.repository;

import com.playlandpark.playlandmanager.model.entity.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PromocionRepository extends JpaRepository<Promocion, Integer> {

    Optional<Promocion> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);

    List<Promocion> findByActivoTrue();

    List<Promocion> findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqualAndActivoTrue(
            LocalDate hoyInicio,
            LocalDate hoyFin
    );
}
