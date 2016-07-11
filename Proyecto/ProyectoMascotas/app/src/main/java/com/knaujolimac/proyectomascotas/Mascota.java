package com.knaujolimac.proyectomascotas;

public class Mascota {

    private String nombreMascota;
    private int cantidadLikes;
    private int foto;

    public Mascota(int foto,String nombreMascota){
        this.nombreMascota = nombreMascota;
        this.foto = foto;
    }

    public Mascota(int foto,String nombreMascota,int cantidadLikes){
        this.nombreMascota = nombreMascota;
        this.foto = foto;
        this.cantidadLikes = cantidadLikes;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getCantidadLikes() {
        return cantidadLikes;
    }

    public void setCantidadLikes(int cantidadLikes) {
        this.cantidadLikes = cantidadLikes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
