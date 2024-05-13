package com.softtek.controlador;

import com.softtek.modelo.Lugar;
import com.softtek.modelo.Producto;
import com.softtek.servicio.ILugarServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/lugar")

public class ControladorLugar {
    @Autowired
    private ILugarServicio lugarServicio;

    @GetMapping
    public List<Lugar> obtenerProcuto() throws SQLException, ClassNotFoundException {
        return lugarServicio.obtenerProducto();
    }

    @GetMapping("/{id}")
    public Lugar obtener1Procuto(@PathVariable(name = "id") Integer id) throws SQLException, ClassNotFoundException {
        return lugarServicio.obtenerUno(id);
    }

    @PutMapping
    public Lugar actualizarProducto(@Valid @RequestBody Lugar p) throws SQLException, ClassNotFoundException {
       return lugarServicio.actualizarProducto(p);
    }

    @PostMapping
    public Lugar crearProducto(@Valid @RequestBody Lugar p) throws SQLException, ClassNotFoundException {
        return lugarServicio.crearProducto(p);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@Valid @PathVariable int id) throws SQLException, ClassNotFoundException {
        lugarServicio.deleteProducto(id);
    }


}
