package com.example.app_EF_100Pampino_resiliencia.service;

import com.example.app_EF_100Pampino_resiliencia.model.Producto;
import com.example.app_EF_100Pampino_resiliencia.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductoService implements IProductoService {

    private ProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerProductos() {
        if(Math.random()>0.5) {
            return productoRepository.findAll();
        }
        throw new RuntimeException("Error en llamada");
    }

    @Override
    public Optional<Producto> buscarProductoXId(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto guardarProducto(Producto p) {
        return productoRepository.save(p);
    }
}
