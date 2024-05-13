package com.softtek.controlador;

import com.softtek.dto.ProductoDTO;
import com.softtek.excepciones.ExcepcionPersonalizadaNoEncontrada;
import com.softtek.modelo.Producto;
import com.softtek.servicio.IProductoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/producto")

public class ControladorProducto {
    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> obtenerProducto() {
        List<Producto> productosBBDD = productoServicio.obtenerProducto();
        List<ProductoDTO> productosDto = new ArrayList<>();

        for (Producto producto: productosBBDD) {
            ProductoDTO pDto = new ProductoDTO();
            productosDto.add(pDto.castProductoDTO(producto));
        }
        return new ResponseEntity<>(productosDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerUno(@PathVariable(name = "id") int idProducto) {
        Producto p1 = productoServicio.obtenerUno(idProducto);
        if (p1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrada("PRODUCTO NO ENCONTRADO " + idProducto);
        }
        return new ResponseEntity<>((new ProductoDTO()).castProductoDTO(p1), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@Valid @RequestBody ProductoDTO p) {
        Producto p1 = p.castProducto();
        p1 = productoServicio.crearProducto(p1);
        return new ResponseEntity<>(p.castProductoDTO(p1), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductoDTO> actualizarProducto(@Valid @RequestBody ProductoDTO p) {
        Producto p1 = productoServicio.obtenerUno(p.getId());
        if (p1 == null) {
            throw new ExcepcionPersonalizadaNoEncontrada("Producto no encontrado " + p.getId());
        }
        return new ResponseEntity<>(p.castProductoDTO(p1), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable(name = "id") int idProducto) {
        Producto p = productoServicio.obtenerUno(idProducto);
        if(p == null) {
            throw new ExcepcionPersonalizadaNoEncontrada("PRODUCTO NO ENCONTRADO " + idProducto);
        }
        productoServicio.deleteProducto(idProducto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
