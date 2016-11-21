package com.example.mati.examenalquiler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Logo extends View
{
    public Logo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Logo(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas){

        setBackgroundColor(Color.GRAY);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setTextSize(25);
        paint.setStrokeWidth(1);
        canvas.drawText("Ancho:"+getWidth()+" Alto:"+getHeight(),20,40,paint);


        paint.setStrokeWidth(5);
        //CIRCULO
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(352,250,50,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(352,250,50,paint);

        // 2 CIRCULOS PEQUEÑOS
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(332,250,15,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(332,250,5,paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(372,250,15,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(372,250,5,paint);

        // ARCO
        RectF rectF = new RectF(325,270,325+50,270+15);
        canvas.drawArc(rectF,0,180,false,paint);

        //RECTANGULO ROMBO
        Path pathRectangulo = new Path();
        pathRectangulo.moveTo(325,300);
        pathRectangulo.lineTo(375,300);
        pathRectangulo.lineTo(400,400);
        pathRectangulo.lineTo(300,400);
        pathRectangulo.lineTo(325,300);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(pathRectangulo,paint);

        pathRectangulo.moveTo(325,300);
        pathRectangulo.lineTo(375,300);
        pathRectangulo.lineTo(400,400);
        pathRectangulo.lineTo(300,400);
        pathRectangulo.lineTo(325,300);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(pathRectangulo,paint);
        // LINEAS
        paint.setColor(Color.BLACK);

        canvas.drawLine(380,320,455,375,paint);
        canvas.drawLine(320,320,255,375,paint);

        canvas.drawLine(331,400,321,500,paint);
        canvas.drawLine(371,400,371,500,paint);
        //TRIANGULO
        Path pathTriangulo  = new Path();
        pathTriangulo.moveTo(352,125);
        pathTriangulo.lineTo(425,225);
        pathTriangulo.lineTo(280,225);
        pathTriangulo.lineTo(352,125);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawPath(pathTriangulo,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawPath(pathTriangulo,paint);


        //TEXTO

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(1);
        paint.setTextSize(25);

        canvas.drawText("Bienvenido!",200,550,paint);



    }
}
