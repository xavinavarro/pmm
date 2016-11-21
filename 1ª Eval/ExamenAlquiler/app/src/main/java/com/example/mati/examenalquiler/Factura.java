package com.example.mati.examenalquiler;

import java.io.Serializable;


public class Factura implements Serializable
{
    private String modelo;
    private String marca;
    private String tipoSeguro = "Sin Seguro";
    private String TipoExtra = "";

    private double preciomodelo;
    private double precioSeguro;
    private double horas;
    private double precio;
    private boolean seguro = false;

    public Factura(){}


    public double getPreciomodelo() {
        return preciomodelo;
    }

    public void setPreciomodelo(double preciomodelo) {
        this.preciomodelo = preciomodelo;
    }

    public double getHoras() {
        return horas;
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

    public void setMarca(String marca) { this.marca = marca;  }

    public String getTipoExtra() {
        return TipoExtra;
    }

    public void setTipoExtra(String TipoExtra) {
        this.TipoExtra = TipoExtra;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public boolean getSeguro(){ return seguro;  }




    public double getPrecioFinal() {
        if (preciomodelo!=0)
        {
            if (seguro == Boolean.TRUE){
                precio = (this.preciomodelo * horas + precioSeguro);
            }
            return preciomodelo;
        }else {
            return 0;
        }
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

}
