package com.example.mati.listayspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MySpinnerSimple extends AppCompatActivity
{
    private TextView textViewResultado;
    final static String semana[] = {"Lunes","Martes","Miercoles","Jueves","Viernes", "Sabado","Domingo"};
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_spinner_simple);

        spinner = (Spinner) findViewById(R.id.spinner);
        textViewResultado = (TextView) findViewById(R.id.txtViewResultado);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,semana);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                textViewResultado.setText("Has seleccionado : "+semana[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
