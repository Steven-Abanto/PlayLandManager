package com.playlandpark.playlandmanager.service;

import com.playlandpark.playlandmanager.model.dto.producto.ProductoRequest;
import com.playlandpark.playlandmanager.model.dto.producto.ProductoResponse;
import com.playlandpark.playlandmanager.model.dto.summary.ProductoSummary;
import com.playlandpark.playlandmanager.model.entity.Producto;
import com.playlandpark.playlandmanager.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public ProductoResponse create(ProductoRequest request) {
        validateRequiredForCreate(request);

        String sku = request.sku().trim();
        String upc = request.upc().trim();

        if (productoRepository.existsBySku(sku)) {
            throw new IllegalArgumentException("El SKU ya está registrado: " + sku);
        }
        if (productoRepository.existsByUpc(upc)) {
            throw new IllegalArgumentException("El UPC ya está registrado: " + upc);
        }

        Producto producto = new Producto();
        applyRequestToEntity(producto, request);

        // defaults
        if (producto.getEsServicio() == null) producto.setEsServicio(false);
        if (producto.getActivo() == null) producto.setActivo(true);

        producto.setSku(sku);
        producto.setUpc(upc);

        Producto saved = productoRepository.save(producto);
        return mapToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoResponse findById(Integer idProducto) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con id: " + idProducto));
        return mapToResponse(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoResponse findBySku(String sku) {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("El SKU es obligatorio.");
        }
        Producto producto = productoRepository.findBySku(sku.trim())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con SKU: " + sku));
        return mapToResponse(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoResponse findByUpc(String upc) {
        if (upc == null || upc.isBlank()) {
            throw new IllegalArgumentException("El UPC es obligatorio.");
        }
        Producto producto = productoRepository.findByUpc(upc.trim())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con UPC: " + upc));
        return mapToResponse(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoResponse> findAll(boolean onlyActive) {
        List<Producto> list = onlyActive ? productoRepository.findByActivoTrue() : productoRepository.findAll();
        return list.stream().map(this::mapToResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoSummary> findAllSummary(boolean onlyActive) {
        List<Producto> list = onlyActive ? productoRepository.findByActivoTrue() : productoRepository.findAll();
        return list.stream().map(this::mapToSummary).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoResponse> findByServiceType(boolean esServicio, boolean onlyActive) {
        List<Producto> list = onlyActive
                ? productoRepository.findByEsServicioAndActivoTrue(esServicio)
                : productoRepository.findByEsServicio(esServicio);

        return list.stream().map(this::mapToResponse).toList();
    }

    @Override
    public ProductoResponse update(Integer idProducto, ProductoRequest request) {
        if (request == null) throw new IllegalArgumentException("El request no puede ser nulo.");

        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con id: " + idProducto));

        // Unicidad si se intenta cambiar
        if (request.sku() != null && !request.sku().isBlank()) {
            String sku = request.sku().trim();
            if (!sku.equals(producto.getSku()) && productoRepository.existsBySku(sku)) {
                throw new IllegalArgumentException("El SKU ya está registrado: " + sku);
            }
        }

        if (request.upc() != null && !request.upc().isBlank()) {
            String upc = request.upc().trim();
            if (!upc.equals(producto.getUpc()) && productoRepository.existsByUpc(upc)) {
                throw new IllegalArgumentException("El UPC ya está registrado: " + upc);
            }
        }

        // Validaciones de negocio si llegan valores
        if (request.precio() != null && request.precio().signum() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (request.stockMin() != null && request.stockMin() < 0) {
            throw new IllegalArgumentException("El stock mínimo no puede ser negativo.");
        }
        if (request.stockAct() != null && request.stockAct() < 0) {
            throw new IllegalArgumentException("El stock actual no puede ser negativo.");
        }

        applyRequestToEntity(producto, request);

        // normalizar sku/upc si vinieron
        if (request.sku() != null && !request.sku().isBlank()) producto.setSku(request.sku().trim());
        if (request.upc() != null && !request.upc().isBlank()) producto.setUpc(request.upc().trim());

        Producto updated = productoRepository.save(producto);
        return mapToResponse(updated);
    }

    @Override
    public void logicDelete(Integer idProducto) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con id: " + idProducto));

        producto.setActivo(false);
        productoRepository.save(producto);
    }

    // -------------------- helpers --------------------

    private void validateRequiredForCreate(ProductoRequest request) {
        if (request == null) throw new IllegalArgumentException("El request no puede ser nulo.");

        if (request.precio() == null) throw new IllegalArgumentException("El precio es obligatorio.");
        if (request.precio().signum() < 0) throw new IllegalArgumentException("El precio no puede ser negativo.");

        if (request.stockMin() == null) throw new IllegalArgumentException("El stock mínimo es obligatorio.");
        if (request.stockMin() < 0) throw new IllegalArgumentException("El stock mínimo no puede ser negativo.");

        if (request.stockAct() == null) throw new IllegalArgumentException("El stock actual es obligatorio.");
        if (request.stockAct() < 0) throw new IllegalArgumentException("El stock actual no puede ser negativo.");

        if (request.upc() == null || request.upc().isBlank()) throw new IllegalArgumentException("El UPC es obligatorio.");
        if (request.sku() == null || request.sku().isBlank()) throw new IllegalArgumentException("El SKU es obligatorio.");
    }

    private void applyRequestToEntity(Producto producto, ProductoRequest request) {
        if (request.descripcion() != null) producto.setDescripcion(request.descripcion());
        if (request.categoria() != null) producto.setCategoria(request.categoria());
        if (request.marca() != null) producto.setMarca(request.marca());

        if (request.precio() != null) producto.setPrecio(request.precio());

        if (request.stockMin() != null) producto.setStockMin(request.stockMin());
        if (request.stockAct() != null) producto.setStockAct(request.stockAct());

        if (request.uniMedida() != null) producto.setUniMedida(request.uniMedida());

        if (request.upc() != null) producto.setUpc(request.upc()); // se normaliza afuera
        if (request.sku() != null) producto.setSku(request.sku()); // se normaliza afuera

        if (request.esServicio() != null) producto.setEsServicio(request.esServicio());
        if (request.activo() != null) producto.setActivo(request.activo());
    }

    private ProductoResponse mapToResponse(Producto p) {
        return new ProductoResponse(
                p.getIdProducto(),
                p.getDescripcion(),
                p.getCategoria(),
                p.getMarca(),
                p.getPrecio(),
                p.getStockMin(),
                p.getStockAct(),
                p.getUniMedida(),
                p.getUpc(),
                p.getSku(),
                p.getEsServicio(),
                p.getActivo()
        );
    }

    private ProductoSummary mapToSummary(Producto p) {
        return new ProductoSummary(
                p.getIdProducto(),
                p.getDescripcion(),
                p.getPrecio(),
                p.getEsServicio(),
                p.getActivo()
        );
    }
}