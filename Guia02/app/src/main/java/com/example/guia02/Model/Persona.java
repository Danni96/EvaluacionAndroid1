package com.example.guia02.Model;

public class Persona {
    private int idpPersona;
    private String nombrePersona;
    private String apellidoPersona;

    public Persona(){

    }

    public Persona(int idPersona, String nombrePersona, String apellidoPersona) {
        this.idpPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
    }

    public int getIdpPersona() {
        return idpPersona;
    }

    public void setIdpPersona(int idpPersona) {
        this.idpPersona = idpPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    @Override
    public String toString() {
        return + idpPersona + " " + nombrePersona + " " + apellidoPersona;
    }
}
