package com.example.mati.listayspinner;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.zip.Inflater;

public class SpinnerPersona extends AppCompatActivity
{
    private Persona[] datos = new Persona[]
            {
                    new Persona("Jorge","hombre",19),
                    new Persona("Carlos","hombre",21),
                    new Persona("Susana","mujer",22)
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_persona);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_Persona);

        AdaptadorPersona adaptadorPersona = new AdaptadorPersona(this);
        spinner.setAdapter(adaptadorPersona);
         }
    static class ViewHolder
    {;
        TextView nombre;
        TextView sexo;
        TextView edad;
    }
    class AdaptadorPersona extends ArrayAdapter<Persona>
    {
        Activity context;
        AdaptadorPersona(Activity context)
        {
            super(context,R.layout.desplegable,datos);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {

           /*ViewHolder holder;

           if (view == null)
            {
                LayoutInflater inflater = context.getLayoutInflater();
               View view = inflater.inflate(R.layout.desplegable,null);
               holder = new ViewHolder();
                holder.nombre = (TextView) view.findViewById(R.id.txtViewNombre);
                holder.sexo = (TextView) view.findViewById(R.id.txtViewSexo);
                holder.edad = (TextView) view.findViewById(R.id.txtViewEdad);
                view.setTag(holder);
            }
            else {
                holder = (ViewHolder) view.getTag();
            }
             holder.nombre.setText(datos[position].getNombre());
            holder.sexo.setText(datos[position].getSexo());
            holder.edad.setText(datos[position].getEdad());*/

            LayoutInflater inflater = context.getLayoutInflater();
            View view = inflater.inflate(R.layout.desplegable,null);

            TextView Lnombre = (TextView) view.findViewById(R.id.txtViewNombre);
            TextView Lsexo = (TextView) view.findViewById(R.id.txtViewSexo);
            TextView Ledad = (TextView) view.findViewById(R.id.txtViewEdad);

            Lnombre.setText(datos[position].getNombre());
            Lsexo.setText(datos[position].getSexo());
            Ledad.setText(Integer.toString(datos[position].getEdad()));

            return view;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent)
        {
            View view = getView(position, convertView, parent);

            return view;

        }
    }
}
