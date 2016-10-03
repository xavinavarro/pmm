package com.example.mati.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    protected EditText miTexto;
    protected Button miBoton;
    protected TextView elSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miTexto = (EditText) findViewById(R.id.miTxt);
        miBoton = (Button) findViewById(R.id.miBtn);
        elSaludo = (TextView) findViewById(R.id.miLbl);


        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, pantalla2.class);

                Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);

                showToast("Pulsado BOTON");
            }

        });

    }

    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}