package com.example.mati.primerdibujo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mati on 7/11/16.
 */
public class VistaAMedida extends View
{
    private ShapeDrawable miDrawable;
    public VistaAMedida(Context context){
        super(context);
    }

    public VistaAMedida(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int x=500;
        int y=1200;
        int ancho=300;
        int alto=150;
        miDrawable = new ShapeDrawable(new RectShape());
        miDrawable.getPaint().setColor(0xff0000ff);
        miDrawable.setBounds(x,y,x+ancho,y+alto);
        miDrawable.draw(canvas);

        /*Con canvas..*/
        setBackgroundColor(Color.BLACK);
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
        cuadradoAmarillo.setStrokeWidth(100);
        cuadradoAmarillo.setStyle(Paint.Style.STROKE);

        cuadradoCentral.setColor(Color.CYAN);
        cuadradoCentral.setStrokeWidth(15);
        cuadradoCentral.setStyle(Paint.Style.STROKE);


        circulo.setColor(Color.MAGENTA);
        circulo.setStrokeWidth(20);
        circulo.setStyle(Paint.Style.STROKE);

        canvas.drawPoint(200,200,cuadradoRojo);
        canvas.drawPoint(890,200,cuadradoAzul);
        canvas.drawCircle(550,500,275,circulo);
        canvas.drawPoint(200,800,cuadradoVerde);
        canvas.drawPoint(890,800,cuadradoAmarillo);
        canvas.drawPoint(550,500,cuadradoCentral);

    }


}
