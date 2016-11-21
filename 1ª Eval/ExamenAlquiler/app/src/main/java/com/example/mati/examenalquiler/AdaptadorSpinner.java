package com.example.mati.examenalquiler;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class AdaptadorSpinner extends ArrayAdapter<Coche>
{
    private TextView textViewModelo,textViewMarca,textViewPrecio;
    private Activity context;
    private Coche[] coches;
    public AdaptadorSpinner(Activity context, Coche[] destinos) {
        super(context, R.layout.content_spinner, destinos);
        this.context = context;
        this.coches = coches;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.content_spinner,null);
        }
        textViewModelo = (TextView) view.findViewById(R.id.textView_Spinner_Modelo);
        textViewMarca = (TextView) view.findViewById(R.id.textView_Spinner_Marca);
        textViewPrecio = (TextView) view.findViewById(R.id.textView_Spinner_Precio);

        textViewModelo.setText(coches[position].getModelo());
        textViewMarca.setText(coches[position].getMarca());
        textViewPrecio.setText(String.valueOf(coches[position].getPrecio()));

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = getView(position,convertView,parent);
        return view;
    }
}
