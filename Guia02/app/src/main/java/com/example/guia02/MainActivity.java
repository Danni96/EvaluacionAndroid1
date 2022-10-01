package com.example.guia02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.guia02.Model.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAgregar, btnMostrar, btnDatos;

    public static List<Persona> lstPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPersona = new ArrayList<>();

        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(this);
        btnMostrar = findViewById(R.id.btnMostrar);
        btnMostrar.setOnClickListener(this);
        btnDatos = findViewById(R.id.btnDatos);
        btnDatos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAgregar:
                // Agregar
               Intent intent1 = new Intent(this,AgregarPersonaActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnMostrar:
                Intent intent2 = new Intent(this, ListaPersonasActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnDatos:
                Intent intent3 = new Intent(this, DatosActivity.class);
                startActivity(intent3);
                break;
        }
    }
}