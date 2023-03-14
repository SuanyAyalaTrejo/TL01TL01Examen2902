package com.example.tl01examen2902;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;

public class MainActivity extends AppCompatActivity {



    Button btnAdd, btnList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnList = (Button) findViewById(R.id.btnList);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page1 = new Intent(getApplicationContext(), ActivitySegunda.class);
                startActivity(page1);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page2 = new Intent(getApplicationContext(), ActivityList.class);
                startActivity(page2);
            }
        });
    }

}