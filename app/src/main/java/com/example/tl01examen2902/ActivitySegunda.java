package com.example.tl01examen2902;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivitySegunda extends AppCompatActivity {


    EditText txtNombre, txtTelefono, txtAcerca;
    Button btnAgregar, btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtAcerca = (EditText) findViewById(R.id.txtAcerca);
        btnAgregar = (Button) findViewById(R.id.btnGuardar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivitySegunda.this, txtNombre.getText(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}