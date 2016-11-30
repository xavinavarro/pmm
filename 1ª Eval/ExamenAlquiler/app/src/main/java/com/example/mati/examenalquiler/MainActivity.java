package com.example.mati.examenalquiler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCoches;
    private Button buttonTotal;
    private Button buttonFactura;
    private EditText editText;
    private RadioButton radioGroupSeguros;
    private CheckBox checkDVD, checkAireAc, checkGPS;
    private ImageView imagen;
    private AlquilerCoches alquiler;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCoches = (Spinner) findViewById(R.id.spinner);
        buttonTotal = (Button) findViewById(R.id.botontotal);
        buttonFactura = (Button) findViewById(R.id.botonfactura);
        editText = (EditText) findViewById(R.id.editTextHoras);
        radioGroupSeguros = (RadioButton) findViewById(R.id.radioButton_STR);
        checkAireAc = (CheckBox) findViewById(R.id.check_aire);
        checkDVD = (CheckBox) findViewById(R.id.check_gps);
        checkGPS = (CheckBox) findViewById(R.id.check_radio);
        imagen = (ImageView) findViewById(R.id.image);
        imagen.setImageResource(R.drawable.logo);

        AdaptadorSpinner adaptador = new AdaptadorSpinner(this);
        spinnerCoches.setAdapter(adaptador);

        spinnerCoches.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                Coche coche = (Coche) spinnerCoches.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        buttonTotal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                makeAlquiler();
                showToast(alquiler.getCosteTotal() + "€");
            }
        });

        buttonFactura.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                makeAlquiler();

                Intent intent = new Intent(MainActivity.this, Activity2.class);
                Bundle bundle = new Bundle();

                bundle.putSerializable("alquiler", alquiler);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ini, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.logo:
                Intent intent = new Intent(MainActivity.this, ActivityLogo.class);
                startActivity(intent);
                return true;
            case R.id.about:
                showToast("V1.0 - David Sánchez Matarredona");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void makeAlquiler() {
        boolean conSeguro = false;
        if (radioSeguro.isChecked()) {
            conSeguro = true;
        }

        int extras = 0;
        if (checkAireAc.isChecked()) {
            extras += 1;
        }
        if (checkDVD.isChecked()) {
            extras += 1;
        }
        if (checkGPS.isChecked()) {
            extras += 1;
        }

        alquiler = new Alquiler((Coche)spinnerCoches.getSelectedItem(), Integer.parseInt(editText.getText().toString()), conSeguro, extras);
    }

}