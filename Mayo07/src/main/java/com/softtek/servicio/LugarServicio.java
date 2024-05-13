package com.softtek.servicio;

import com.softtek.modelo.Lugar;
import com.softtek.repo.ILugarRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LugarServicio implements ILugarServicio{

    @Autowired
    private ILugarRepositorio lugarServicio;


    @Override
    public List<Lugar> obtenerProducto() throws SQLException, ClassNotFoundException {
        return lugarServicio.findAll();
    }

    @Override
    public Lugar obtenerUno(int id) throws SQLException, ClassNotFoundException {
        return lugarServicio.findById(id).orElse(new Lugar());
    }

    @Override
    public Lugar crearProducto(Lugar p) throws SQLException, ClassNotFoundException {
        return lugarServicio.save(p);
    }

    @Override
    public Lugar actualizarProducto(Lugar p) throws SQLException, ClassNotFoundException {
        return lugarServicio.save(p);
    }

    @Override
    public void deleteProducto(int id) throws SQLException, ClassNotFoundException {
        lugarServicio.deleteById(id);
    }
}
