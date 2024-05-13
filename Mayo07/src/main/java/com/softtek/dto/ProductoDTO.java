package com.softtek.dto;

import com.softtek.modelo.Producto;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoDTO {
    private int id;

    @NotEmpty
    @Size(min = 3 , max=50)
    private String nombre_producto;
    @NotNull
    private int id_suministrador;
    @NotNull
    private int id_categoria;
    @NotEmpty
    @Size(min = 10 , max=100)
    private String cantidad;

    public Producto castProducto(){
        Producto p1 = new Producto();
        p1.setId(id);
        p1.setCantidad(cantidad);
        p1.setNombre_producto(nombre_producto);
        p1.setId_suministrador(id_suministrador);
        p1.setId_categoria(id_categoria);

        return p1;

    }

    public ProductoDTO castProductoDTO(Producto e){
    id = e.getId();
    cantidad = e.getCantidad();
    nombre_producto = e.getNombre_producto();
    id_suministrador = e.getId_suministrador();
    id_categoria = e.getId_categoria();
    return this;

    }

}
