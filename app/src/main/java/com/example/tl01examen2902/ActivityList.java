package com.example.tl01examen2902;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.tl01examen2902.configuracion.SQLiteConnection;
import com.example.tl01examen2902.tablas.Contactos;
import com.example.tl01examen2902.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import android.content.Intent;
import android.widget.Toast;

public class ActivityList extends AppCompatActivity {

    SQLiteConnection connection;
    ListView listContactos;
    ArrayList<Contactos> list;
    ArrayList<String> ArrayContactos;

    Button btnAgregar;
    Button btnLlamar;
    Button btnCompartir;
   EditText txtNombre;
   EditText txtTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        connection = new SQLiteConnection(this, DatabaseHelper.NameDatabase, null, 1);
        listContactos = (ListView) findViewById(R.id.listContactos);
        ObtenerListContactos();

        ArrayAdapter adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ArrayContactos);
        listContactos.setAdapter(adp);


        btnLlamar =(Button) findViewById(R.id.btnLlamar);
        btnLlamar.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_CALL);//llamad
            Uri.parse("Numero: " + txtTelefono);
            startActivity(intent);
            }
        });

        btnCompartir =(Button) findViewById(R.id.btnCompartir);
        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Nombre: " + txtNombre +"Numero: " + txtTelefono);
                sendIntent.setType("Text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });






        btnAgregar =(Button) findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();}



        });

    }
    public void openNewActivity(){
        Intent intent = new Intent(this, ActivitySegunda.class);
        startActivity(intent);
    }


    private void ObtenerListContactos() {
        SQLiteDatabase db = connection.getReadableDatabase();
        Contactos person = null;
        list = new ArrayList<Contactos>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.NameTable, null);

        while(cursor.moveToNext()){
            person = new Contactos();

            person.setPais(cursor.getString(0));
            person.setNombre(cursor.getString(1));
            person.setTelefono(cursor.getInt(2));
            person.setAcerca(cursor.getString(3));

            list.add(person);
        }

        cursor.close();

        fillList();
    }

    private void fillList() {
        ArrayContactos = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++){
            ArrayContactos.add(list.get(i).getPais() + " | "+
                    list.get(i).getPais() + " | " +
                    list.get(i).getNombre() + " | " +
                    list.get(i).getTelefono() + " | " +
                    list.get(i).getAcerca() + " | " ) ;
        }
    }

    }


