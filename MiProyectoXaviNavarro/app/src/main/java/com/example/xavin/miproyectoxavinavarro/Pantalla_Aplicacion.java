package com.example.xavin.miproyectoxavinavarro;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.MediaStore;
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
        setContentView(R.layout.activity_pantalla_aplicacion);

        final Button boton_comprar=(Button)findViewById(R.id.boton_comprar);

        BDUsuarios cliBDh = new BDUsuarios(this, "Usuarios", null, 1);

        SQLiteDatabase bd = cliBDh.getWritableDatabase();


        bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('Mass Effect Andromeda','rol,aventuras','49.99')");
        bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('The Witcher 3','RPG,aventuras','9.99')");
        bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('Horizon zero dawn','RPG,aventuras','49.99')");
        bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('Need for speed','conduccion','19.99')");
        bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('Minecraft','Aventura,Supervivencia','19.99')");
        bd.execSQL("INSERT INTO Juegos (Titulo, Genero, Precio) VALUES ('Assassins creed SAGA','Aventura,Accion,','114.99')");

        Toast.makeText(getApplicationContext(),"completado",Toast.LENGTH_LONG).show();

        String[] campos = new String[] {"Titulo", "Genero", "Precio"};
        Cursor c = bd.query("Juegos", campos, null, null, null, null, null);
        listado=new Juegos[c.getCount()];
        int i=0;
        //Nos aseguramos de que exista al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String titulo = c.getString(0);
                String genero = c.getString(1);
                Double precio=c.getDouble(2);

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
                //TODO PASAR EL TITULO,GENERO Y PRECIO AL FRAGMENT
                Bundle objetos= new Bundle();

                Juegos datos= new Juegos(listado[spinner.getSelectedItemPosition()].getTitulo(),
                        listado[spinner.getSelectedItemPosition()].getGenero(),
                        listado[spinner.getSelectedItemPosition()].getPrecio());

                objetos.putSerializable("informacion",datos);


                CheckBox caja1=(CheckBox)findViewById(R.id.caja_pc);
                CheckBox caja2=(CheckBox)findViewById(R.id.caja_play);
                CheckBox caja3=(CheckBox)findViewById(R.id.caja_xbox);
                RadioButton efectivo=(RadioButton)findViewById(R.id.pago_efectivo);
                RadioButton tarjeta=(RadioButton)findViewById(R.id.pago_tarjeta);
                RadioGroup grupo=(RadioGroup)findViewById(R.id.radiogroup);

                boolean selected1=false;
                boolean selected2=false;
                boolean selected3=false;
                if(caja1.isChecked()){
                    selected1=true;
                }
                objetos.putBoolean("boolean1",selected1);
                objetos.putString("caja_pc",caja1.getText().toString());

                if(caja2.isChecked()){
                    selected2=true;
                }
                objetos.putBoolean("boolean2",selected2);
                objetos.putString("caja_play",caja2.getText().toString());

                if(caja3.isChecked()){
                    selected3=true;
                }
                objetos.putBoolean("boolean3",selected3);
                objetos.putString("caja_xbox",caja3.getText().toString());

                if(grupo.getCheckedRadioButtonId()==R.id.pago_efectivo){
                    objetos.putString("grupo",efectivo.getText().toString());
                }else {
                    objetos.putString("grupo", tarjeta.getText().toString());
                }

                //obtener la instancia del administrador de fragmentos
                FragmentManager fragmentmanager =getFragmentManager();

                //crear la transaccion
                FragmentTransaction transaction =fragmentmanager.beginTransaction();

                //crear un nuevo ojbeto de nuestro fragment y añadirlo
                Fragment_Dinamico fragment= new Fragment_Dinamico();
                fragment.setArguments(objetos);

                transaction.add(R.id.activity_pantalla__aplicacion,fragment);

                //confirmar el cambio
                transaction.commit();

            }
        });

    }

    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
        return true;
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


    @Override
    public void onFragmentInteraction(Uri uri) {

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

            TextView tit = (TextView) item.findViewById(R.id.juego_titulo);
            tit.setText(listado[i].getTitulo());

            TextView gen = (TextView) item.findViewById(R.id.juego_genero);
            gen.setText(listado[i].getGenero());

            TextView pre = (TextView) item.findViewById(R.id.juego_precio);
            pre.setText(String.valueOf(listado[i].getPrecio()));

            return (item);
        }
    }
}
