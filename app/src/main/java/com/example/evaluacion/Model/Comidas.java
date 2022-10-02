package com.example.evaluacion.Model;

public class Comidas {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Comidas(String nombre) {
        this.nombre = nombre;
    }

    public Comidas(){
        this.nombre = "";
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
