package com.example.mati.pexamen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoFactura extends AppCompatActivity {

    private TextView textViewZona, textViewTarifa, textViewPeso, textViewDecoracion, textViewCosteFinal;
    private ImageView imageViewMapamundi;
    private Factura facturaResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_factura);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        iniciarComponentesUI();
        registerForContextMenu(imageViewMapamundi);
    }

    private void iniciarComponentesUI() {
        textViewZona = (TextView) findViewById(R.id.textView_Factura_Zona);
        textViewTarifa = (TextView) findViewById(R.id.textView_Factura_Tarifa);
        textViewPeso = (TextView) findViewById(R.id.textView_Factura_Peso);
        textViewDecoracion = (TextView) findViewById(R.id.textView_Factura_Decoracion);
        textViewCosteFinal = (TextView) findViewById(R.id.textView_Factura_CosteFinal);
        imageViewMapamundi = (ImageView) findViewById(R.id.imageView_Factura_Mapa);

        Intent intent = getIntent();
        facturaResultado = (Factura) intent.getSerializableExtra("factura");

        textViewZona.setText(facturaResultado.getZona()+" ("+facturaResultado.getContinente()+")");
        textViewTarifa.setText(facturaResultado.getTipoTarifa());
        textViewPeso.setText(String.valueOf(facturaResultado.getPesoPaquete()));
        textViewDecoracion.setText(facturaResultado.getTipoDecoracion());
        textViewCosteFinal.setText(String.valueOf(facturaResultado.getPrecioFinal()));

        switch (facturaResultado.getContinente()){
            case "Asia y Oceanía":
                imageViewMapamundi.setImageResource(R.drawable.asia_y_oceania);
                break;
            case "América y África":
                imageViewMapamundi.setImageResource(R.drawable.america_y_africa);
                break;
            case "Europa":
                imageViewMapamundi.setImageResource(R.drawable.europa);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemMenuContextual_Zona:
                Toast.makeText(this,"ZONA "+facturaResultado.getZona()+"\n"+facturaResultado.getContinente(), Toast.LENGTH_SHORT).show();
                break;
            default:
                super.onContextItemSelected(item);
        }

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual_mundo,menu);
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