package com.example.xavin.miproyectoxavinavarro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDUsuarios extends SQLiteOpenHelper {

    String consulta1= "CREATE TABLE Usuarios (usuario TEXT, password TEXT)";
    String consulta2= "CREATE TABLE Juegos (Titulo TEXT, Genero TEXT, Precio DOUBLE)";


    public BDUsuarios(Context contexto, String nombre, SQLiteDatabase.CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(consulta1);
        bd.execSQL(consulta2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {

        //Eliminamos la version anterior de la tabla
        //bd.execSQL("DROP TABLE IF EXISTS Usuarios");

        bd.execSQL(consulta1);
    }
}
