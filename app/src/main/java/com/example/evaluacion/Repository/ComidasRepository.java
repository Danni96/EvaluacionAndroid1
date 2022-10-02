package com.example.evaluacion.Repository;

import com.example.evaluacion.Model.Comidas;

import java.util.ArrayList;
import java.util.List;

public class ComidasRepository {
    private List<Comidas> lstCarnes;
    private List<Comidas> lstEnsaladas;
    private List<Comidas> lstFrutas;

    public ComidasRepository(){
        lstCarnes = new ArrayList<>();
        lstEnsaladas = new ArrayList<>();
        lstFrutas = new ArrayList<>();
        ListaCarnes();
        ListaFrutas();
        ListaEnsaladas();
    }

    public void ListaCarnes(){
        lstCarnes.add(new Comidas("Pollo a la plancha"));
        lstCarnes.add(new Comidas("Carne asada"));
        lstCarnes.add(new Comidas("Carne en salsa de tomate"));
        lstCarnes.add(new Comidas("Carne guisada"));
        lstCarnes.add(new Comidas("Carne a la parrilla"));
    }

    public void ListaFrutas(){
        lstFrutas.add(new Comidas("Manzanas"));
        lstFrutas.add(new Comidas("Fresas"));
        lstFrutas.add(new Comidas("Bananas"));
        lstFrutas.add(new Comidas("Sandias"));
        lstFrutas.add(new Comidas("Piñas"));
    }

    public void ListaEnsaladas(){
        lstEnsaladas.add(new Comidas("Ensalada de atún"));
        lstEnsaladas.add(new Comidas("Ensalada caprese"));
        lstEnsaladas.add(new Comidas(" Ensalada griega"));
        lstEnsaladas.add(new Comidas("Ensalada alemana"));
        lstEnsaladas.add(new Comidas("Ensalada de patata"));
    }

    public List<Comidas> getAllCarnes(){
        return this.lstCarnes;
    }

    public List<Comidas> getAllFrutas(){
        return this.lstFrutas;
    }

    public List<Comidas> getAllEnsaladas(){
        return this.lstEnsaladas;
    }


}
