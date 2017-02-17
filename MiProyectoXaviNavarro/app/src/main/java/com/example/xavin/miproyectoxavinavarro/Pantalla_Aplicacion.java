package com.example.xavin.miproyectoxavinavarro;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pantalla_Aplicacion extends AppCompatActivity implements Fragment_Dinamico.OnFragmentInteractionListener {

    private Juegos[]listado;
    public ArrayList<Juegos> juegos= new ArrayList<Juegos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Button boton_comprar=(Button)findViewById(R.id.boton_comprar);
        setContentView(R.layout.activity_aplicacion);

        BDClients bdClients = new BDClients(this, "Usuarios", null, 1);
        SQLiteDatabase bd = bdClients.getWritableDatabase();

        //bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('Spiderman 3','aventuras','29.99')");
        //bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('World Of Warcraft','RPG,aventuras','15.99')");
        //bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('Rocket League','Futbol, Coches, Conducción','11.99')");
        //bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('DooM','Shooter','59.99')");
        //bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('Counter Strike: Global Offensive','Shooter','14.99')");
        //bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('Need for Speed','Conduccion','44.99')");
        //bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('Candy Crush','Entretenimiento','4.99')");

        Toast.makeText(getApplicationContext(),"completado",Toast.LENGTH_LONG).show();

        String[] campos = new String[] {"Titulo", "Genero", "Precio"};
        Cursor c = bd.query("Juegos", campos, null, null, null, null, null);
        listado=new Juegos[c.getCount()];
        int i=0;
        if (c.moveToFirst()) {
            do {
                String titulo = c.getString(0);
                String genero = c.getString(1);
                Double precio = c.getDouble(2);

                listado[i]= new Juegos(titulo,genero,precio);
                i++;
            } while (c.moveToNext());
        }

        AdaptadorJuegos adaptador = new AdaptadorJuegos(this);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Titulo: " + listado[position].getTitulo() + ", Genero: " + listado[position].getGenero()+ ", Precio: " +listado[position].getPrecio();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        bd.close();
        boton_comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle objetos= new Bundle();
                Juegos datos= new Juegos(listado[spinner.getSelectedItemPosition()].getTitulo(),
                        listado[spinner.getSelectedItemPosition()].getGenero(),
                        listado[spinner.getSelectedItemPosition()].getPrecio());
                objetos.putSerializable("informacion",datos);

                CheckBox cajapc=(CheckBox)findViewById(R.id.pc);
                CheckBox cajaps=(CheckBox)findViewById(R.id.playstation);
                CheckBox cajaxbox=(CheckBox)findViewById(R.id.xbox);
                RadioButton efectivo=(RadioButton)findViewById(R.id.efectivo);
                RadioButton paypal=(RadioButton)findViewById(R.id.paypal);
                RadioButton tarjeta=(RadioButton)findViewById(R.id.tarjeta);
                RadioGroup grupo=(RadioGroup)findViewById(R.id.rgroup);

                boolean selected1=false;
                boolean selected2=false;
                boolean selected3=false;
                if(cajapc.isChecked()){
                    selected1=true;
                }
                objetos.putBoolean("boolean1",selected1);
                objetos.putString("pc",cajapc.getText().toString());

                if(cajaps.isChecked()){
                    selected2=true;
                }
                objetos.putBoolean("boolean2",selected2);
                objetos.putString("playstation",cajaps.getText().toString());

                if(cajaxbox.isChecked()){
                    selected3=true;
                }
                objetos.putBoolean("boolean3",selected3);
                objetos.putString("xbox",cajaxbox.getText().toString());

                if(grupo.getCheckedRadioButtonId()==R.id.efectivo){
                    objetos.putString("grupo",efectivo.getText().toString());
                }else {
                    objetos.putString("grupo", tarjeta.getText().toString());
                    objetos.putString("grupo", paypal.getText().toString());
                }

                String usu= getIntent().getStringExtra("usuario");
                objetos.putSerializable("usuario",usu);

                FragmentManager fragmentmanager =getFragmentManager();
                FragmentTransaction transaction =fragmentmanager.beginTransaction();
                Fragment_Dinamico fragment= new Fragment_Dinamico();
                fragment.setArguments(objetos);
                transaction.add(R.id.activity_pantalla__aplicacion,fragment);
                transaction.commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_acerca:
                Intent acerca = new Intent(Pantalla_Aplicacion.this, Acerca.class);
                startActivity(acerca);
                return true;
            case R.id.menu_internet:
                Intent internet = new Intent(Pantalla_Aplicacion.this, Internet.class);
                startActivity(internet);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
        return true;
    }



    public class AdaptadorJuegos extends ArrayAdapter {
        Activity context;
        AdaptadorJuegos(Activity context) {
            super(context, R.layout.juegos, listado);
            this.context = context;
        }
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }
        public View getView(int i, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.juegos, null);
            TextView tit = (TextView) item.findViewById(R.id.titulojuego);
            tit.setText(listado[i].getTitulo());
            TextView gen = (TextView) item.findViewById(R.id.genero);
            gen.setText(listado[i].getGenero());

            TextView pre = (TextView) item.findViewById(R.id.precio);
            pre.setText(String.valueOf(listado[i].getPrecio()));
            return (item);
        }
    }
}