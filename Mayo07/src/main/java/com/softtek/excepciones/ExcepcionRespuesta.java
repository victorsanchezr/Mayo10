package com.softtek.excepciones;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ExcepcionRespuesta {
    private LocalDateTime fechaYHora;
    private String mensaje;
    private String descripcion;
}
