package com.example.app_EF_100Pampino_resiliencia.service;

import com.example.app_EF_100Pampino_resiliencia.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    List<Producto> obtenerProductos();
    Optional<Producto> buscarProductoXId(Integer id);
    Producto guardarProducto(Producto p);
}
