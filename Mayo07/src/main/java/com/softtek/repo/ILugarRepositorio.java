package com.softtek.repo;

import com.softtek.modelo.Lugar;
import com.softtek.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ILugarRepositorio extends JpaRepository<Lugar,Integer> {

}
