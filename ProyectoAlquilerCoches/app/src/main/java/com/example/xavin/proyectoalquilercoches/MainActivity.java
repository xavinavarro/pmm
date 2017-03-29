package com.example.xavin.proyectoalquilercoches;
import android.app.Activity;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int[] Ford={R.drawable.fiesta1,R.drawable.fiesta2,R.drawable.fiesta3};
    private int[] Ferrari={R.drawable.ferrari1,R.drawable.ferrari2,R.drawable.ferrari3};
    private int[] Leon={R.drawable.leon1,R.drawable.leon2,R.drawable.leon3};
    private int[] Megan={R.drawable.megan1,R.drawable.megan3};

    Random randomimagenes= new Random();
    int aleatorio=randomimagenes.nextInt(3);

    private Coches[] coche=new Coches[]{
            new Coches("Megane","Seat","20",Ford[aleatorio]),
            new Coches("X-11","Ferrari","100",Ferrari[aleatorio]),
            new Coches("Leon","Seat","30",Leon[aleatorio]),
            new Coches("Ford","Fiesta","40",Megan[aleatorio])
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton radio1 =(RadioButton)findViewById(R.id.radio_sin_seguro);
        final RadioButton radio2 =(RadioButton)findViewById(R.id.radio_riesgo);
        final RadioGroup grupo =(RadioGroup)findViewById(R.id.radio_grupo);

        final EditText horas = (EditText)findViewById(R.id.texto_horas);
        final CheckBox caja = (CheckBox)findViewById(R.id.caja_aire);
        final CheckBox caja_gps = (CheckBox)findViewById(R.id.caja_gps);
        final CheckBox caja_radio = (CheckBox)findViewById(R.id.caja_radio);

        final Button boton = (Button)findViewById(R.id.boton_calcular);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventana = new Intent(MainActivity.this,Factura.class);
                Bundle objeto = new Bundle();

                TextView marca_texto=(TextView)findViewById(R.id.resultado_marca);
                TextView modelo_texto=(TextView)findViewById(R.id.resultado_modelo);
                TextView precio_texto=(TextView)findViewById(R.id.resultado_precio);
                ImageView imagen=(ImageView) findViewById(R.id.resultado_imagen);

                final Spinner spinner=(Spinner)findViewById(R.id.spinner);

                Coches datos = new Coches(coche[spinner.getSelectedItemPosition()].getModelo(),
                        coche[spinner.getSelectedItemPosition()].getMarca(),
                        coche[spinner.getSelectedItemPosition()].getPrecio(),
                        coche[spinner.getSelectedItemPosition()].getView());

                boolean selected1 = false;
                boolean selected2 = false;
                boolean selected3 = false;

                if(caja.isChecked()){
                    selected1 = true;
                    TextView check1 = (TextView) findViewById(R.id.caja_aire);
                    check1.setText(caja.getText());
                }

                if(caja_gps.isChecked()){
                    selected2 = true;
                    TextView check2 = (TextView) findViewById(R.id.caja_gps);
                    check2.setText((caja_gps.getText()));
                }
                if(caja_radio.isChecked()){
                    selected3 = true;
                    TextView check3 = (TextView) findViewById(R.id.caja_radio);
                    check3.setText((caja_radio.getText()));
                }

                String nombre;

                TextView radio1 = (TextView) findViewById(R.id.radio_sin_seguro);
                radio1.setText(radio1.getText());
                nombre=radio1.getText().toString();
                ventana.putExtra("grupo", nombre);

                if (grupo.getCheckedRadioButtonId() == R.id.radio_riesgo) {
                    TextView radio2 = (TextView) findViewById(R.id.radio_riesgo);
                    radio2.setText((radio2.getText()));
                    nombre=radio2.getText().toString();
                    ventana.putExtra("grupo", nombre);
                }
                //Precio del peso y pasarlo
                double preciohora = 0;
                double cost=0;

                Double.parseDouble(horas.getText().toString());
                preciohora = Double.parseDouble(horas.getText().toString())*Double.parseDouble(precio_texto.getText().toString());
                if (caja.isChecked()){
                    cost+=50;
                }
                if (caja_gps.isChecked()){
                    cost+=50;
                }
                if (caja_radio.isChecked()){
                    cost+=50;
                }

                //PASO EL COSTE FIJO POR TIEMPO Y LAS HORAS INTRODUCIDAS

                double total=preciohora+cost;//SI ES SIN SEGURO
                double total2=(preciohora+cost)*1.20;// SI ES CON SEGURO A TODOD RIESGO

                ventana.putExtra("total",String.valueOf(total));
                ventana.putExtra("total2",String.valueOf(total2));
                ventana.putExtra("Extra",String.valueOf(cost));

                ventana.putExtra("horas", horas.getText().toString());
                ventana.putExtra("preciohora", String.valueOf(cost));

                ventana.putExtra("boolean1",selected1);
                ventana.putExtra("boolean2",selected2);
                ventana.putExtra("boolean3",selected3);
                ventana.putExtra("caja_aire",caja.getText().toString());
                ventana.putExtra("caja_gps",caja_gps.getText().toString());
                ventana.putExtra("caja_radio",caja_radio.getText().toString());
                objeto.putSerializable("informacion",datos);
                ventana.putExtras(objeto);
                startActivity(ventana);
            }
        });

        final Spinner spinner=(Spinner)findViewById(R.id.spinner);


        Adaptador adaptador= new Adaptador(this);
        spinner.setAdapter(adaptador);

//seleccionar una opción de la lista desplegable,
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View view, int position, long l) {
                String mensaje="Seleccionado: Marca "+coche[position].getMarca()+" Modelo "+coche[position].getModelo()+" Precio "+coche[position].getPrecio()+" Imagen "+coche[position].getView();
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    //MENU ACERCA DE Y DIBUJAR

    //PARA QUE SE VISUALICE EL MENU
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_acerca:
                Intent acerca = new Intent(MainActivity.this, Acerca.class);
                startActivity(acerca);
                return true;
            case R.id.menu_dibujar:
                Intent dibujo = new Intent(MainActivity.this, Dibujar.class);
                startActivity(dibujo);
                return true;
            case R.id.menu_preferencias:
                Intent ajustes = new Intent(MainActivity.this, PantallaOpciones.class);
                startActivity(ajustes);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    class Adaptador extends ArrayAdapter<Coches> {
        public Activity context;

        public Adaptador(Activity Context){
            super(Context,R.layout.coches,coche);
            this.context=Context;
        }
        public View getView(int position, View convertview, ViewGroup Parent){
            LayoutInflater inflater=context.getLayoutInflater();
            final View item = inflater.inflate(R.layout.activity_factura,null);

    //PASAR ETIQUETAS QUE SE USAN EN EL LAYOUT DE FACTURA Y RELACIONARLAS
            TextView marca = (TextView)item.findViewById(R.id.resultado_marca);
            TextView modelo = (TextView)item.findViewById(R.id.resultado_modelo);
            final TextView precio = (TextView)item.findViewById(R.id.resultado_precio);
            ImageView imag=(ImageView)item.findViewById(R.id.resultado_imagen);

            marca.setText(coche[position].getModelo());
            modelo.setText(coche[position].getMarca());
            precio.setText(String.valueOf(coche[position].getPrecio()));
            imag.setBackground(getDrawable(coche[position].getView()));

            return item;
        }

        public View getDropDownView(int position, View convertview, ViewGroup Parent){
            View ver_spinner= getView(position,convertview,Parent);
            return ver_spinner;
        }
    }
}