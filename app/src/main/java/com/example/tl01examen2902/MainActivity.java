package com.example.tl01examen2902;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.tl01examen2902.configuracion.SQLiteConnection;
import com.example.tl01examen2902.tablas.Contactos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    SQLiteConnection connection;
    ListView listContactos;
    ArrayList<Contactos> list;
    ArrayList<String> ArrayContactos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connection = new SQLiteConnection(this, DatabaseHelper.NameDatabase, null, 1);
        listContactos = (ListView) findViewById(R.id.listContactos);
        ObtenerListContactos();

        ArrayAdapter adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ArrayContactos);
        listContactos.setAdapter(adp);


    }


    private void ObtenerListContactos() {
        SQLiteDatabase db = connection.getReadableDatabase();
        Contactos person = null;
        list = new ArrayList<Contactos>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.NameTable, null);

        while(cursor.moveToNext()){
            person = new Contactos();
            person.setId(cursor.getInt(0));
            person.setNombre(cursor.getString(1));
            person.setTelefono(cursor.getInt(2));
            person.setPais(cursor.getString(3));
            person.setAcerca(cursor.getString(4));

            list.add(person);

            fillList();
        }

        cursor.close();
    }

    private void fillList() {
        ArrayContactos = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++){
            ArrayContactos.add(list.get(i).getId() + " | " +
                    list.get(i).getNombre() + " | " +
                    list.get(i).getId());
        }
    }
}