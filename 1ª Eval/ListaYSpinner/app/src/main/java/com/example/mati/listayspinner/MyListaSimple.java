package com.example.mati.listayspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyListaSimple extends AppCompatActivity
{
    ListView listView;
    final static String semana[] = {"Lunes","Martes","Miercoles","Jueves","Viernes", "Sabado","Domingo"};
    String mensaje = "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lista_simple);

        listView = (ListView) findViewById(R.id.lista1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,semana);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mensaje = "Item cliked =>"+ semana[position];
                mostrarToast("Has selecionado: "+listView.getItemAtPosition(position).toString());
            }
        });
    }
    private void mostrarToast(String cadena)
    {
        Toast toast = Toast.makeText(getApplicationContext(), cadena,Toast.LENGTH_SHORT);
        toast.show();
    }
}
