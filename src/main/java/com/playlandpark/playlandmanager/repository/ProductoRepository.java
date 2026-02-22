package com.playlandpark.playlandmanager.repository;

import com.playlandpark.playlandmanager.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Optional<Producto> findBySku(String sku);
    Optional<Producto> findByUpc(String upc);

    boolean existsBySku(String sku);
    boolean existsByUpc(String upc);

    List<Producto> findByActivoTrue();
    List<Producto> findByEsServicio(Boolean esServicio);
    List<Producto> findByEsServicioAndActivoTrue(Boolean esServicio);
}
