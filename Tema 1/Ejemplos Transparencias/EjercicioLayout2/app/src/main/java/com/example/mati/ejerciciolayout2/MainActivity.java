package com.example.mati.ejerciciolayout2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected TextView miTexto;
    protected Button button1;
    protected Button button2;
    protected Button button3;
    protected Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                miTexto.setText("Has pulsado el boton");
                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
            }
        });


        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

    }
}
