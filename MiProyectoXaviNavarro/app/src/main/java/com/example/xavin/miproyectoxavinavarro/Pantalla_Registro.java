package com.example.xavin.miproyectoxavinavarro;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Pantalla_Registro extends AppCompatActivity {

    private BDUsuarios cliBDh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro);

        Button registrarse=(Button)findViewById(R.id.registro);
        Button volver_login=(Button)findViewById(R.id.volver_login);
        final EditText registro_usuario=(EditText)findViewById(R.id.registro_usuario);
        final EditText registro_contraseña=(EditText)findViewById(R.id.registro_contraseña);

        //Abrimos la base de datos en modo escritura
        cliBDh = new BDUsuarios(this, "Usuarios", null, 1);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //se guarda los datos del registro en la base de datos de USUARIOS  Y CONTRASEÑAS

                //Obtenemos referencia a la base de datos para poder modificarla.
                SQLiteDatabase bd = cliBDh.getWritableDatabase();
                bd.execSQL("INSERT INTO Usuarios (usuario, password) VALUES ('"+registro_usuario.getText().toString()+"','"+registro_contraseña.getText().toString()+"')");
                bd.close();
                Intent volver= new Intent(Pantalla_Registro.this,MainActivity.class);
                startActivity(volver);
            }
        });

        volver_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retornar= new Intent(Pantalla_Registro.this,MainActivity.class);
                startActivity(retornar);
            }
        });
    }
}
