package com.example.tl01examen2902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
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
        ID = (EditText) findViewById(R.id.txtID);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarContactos();

            }
        });

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