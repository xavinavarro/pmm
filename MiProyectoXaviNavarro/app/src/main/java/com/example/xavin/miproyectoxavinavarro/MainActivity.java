package com.example.xavin.miproyectoxavinavarro;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BDClients bdClients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button entrar= (Button)findViewById(R.id.Entrar);
        Button formulario= (Button)findViewById(R.id.ir_a_registro);
        final EditText ver_user=(EditText)findViewById(R.id.ver_user);
        final EditText ver_password=(EditText)findViewById(R.id.ver_password);

        bdClients = new BDClients(this, "Usuarios", null, 1);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = bdClients.getWritableDatabase();

                String usuario=ver_user.getText().toString();
                String contraseña=ver_password.getText().toString();

                Cursor fila=bd.rawQuery("SELECT usuario,password FROM Usuarios WHERE usuario='"+usuario+"' and password='"+contraseña+"'",null);

                if(fila.moveToFirst()) {
                    String usu = fila.getString(0);
                    String pass = fila.getString(1);

                    if (usuario.equals(usu)&&contraseña.equals(pass)) {

                        Intent adelante= new Intent(MainActivity.this,Pantalla_Aplicacion.class);
                        adelante.putExtra("usuario", usu);
                        startActivity(adelante);
                    }else {
                        Toast.makeText(getApplicationContext(),"completado",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        formulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventana = new Intent(MainActivity.this,Pantalla_Registro.class);
                startActivity(ventana);
            }
        });
    }
}