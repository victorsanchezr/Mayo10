package com.softtek.servicio;

import com.softtek.modelo.Lugar;
import com.softtek.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface ILugarServicio {
    List<Lugar> obtenerProducto() throws SQLException, ClassNotFoundException;

    Lugar obtenerUno(int id) throws SQLException, ClassNotFoundException;

    Lugar crearProducto(Lugar p) throws SQLException, ClassNotFoundException;
    Lugar actualizarProducto(Lugar p) throws SQLException, ClassNotFoundException;
    void deleteProducto(int id) throws SQLException, ClassNotFoundException;
}
