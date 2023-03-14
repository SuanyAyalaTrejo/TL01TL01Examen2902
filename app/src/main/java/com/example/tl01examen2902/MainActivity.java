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



    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, ActivityList.class);
        startActivity(intent);
    }
}