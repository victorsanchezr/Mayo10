package com.softtek.excepciones;

public class ExcepcionPersonalizadaNoEncontrada extends RuntimeException{
    public ExcepcionPersonalizadaNoEncontrada(String mensaje){
        super(mensaje);
    }
}
