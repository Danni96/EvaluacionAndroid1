package com.example.evaluacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.evaluacion.Model.Persona;

import static com.example.evaluacion.ListaDatosActivity.lstPersona;

import java.util.ArrayList;

public class ListaGustosActivity extends AppCompatActivity {

    ListView lsvGustos;
    ArrayList<String> lstNueva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_gustos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lsvGustos = findViewById(R.id.lsvGustos);

        lstNueva = new ArrayList<>();

        for (int i = 0; i < lstPersona.size(); i++) {
            String addList = lstPersona.get(i).toString();
            lstNueva.add(addList);
        }
        ArrayAdapter<Persona> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lstNueva);
        lsvGustos.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        eliminarPersona();

        //lsvGustos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lstNueva));

        //eliminarPersona();
        //quitarLista();
    }

    public void eliminarPersona() {
        lsvGustos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object pos = lsvGustos.getItemAtPosition(i).toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaGustosActivity.this);
                builder.setTitle("Confirmación");
                builder.setMessage("¿Desea eliminar esta opción?");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int ii) {
                        //lstNueva.remove(i);
                    }
                });
                builder.setNegativeButton("Cancelar", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

//    public void quitarLista() {
//        lstNueva.remove(posicionBorrar);
//        Toast.makeText(this, "Registro eliminado", Toast.LENGTH_SHORT).show();
//    }

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