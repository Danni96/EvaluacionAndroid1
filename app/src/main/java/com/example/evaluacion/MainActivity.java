package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.evaluacion.ListaDatosActivity.lstPersona;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button Agregar, Salir, MostrarGustos, Acerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Agregar = findViewById(R.id.btnAgregar);
        Agregar.setOnClickListener(this);
        MostrarGustos = findViewById(R.id.btnMostrarLista);
        MostrarGustos.setOnClickListener(this);
        Acerca = findViewById(R.id.btnAcercaDe);
        Acerca.setOnClickListener(this);
        Salir = findViewById(R.id.btnSalir);
        Salir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAgregar: {
                Intent i1 = new Intent(this, DatosActivity.class);
                startActivity(i1);
                break;
            }
            case R.id.btnMostrarLista: {
                Intent i2 = new Intent(this, ListaGustosActivity.class);
                startActivity(i2);
                break;
            }
            case R.id.btnAcercaDe: {
                Intent i3 = new Intent(this, AcercaDeActivity.class);
                startActivity(i3);
                finish();
                break;
            }
            case R.id.btnSalir: {
                /*new AlertDialog.Builder(this).setTitle("¡Aviso!")
                        .setMessage("¿Desea saliar de la app?")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }).show();*/
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("¡AVISO!").setMessage("¿Desea salir de la app?");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Cancelar", null);
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            }
        }
    }
}