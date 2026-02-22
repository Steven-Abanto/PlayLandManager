package com.playlandpark.playlandmanager.repository;

import com.playlandpark.playlandmanager.model.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    Optional<Cargo> findByRol(String rol);
    boolean existsByRol(String rol);
}