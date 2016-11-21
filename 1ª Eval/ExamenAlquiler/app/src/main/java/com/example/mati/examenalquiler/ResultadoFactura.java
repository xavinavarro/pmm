package com.example.mati.examenalquiler;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;

public class ResultadoFactura extends AppCompatActivity {

    private TextView textViewModelo, textViewSeguros, textViewHoras, textViewTipoExtras, textViewPrecioFinal;
    private ImageView imageViewCar;
    private Factura facturaResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_factura);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        iniciarComponentesUI();
        registerForContextMenu(imageViewCar);
    }

    private void iniciarComponentesUI() {
        textViewModelo = (TextView) findViewById(R.id.textView_Factura_Modelo);
        textViewSeguros = (TextView) findViewById(R.id.textView_Factura_Seguros);
        textViewHoras = (TextView) findViewById(R.id.textView_Factura_Horas);
        textViewTipoExtras = (TextView) findViewById(R.id.textView_Factura_TipoExtras);
        textViewPrecioFinal = (TextView) findViewById(R.id.textView_Factura_PrecioFinal);
        imageViewCar = (ImageView) findViewById(R.id.imageView_Factura_Car);

        Intent intent = getIntent();
        facturaResultado = (Factura) intent.getSerializableExtra("factura");

        textViewModelo.setText(facturaResultado.getModelo()+" ("+facturaResultado.getMarca()+")");
        textViewSeguros.setText(facturaResultado.getTipoSeguro());
        textViewHoras.setText(String.valueOf(facturaResultado.getHoras()));
        textViewTipoExtras.setText(facturaResultado.getTipoExtra());
        textViewPrecioFinal.setText(String.valueOf(facturaResultado.getPrecioFinal()));

        switch (facturaResultado.getMarca()){
            case "Ferrari":
                imageViewCar.setImageResource(R.drawable.ferrari1);
                break;
            case "Ford Fiesta":
                imageViewCar.setImageResource(R.drawable.fiesta1);
                break;
            case "Seat":
                imageViewCar.setImageResource(R.drawable.leon1);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemMenuContextual_Modelo:
                Toast.makeText(this,"Modelo "+facturaResultado.getModelo()+"\n"+facturaResultado.getMarca(), Toast.LENGTH_SHORT).show();
                break;
            default:
                super.onContextItemSelected(item);
        }

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual_modelo,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.home:
                setResult(RESULT_OK);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}