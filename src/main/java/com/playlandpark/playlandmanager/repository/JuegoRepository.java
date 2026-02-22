package com.playlandpark.playlandmanager.repository;

import com.playlandpark.playlandmanager.model.entity.Juego;
import com.playlandpark.playlandmanager.model.enums.EstadoJuego;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JuegoRepository extends JpaRepository<Juego, Integer> {

    Optional<Juego> findByCodigo(String codigo);

    boolean existsByCodigo(String codigo);

    List<Juego> findByActivoTrue();

    List<Juego> findByEstado(EstadoJuego estado);

    List<Juego> findByEstadoAndActivoTrue(EstadoJuego estado);
}
