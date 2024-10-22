package com.example.app_EF_100Pampino_resiliencia.controller;

import com.example.app_EF_100Pampino_resiliencia.exception.ResourceNotFoundException;
import com.example.app_EF_100Pampino_resiliencia.model.Producto;
import com.example.app_EF_100Pampino_resiliencia.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/producto")
public class ProductoController {


    private IProductoService iProductoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listarProductos(){

        List<Producto> lista = iProductoService.obtenerProductos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto){
        return new ResponseEntity<>(iProductoService.guardarProducto(producto), HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Producto> actualizarProducto(
            @RequestParam Integer id,
            @RequestBody Producto producto
    ){
        Producto newProducto = iProductoService.buscarProductoXId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con Id "
                        + id +" no existe"));

        newProducto.setNombre(producto.getNombre());
        newProducto.setDescripcion(producto.getDescripcion());
        newProducto.setPrecio(producto.getPrecio());
        return new ResponseEntity<>(
                iProductoService.guardarProducto(newProducto),
                HttpStatus.OK
        );
    }

}
