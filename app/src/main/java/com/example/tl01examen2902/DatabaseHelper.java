package com.example.tl01examen2902;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper {

    public static final String NameDatabase = "DbContactos";
    public static final String NameTable= "Contactos";
    public static final String id = "ID";
    public static final String pais = "Pais";
    public static final String nombre = "Nombre";
    public static final String telefono = "Telefono";

    public static final String acerca = "Acerca";




    public static String CreateTbContactos = "CREATE TABLE Contactos (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " pais TEXT, nombre TEXT, telefono INTEGER, acerca TEXT )";

    public static String DropTbContactos = "DROP TABLE IF EXISTS Contactos";

}
