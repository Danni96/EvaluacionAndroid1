package com.example.guia02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.guia02.MainActivity.lstPersona;

import com.example.guia02.Model.Persona;

public class ListaPersonasActivity extends AppCompatActivity {

    private ListView lstVistaPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personas);



        lstVistaPersonas = findViewById(R.id.lsvPersonas);



        lstVistaPersonas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lstPersona));

    }
}