package com.example.evaluacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.evaluacion.Model.Persona;
import com.example.evaluacion.Repository.ComidasRepository;

import java.util.ArrayList;
import java.util.List;

public class ListaDatosActivity extends AppCompatActivity {

    private ListView lsvComidas;
    Button btnGuardar;
    private String nombre, categoria, plato;

    public static List<Persona> lstPersona;
    ComidasRepository comidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_datos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lstPersona = new ArrayList<>();
        comidas = new ComidasRepository();

        lsvComidas = findViewById(R.id.lsvComidas);
        nombre = getIntent().getStringExtra("nombre").toString();
        categoria = getIntent().getStringExtra("seleccion");
        btnGuardar = findViewById(R.id.btnGuardar);

        MostrarComidas();

    }

    public void MostrarComidas(){
        if(categoria.equals("Carnes")){
            lsvComidas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comidas.getAllCarnes()));
        }else if(categoria.equals("Frutas")){
            lsvComidas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comidas.getAllFrutas()));
        }else{
            lsvComidas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comidas.getAllEnsaladas()));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}