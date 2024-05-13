package com.softtek.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre_producto")
    private String nombre_producto;
    @Column(name = "id_suministrador")
    private int id_suministrador;
    @Column(name = "id_categoria")
    private int id_categoria;
    @Column(name = "cantidad")
    private String cantidad;

}
