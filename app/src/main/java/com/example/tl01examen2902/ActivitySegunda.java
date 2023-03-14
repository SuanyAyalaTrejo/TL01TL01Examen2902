package com.example.tl01examen2902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tl01examen2902.configuracion.SQLiteConnection;

public class ActivitySegunda extends AppCompatActivity {


    EditText Nombre, Telefono, Acerca, ID;

    Spinner Pais;
    Button btnGuardar, btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Nombre = (EditText) findViewById(R.id.txtNombre);
        Telefono = (EditText) findViewById(R.id.txtTelefono);
        Pais = (Spinner) findViewById(R.id.cmbPais);
        Acerca = (EditText) findViewById(R.id.txtAcerca);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        ID = (EditText) findViewById(R.id.txtID);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarContactos();

            }
        });

        //Spinner Pais = (Spinner) findViewById(R.id.cmbPais);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pais_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        Pais.setAdapter(adapter);
        btnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                CancelarAgregar();
            }
        });
    }

    private void CancelarAgregar() {
        CleanScreen();
    }

    private void AgregarContactos() {
        SQLiteConnection connection = new SQLiteConnection(this,
                DatabaseHelper.NameDatabase,
                null,
                1);

        SQLiteDatabase db = connection.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.nombre, Nombre.getText().toString());
        values.put(DatabaseHelper.telefono, Telefono.getText().toString());
        values.put(DatabaseHelper.pais, Pais.getSelectedItem().toString());
        values.put(DatabaseHelper.acerca, Acerca.getText().toString());
        values.put(DatabaseHelper.id, ID.getText().toString());


        Long result = db.insert(DatabaseHelper.NameTable, DatabaseHelper.id, values);

        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();

        CleanScreen();
    }

    private void CleanScreen() {
        Nombre.setText("");
        Telefono.setText("");
        Pais.setSelection(0);
        Acerca.setText("");

    }


}