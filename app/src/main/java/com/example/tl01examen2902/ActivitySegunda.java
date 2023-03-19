package com.example.tl01examen2902;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tl01examen2902.configuracion.SQLiteConnection;

public class ActivitySegunda extends AppCompatActivity {


    EditText Nombre, Telefono, Acerca;

    Spinner Pais;
    Button btnGuardar;
    Button btnCancelar;
    ImageButton btnimagen;
    private static final int PICK_IMAGE = 100;
    ImageView imgAvatar;
Uri ImageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        try {


            imgAvatar = (ImageView) findViewById(R.id.imgAvatar);

            Nombre = (EditText) findViewById(R.id.txtNombre);
            Telefono = (EditText) findViewById(R.id.txtTelefono);
            Pais = (Spinner) findViewById(R.id.cmbPais);
            Acerca = (EditText) findViewById(R.id.txtAcerca);
            btnGuardar = (Button) findViewById(R.id.btnGuardar);
            btnCancelar = (Button) findViewById(R.id.btnCancelar);

            ActivityResultLauncher<Intent> camaraLaucher= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==RESULT_OK);
                    Bundle extras = result.getData().getExtras();
                    Bitmap imgbitma = (Bitmap) extras.get("data");
                    imgAvatar.setImageBitmap( imgbitma);
                }
            });
            btnimagen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    camaraLaucher.launch (new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
                }
            });

            btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AgregarContactos();

                }
            });





        }







        catch (Exception ex)
        {
            Toast.makeText(this, ex.toString(),Toast.LENGTH_SHORT).show();
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pais_array, android.R.layout.simple_spinner_item);

       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

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

        values.put(DatabaseHelper.pais, Pais.getSelectedItem().toString());
        values.put(DatabaseHelper.nombre, Nombre.getText().toString());
        values.put(DatabaseHelper.telefono, Telefono.getText().toString());
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

