package com.softtek.servicio;

import com.softtek.modelo.Producto;
import com.softtek.repo.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{

    @Autowired
    private IProductoRepositorio genericoRepositorio;


    @Override
    public List<Producto> obtenerProducto() throws SQLException, ClassNotFoundException {
        return genericoRepositorio.findAll();
    }

    @Override
    public Producto obtenerUno(int id) throws SQLException, ClassNotFoundException {
        return genericoRepositorio.findById(id).orElse(new Producto());
    }

    @Override
    public Producto crearProducto(Producto p) throws SQLException, ClassNotFoundException {
        return genericoRepositorio.save(p);
    }

    @Override
    public Producto actualizarProducto(Producto p) throws SQLException, ClassNotFoundException {
        return genericoRepositorio.save(p);
    }

    @Override
    public void deleteProducto(int id) throws SQLException, ClassNotFoundException {
        genericoRepositorio.deleteById(id);
    }
}
