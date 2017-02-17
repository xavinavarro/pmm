package com.example.xavin.miproyectoxavinavarro;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Pantalla_Registro extends AppCompatActivity {

    private BDClients bdClients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final EditText r_usuario=(EditText)findViewById(R.id.r_usuario);
        final EditText r_contraseña=(EditText)findViewById(R.id.r_contraseña);
        Button register=(Button)findViewById(R.id.register);
        Button volver=(Button)findViewById(R.id.volver);

        bdClients = new BDClients(this, "Usuarios", null, 1);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = bdClients.getWritableDatabase();
                bd.execSQL("INSERT INTO Usuarios (usuario, password) VALUES ('"+r_usuario.getText().toString()+"','"+r_contraseña.getText().toString()+"')");
                bd.close();
                Intent volver= new Intent(Pantalla_Registro.this,MainActivity.class);
                startActivity(volver);
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retornar= new Intent(Pantalla_Registro.this,MainActivity.class);
                startActivity(retornar);
            }
        });
    }
}