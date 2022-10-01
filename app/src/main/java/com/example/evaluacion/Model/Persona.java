package com.example.evaluacion.Model;

public abstract class Persona {
    private String nombre;
    private String genero;
    private Integer edad;

    public Persona(String nombre, String genero, Integer edad) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
    }

    public Persona() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }


}
