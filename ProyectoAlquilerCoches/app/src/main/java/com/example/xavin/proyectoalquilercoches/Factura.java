package com.example.xavin.proyectoalquilercoches;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Factura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        TextView resultado_marca=(TextView)findViewById(R.id.resultado_marca);
        TextView resultado_modelo=(TextView)findViewById(R.id.resultado_modelo);
        TextView resultado_precio=(TextView)findViewById(R.id.resultado_precio);
        TextView resultado_caja=(TextView)findViewById(R.id.resultado_cajas);
        TextView resultado_radio=(TextView)findViewById(R.id.resultado_radios);
        TextView resultado_precio_introducido=(TextView)findViewById(R.id.resultado_precio_introducido);
        TextView resultado_coste=(TextView)findViewById(R.id.resultado_coste);
        TextView resultado_extra=(TextView)findViewById(R.id.extras);
        ImageView resultado_imagen=(ImageView)findViewById(R.id.resultado_imagen);

        Bundle miBundle = getIntent().getExtras();
        Coches coche = (Coches) miBundle.getSerializable("informacion");

        resultado_marca.setText("marca "+coche.getMarca());
        resultado_modelo.setText("modelo "+coche.getModelo());
        resultado_precio.setText("Precio por Hora "+coche.getPrecio());
        resultado_imagen.setImageDrawable(getDrawable(coche.getView()));

        if(getIntent().getExtras().getBoolean("boolean1")==true){
            resultado_caja.setText(getIntent().getStringExtra("caja_aire"));
        }
        if(getIntent().getExtras().getBoolean("boolean2")==true){
            resultado_caja.setText(resultado_caja.getText()+" , " + getIntent().getStringExtra("caja_gps"));
        }
        if(getIntent().getExtras().getBoolean("boolean3")==true){
            resultado_caja.setText(resultado_caja.getText()+" , " + getIntent().getStringExtra("caja_radio"));
        }

        resultado_radio.setText(resultado_radio.getText() + getIntent().getStringExtra("grupo"));
        resultado_precio_introducido.setText("tiempo introducido "+getIntent().getExtras().getString("horas"));
        resultado_extra.setText("Extras :"+getIntent().getExtras().getString("Extra") );

        if (resultado_radio.getText().equals("SEGURO TODO RIESGO")) {
            resultado_coste.setText("TOTAL :" + String.valueOf(getIntent().getStringExtra("total2"))+ "€ ");

        }else
            resultado_coste.setText("TOTAL :" + String.valueOf(getIntent().getStringExtra("total")) + "€ ");
    }
}
