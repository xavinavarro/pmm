package com.example.mati.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        final TextView otroSaludo = (TextView) findViewById(R.id.miMensaje);

        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));

        final ImageButton miBotonVolver = (ImageButton) findViewById(R.id.botonVolver);
        miBotonVolver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(pantalla2.this, MainActivity.class);
                startActivity(miIntent);
            }
        }
    }
}
