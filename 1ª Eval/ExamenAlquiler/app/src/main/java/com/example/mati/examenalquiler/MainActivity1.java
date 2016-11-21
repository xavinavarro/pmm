package com.example.mati.examenalquiler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {
    private final static int REQUEST_PRECIOFINAL = 0;
    private final static int REQUEST_FACTURA = 1;

    private Spinner spinnerCoches;
    private RadioGroup radioGroupSeguros;
    private CheckBox checkBoxDVD ,checkBoxAireAc, checkBoxGPS;
    private EditText editTextHoras;
    private Button buttonCalculos;
    private EditText textInput;
    private Coche[] coches = new Coche[]
            {
                    new Coche("MEGANE","Seat",20),
                    new Coche("X-11","Ferrari",100),
                    new Coche("Leon","Seat",30),
                    new Coche("Fiesta","Ford",40)
            };
    Factura factura = new Factura();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponenteUI();
    }

    private void iniciarComponenteUI() {
        spinnerCoches = (Spinner) findViewById(R.id.SpinnerCoches);
        radioGroupSeguros = (RadioGroup) findViewById(R.id.radioGroup_Seguros);
        checkBoxAireAc = (CheckBox) findViewById(R.id.checkBox_AireAc);
        checkBoxGPS = (CheckBox) findViewById(R.id.checkBox_GPS);
        checkBoxDVD = (CheckBox) findViewById(R.id.checkBox_DVD);
        editTextHoras = (EditText) findViewById(R.id.editTextHoras);
        buttonCalculos = (Button) findViewById(R.id.buttonTotalPrecio);
        textInput = (EditText) findViewById(R.id.inputLayout_horas);

        //IMPLEMENTACION DEL SPINNER
        AdaptadorSpinner adaptadorSpinner = new AdaptadorSpinner(this,coches);
        spinnerCoches.setAdapter(adaptadorSpinner);
        spinnerCoches.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                factura.setMarca(coches[position].getMarca());
                factura.setModelo(coches[position].setModelo());
                factura.setPreciomodelo(coches[position].getPrecio());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //IMPLEMENTACION DE EL RADIOGROUP
        radioGroupSeguros.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton_SinSeguro:
                        factura.setTipoSeguro("Sin seguro");
                        factura.setTipoSeguro(true);
                        break;
                    case R.id.radioButton_STR:
                        factura.setTipoSeguro("Seguro Todo Riesgo");
                        factura.setTipoSeguro(false);
                        break;
                }
            }
        });
        //IMPLEMENTACION DE LOS CHECKBOX
        checkBoxAireAc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (factura.getTipoExtra().isEmpty()){
                    factura.setTipoExtra("Con aire acondicionado");
                }
                else{
                    factura.setTipoExtra("Con Aire acondicionado");
                }
            }
        });
        checkBoxDVD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (factura.getTipoExtra().isEmpty()){
                    factura.setTipoExtra("Con DVD");
                }
                else{
                    factura.setTipoExtra("Con DVD");
                }
            }
        });

        checkBoxGPS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (factura.getTipoExtra().isEmpty()){
                    factura.setTipoExtra("Con GPS");
                }
                else{
                    factura.setTipoExtra("Con GPS");
                }
            }
        });

        //IMPLEMENTACION DEL BOTON Y DEL EDIT TEXT
        buttonCalculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextHoras.getText().toString().trim().isEmpty()){

                    editTextHoras.setError("Introduzca las horas");

                }else{
                    if (factura.getTipoExtra().equals("")){
                        factura.setTipoExtra("Sin decoración");
                    }
                    factura.setHoras(Double.parseDouble(editTextHoras.getText().toString()));

                    Intent intent = new Intent(MainActivity1.this,Factura.class);
                    Bundle bundle = new Bundle();

                    bundle.putSerializable("factura",factura);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,REQUEST_FACTURA);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        editTextHoras.setText("");
        checkBoxAireAc.setChecked(false);
        checkBoxDVD.setChecked(false);
        checkBoxGPS.setChecked(false);
        AdaptadorSpinner.setTipoExtra(0);
        radioGroupSeguros.check(R.id.radioButton_SinSeguro);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case REQUEST_PRECIOFINAL:
                    Toast.makeText(this,"De vuelta a las opciones!",Toast.LENGTH_SHORT).show();
                    break;
                case REQUEST_FACTURA:
                    Toast.makeText(this,"Un placer, presentarte a nuestro personal",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        else {
            Toast.makeText(this,"Fue cancelada la accion",Toast.LENGTH_SHORT).show();
        }
    }
}