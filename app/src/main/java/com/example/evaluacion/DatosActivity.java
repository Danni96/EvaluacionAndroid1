package com.example.evaluacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DatosActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_Nombre, ed_Edad;
    private RadioButton rd_Masculino, rd_Femenino, rd_Otro;
    private Button bt_Siguiente;
    private RadioGroup rd_grupo_genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ed_Nombre = findViewById(R.id.txtNombre);
        ed_Edad = findViewById(R.id.txtEdad);
        rd_Masculino =  findViewById(R.id.rbMasculino);
        rd_Femenino =  findViewById(R.id.rbFemenino);
        rd_Otro =  findViewById(R.id.rbOtro);
        rd_grupo_genero = findViewById(R.id.rgGrupo);
        bt_Siguiente = findViewById(R.id.btnSiguiente);
        bt_Siguiente.setOnClickListener(this);
    }

    private void validar(){
        String nom = ed_Nombre.getText().toString();
        String ed = ed_Edad.getText().toString();

        if (nom.isEmpty() || ed.isEmpty() || rd_grupo_genero.getCheckedRadioButtonId() == -1){
            new AlertDialog.Builder(this).setTitle("¡Aviso!")
                    .setMessage("Se deben llenar todos los campos")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).show();
        }else {
            Intent intent = new Intent(this, SeleccionarActivity.class);
            intent.putExtra("nombre", ed_Nombre.getText().toString());
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSiguiente:
                validar();
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