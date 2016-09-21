package com.example.mati.myapplication2;

import android.app.Notification;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    public static int COD_RESPUESTA=0;

    protected EditText miTexto;
    protected Button miBoton;
    protected TextView elSaludo;
    protected MediaPlayer sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        miBoton = (Button) findViewById(R.id.miBtn);
        elSaludo = (TextView) findViewById(R.id.miLbl);
        final EditText miTexto= (EditText)findViewById(R.id.miTxt);



        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);

                Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent,COD_RESPUESTA);

                showToast("Pulsado BOTON");
            }

        });
        sonido = MediaPlayer.create(this, R.raw.noup);
        sonido.start();
    }


    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void onActivityResult(int cod_resp, int cod_result,Intent intent){
        if (cod_result== RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            elSaludo.setText(otroBundle.getString("DEVUELTO"));
        }
    }





    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this,"onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}