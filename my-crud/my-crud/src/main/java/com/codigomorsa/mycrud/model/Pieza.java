package com.codigomorsa.mycrud.model;


public class Pieza {

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCosto() {
        return costo;
    }


    public final String codigo;

    public final String descripcion;


    public final int costo;




    public Pieza(String codigo, String descripcion, int costo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
    }
}
