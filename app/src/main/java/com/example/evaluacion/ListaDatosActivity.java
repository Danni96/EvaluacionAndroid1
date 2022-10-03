package com.example.evaluacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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

        if (lstPersona == null){
            lstPersona = new ArrayList<>();
        }
        comidas = new ComidasRepository();

        lsvComidas = findViewById(R.id.lsvComidas);
        nombre = getIntent().getStringExtra("nombre").toString();
        categoria = getIntent().getStringExtra("seleccion");
        btnGuardar = findViewById(R.id.btnGuardar);

        mostrarComidas();
        seleccionarComida();
        btnGuardar.setOnClickListener(view -> {
            agregarLista();
        });

    }

    public void mostrarComidas() {
        if (categoria.equals("Carnes")) {
            lsvComidas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comidas.getAllCarnes()));
        } else if (categoria.equals("Frutas")) {
            lsvComidas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comidas.getAllFrutas()));
        } else {
            lsvComidas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, comidas.getAllEnsaladas()));
        }
    }

    public void seleccionarComida() {
        lsvComidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String pos = lsvComidas.getItemAtPosition(i).toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaDatosActivity.this);
                builder.setTitle("Selección");
                builder.setMessage("¿Desea seleccionar esta opción?");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        plato = pos;
                    }
                });
                builder.setNegativeButton("Cancelar", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public void agregarLista() {
        lstPersona.add(new Persona(nombre, plato));
        confirmacionRegistro();
    }

    public void confirmacionRegistro() {
        new AlertDialog.Builder(this).setTitle("¡Registrado!").setMessage("Registro con éxito")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).show();
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