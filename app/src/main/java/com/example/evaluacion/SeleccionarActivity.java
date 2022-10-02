package com.example.evaluacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SeleccionarActivity extends AppCompatActivity {

    RadioButton rbCarnes, rbEnsalada, rbFrutas, seleccion;
    RadioGroup categorias;
    Button btnSiguiente;
    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = getIntent().getStringExtra("nombre");
        rbCarnes = findViewById(R.id.rbCarnes);
        rbEnsalada = findViewById(R.id.rbEnsaladas);
        rbFrutas = findViewById(R.id.rbFruta);
        categorias = findViewById(R.id.rgCategorias);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(view -> {
            agregarSeleccion();
        });
    }

    public void agregarSeleccion(){
        int id = categorias.getCheckedRadioButtonId();
        seleccion = findViewById(id);
        if (rbCarnes.isChecked() || rbFrutas.isChecked() || rbEnsalada.isChecked()){
            Intent intent = new Intent(this, ListaDatosActivity.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("seleccion", seleccion.getText().toString() );
            startActivity(intent);
        }else{
            Toast.makeText(this, "Debe seleccionar una opción", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}