package com.example.evaluacion.Model;

public  class Persona {
    private String nombre;
    private String genero;
    private Integer edad;
    private String comidaFavoria;

    public Persona(String nombre, String comidaFavorita) {
        this.nombre = nombre;
        this.comidaFavoria = comidaFavorita;
    }

    public Persona() {
        this.genero = "M";
        this.edad = 0;
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

    public String getComidaFavoria() {
        return comidaFavoria;
    }

    public void setComidaFavoria(String comidaFavoria) {
        this.comidaFavoria = comidaFavoria;
    }

    @Override
    public String toString() {
        return "Persona " + this.nombre;
    }


}
