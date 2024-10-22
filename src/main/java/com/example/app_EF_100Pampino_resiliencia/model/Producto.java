package com.example.app_EF_100Pampino_resiliencia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean disponible;
}
