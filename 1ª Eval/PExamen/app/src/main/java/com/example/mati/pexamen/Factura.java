package com.example.mati.pexamen;

import java.io.Serializable;


public class Factura implements Serializable
{
    private String zona;
    private String continente;
    private String tipoTarifa = "Normal";
    private String tipoDecoracion = "";

    private double precioZona;
    private double pesoPaquete;
    private double precioPaquete;
    private double precioFinal;
    private boolean esUrgente = false;

    public Factura(){}


    public double getPrecioZona() {
        return precioZona;
    }

    public void setPrecioZona(double precioZona) {
        this.precioZona = precioZona;
    }

    public double getPesoPaquete() {
        return pesoPaquete;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTipoDecoracion() {
        return tipoDecoracion;
    }

    public void setTipoDecoracion(String tipoDecoracion) {
        this.tipoDecoracion = tipoDecoracion;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(String tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    public boolean getUrgente(){
        return esUrgente;
    }
    public double getPrecioFinal() {
        if (precioZona!=0)
        {
            if (esUrgente == Boolean.TRUE){
                precioFinal = (this.precioZona + (precioPorKilos(this.pesoPaquete)) + (this.precioZona * 0.3));
            }
            else {
                precioFinal = this.precioZona + precioPorKilos(this.pesoPaquete);
            }
            return precioZona;
        }else {
            return 0;
        }
    }
    private double precioPorKilos(double pesoPaquete)
    {
        if (pesoPaquete <= 5){
            precioPaquete = pesoPaquete * 1;
        }else if (pesoPaquete >= 6 && pesoPaquete <= 10){
            precioPaquete = pesoPaquete * 1.5;
        } else {
            precioPaquete = precioPaquete * 2;
        }
        return precioPaquete;
    }
    public void setPesoPaquete(double pesoPaquete) {
        this.pesoPaquete = pesoPaquete;
    }
    public void setUrgente(boolean esUrgente){
        this.esUrgente = esUrgente;
    }

}
