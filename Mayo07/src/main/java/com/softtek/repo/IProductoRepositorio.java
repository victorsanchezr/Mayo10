package com.softtek.repo;

import com.softtek.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductoRepositorio extends JpaRepository<Producto,Integer> {

}
