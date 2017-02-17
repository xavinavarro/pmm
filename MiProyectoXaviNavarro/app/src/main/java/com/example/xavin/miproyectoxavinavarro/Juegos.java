package com.example.xavin.miproyectoxavinavarro;

import java.io.Serializable;

/**
 * Created by Jon on 17/01/2017.
 */

public class Juegos implements Serializable{

    String titulo,genero;
    Double precio;

    public Juegos(String tit, String gen, Double pre){
        this.titulo=tit;
        this.genero=gen;
        this.precio=pre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Juegos{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                '}';
    }
}
