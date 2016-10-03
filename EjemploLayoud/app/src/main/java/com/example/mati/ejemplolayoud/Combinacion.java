package com.example.mati.ejemplolayoud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Combinacion extends AppCompatActivity {

    protected Button boton2;
    protected TextView miTexto;
    protected Button button1;
    protected Button button2;
    protected Button button3;
    protected Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinacion);

        button1=(Button)findViewById(R.id.boton1);
        miTexto=(TextView)findViewById(R.id.miTexto);

        button1.setOnClickListener(new View.OnClickListener(){
        public void onClick (View v){
            miTexto.setText("Has pulsado el boton");
            Intent miIntent = new Intent(Combinacion.this, Pantalla2.class);
            }
        });

        boton2=(Button)findViewById(R.id.boton2);


        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

    }
}
