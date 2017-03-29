package com.example.mati.listayspinner;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MyListaObjetos extends AppCompatActivity
{

    private Titular[] datos = new Titular[]
    {
        new Titular("Batman Begins","batman",R.drawable.batman_begins),
        new Titular("Batman The Dark Knight","batman",R.drawable.batman_the_dark_knight),
        new Titular("Batman The Dark Knight Rises","batman",R.drawable.batman_the_dark_knight_rises)
    };
    private ListView miLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lista_objetos);


        miLista = (ListView) findViewById(R.id.listView);

        AdaptadorTitulares adaptadorTitulares = new AdaptadorTitulares(this);

        miLista.setAdapter(adaptadorTitulares);



    }
    class AdaptadorTitulares extends ArrayAdapter
    {
        Activity context;
        AdaptadorTitulares(Activity context)
        {
            super(context,R.layout.activity_my_lista_objetos,datos);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                view = inflater.inflate(R.layout.activity_my_lista_objetos, null);
            }

            TextView textViewTitulo = (TextView) view.findViewById(R.id.txtViewTitulo);
            TextView textViewSubtitulo = (TextView) view.findViewById(R.id.txtViewSubtitulo);
            ImageView imageViewCartel = (ImageView) view.findViewById(R.id.imgView);

            textViewTitulo.setText(datos[position].getTitulo());
            textViewSubtitulo.setText(datos[position].getSubtitulo());
            imageViewCartel.setImageResource(datos[position].getImagen());

            return view;
        }


    }
}

