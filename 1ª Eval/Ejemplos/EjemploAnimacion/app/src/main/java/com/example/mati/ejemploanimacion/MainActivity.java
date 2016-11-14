package com.example.mati.ejemploanimacion;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends Activity {
    AnimationDrawable animacion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        animacion = (AnimationDrawable) getResources().getDrawable(R.drawable.animacion);

        ImageView imagen = new ImageView(this);

        imagen.setBackgroundColor(Color.WHITE);

        imagen.setImageDrawable(animacion);
        setContentView(imagen);
    }

    public boolean onTouchEvent(MotionEvent evento) {

        if (evento.getAction() == MotionEvent.ACTION_DOWN) {
            animacion.start();
            return true;
        }
        return super.onTouchEvent(evento);
    }
}