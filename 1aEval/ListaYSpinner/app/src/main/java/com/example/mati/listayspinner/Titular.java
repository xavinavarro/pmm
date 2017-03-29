package com.example.mati.listayspinner;

public class Titular
{
    private String titulo;
    private String subtitulo;
    private int imagen;
    public Titular(String titulo, String subtitulo, int imagen)
    {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.imagen = imagen;
    }
    public Titular (String titulo, String subtitulo)
    {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
