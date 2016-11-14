package com.example.mati.ejemplocanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ContextMenu;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto){
            super(contexto);
        }
        @Override
        protected void onDraw(Canvas canvas){

            Paint pincel = new Paint();
            pincel.setColor(Color.BLUE);
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150, 150, 80, pincel);
        }

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout);
            Lienzo fondo = new Lienzo(this);
            layout1.addView(fondo);
        }


        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.activity_main, menu);
            return true;
        }

        class Lienzo extends View {

            public Lienzo(Context context) {
                super(context);
            }

            protected void onDraw(Canvas canvas) {
                canvas.drawRGB(255, 255, 255);
                int ancho = canvas.getWidth();
                int alto = canvas.getHeight();
                Paint pincel1 = new Paint();
                pincel1.setARGB(255, 255, 0, 0);
                pincel1.setStyle(Paint.Style.STROKE);
                for (int f = 0; f < 10; f++) {
                    canvas.drawCircle(ancho / 2, alto / 2, f * 15, pincel1);
                }
            }
        }

    }
 }

