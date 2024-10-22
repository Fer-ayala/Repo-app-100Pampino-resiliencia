package com.example.app_EF_100Pampino_resiliencia.repository;

import com.example.app_EF_100Pampino_resiliencia.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
