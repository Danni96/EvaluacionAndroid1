package com.example.guia02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import static com.example.guia02.MainActivity.lstPersona;

import com.example.guia02.Model.Persona;

public class AgregarPersonaActivity extends AppCompatActivity  implements View.OnClickListener {

    private EditText edtID,edtNombre,edtApellido;
    private Button btnAgregar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);

        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtID = findViewById(R.id.edtID);
        btnAgregar = findViewById(R.id.btnAgregarPersonas);
        btnAgregar.setOnClickListener(this);
    }
    private void agregar(int idpPersona,String nombre ,String apellido){
        Persona persona = new Persona(idpPersona,nombre,apellido);
        lstPersona.add(persona);
        new AlertDialog.Builder(this).
                setTitle("Confimacion").
                setMessage("Registro exitoso").
                setPositiveButton("ok", (dialogInterface, i) -> {

                }).show();
        ;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAgregarPersonas:{
                agregar(Integer.parseInt(edtID.getText().toString()),
                        edtNombre.getText().toString(),
                        edtApellido.getText().toString());
            }break;
        }
    }
}