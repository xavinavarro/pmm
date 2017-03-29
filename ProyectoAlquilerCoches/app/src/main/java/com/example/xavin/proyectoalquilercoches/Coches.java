package com.example.xavin.proyectoalquilercoches;

import java.io.Serializable;


public class Coches implements Serializable {
    private String modelo,marca;
    private String precio;
    private int View;


    public Coches(String modelo, String marca,String precio,int mg){
        this.modelo=modelo;
        this.marca=marca;
        this.precio=precio;
        this.View=mg;

    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public int getView() {
        return View;
    }
    public void setView(int view) {
        View = view;
    }

    @Override
    public String toString() {
        return "Coches{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio='" + precio + '\'' +
                ", View=" + View +
                '}';
    }
}
