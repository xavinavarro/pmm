package com.example.mati.primerdibujo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   /* class MiDibujo extends View
    {
        public MiDibujo(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.BLACK);

            Paint cuadradoRojo = new Paint();
            Paint cuadradoAzul = new Paint();
            Paint cuadradoVerde = new Paint();
            Paint cuadradoAmarillo = new Paint();
            Paint circulo = new Paint();
            Paint cuadradoCentral = new Paint();

            cuadradoRojo.setColor(Color.RED);
            cuadradoRojo.setStrokeWidth(100);
            cuadradoRojo.setStyle(Paint.Style.STROKE);

            cuadradoAzul.setColor(Color.CYAN);
            cuadradoAzul.setStrokeWidth(100);
            cuadradoAzul.setStyle(Paint.Style.STROKE);

            cuadradoVerde.setColor(Color.GREEN);
            cuadradoVerde.setStrokeWidth(100);
            cuadradoVerde.setStyle(Paint.Style.STROKE);

            cuadradoAmarillo.setColor(Color.YELLOW);
            cuadradoAmarillo.setStrokeWidth(100);super(context, attrs);
            cuadradoAmarillo.setStyle(Paint.Style.STROKE);

            cuadradoCentral.setColor(Color.CYAN);
            cuadradoCentral.setStrokeWidth(15);
            cuadradoCentral.setStyle(Paint.Style.STROKE);


            circulo.setColor(Color.MAGENTA);
            circulo.setStrokeWidth(20);super(context, attrs);
            circulo.setStyle(Paint.Style.STROKE);

            canvas.drawPoint(200,200,cuadradoRojo);
            canvas.drawPoint(890,200,cuadradoAzul);
            canvas.drawCircle(550,500,275,circulo);
            canvas.drawPoint(200,800,cuadradoVerde);
            canvas.drawPoint(890,800,cuadradoAmarillo);
            canvas.drawPoint(550,500,cuadradoCentral);
super(context, attrs);
            //OTROS...

            Paint arco = new Paint();

            arco.setColor(Color.WHITE);
            arco.setStrokeWidth(100);
            arco.setStyle(Paint.Style.STROKE);
        }
    } */
}

