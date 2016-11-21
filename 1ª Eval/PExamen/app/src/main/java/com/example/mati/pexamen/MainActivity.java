package com.example.mati.pexamen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static int REQUEST_RESULTADOFACTURA = 0;
    private final static int REQUEST_AZAFATA = 1;

    private Spinner spinnerDestinos;
    private RadioGroup radioGroupTarifas;
    private CheckBox checkBoxCajaRegalo, checkBoxTarjetaDedicada;
    private EditText editTextPesoPaquete;
    private Button buttonCalculos;
    private EditText textInput;
    private Destino[] destinos = new Destino[]
            {
                    new Destino("A","Asia y Oceanía",30),
                    new Destino("B","América y África",20),
                    new Destino("C","Europa",10)
            };
    Factura factura = new Factura();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponenteUI();
    }

    private void iniciarComponenteUI() {
        spinnerDestinos = (Spinner) findViewById(R.id.spinnerDestinos);
        radioGroupTarifas = (RadioGroup) findViewById(R.id.radioGroup_Tarifas);
        checkBoxCajaRegalo = (CheckBox) findViewById(R.id.checkBox_CajaRegalo);
        checkBoxTarjetaDedicada = (CheckBox) findViewById(R.id.checkBox_TarjetaDedicada);
        editTextPesoPaquete = (EditText) findViewById(R.id.editTextPesoPaquete);
        buttonCalculos = (Button) findViewById(R.id.buttonHacerCalculos);
        textInput = (EditText) findViewById(R.id.inputLayout_PesoPaquete);

        //IMPLEMENTACION DEL SPINNER
        AdaptadorSpinner adaptadorSpinner = new AdaptadorSpinner(this,destinos);
        spinnerDestinos.setAdapter(adaptadorSpinner);
        spinnerDestinos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                factura.setZona(destinos[position].getZona());
                factura.setContinente(destinos[position].getContinente());
                factura.setPrecioZona(destinos[position].getPrecio());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //IMPLEMENTACION DE EL RADIOGROUP
        radioGroupTarifas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton_TarifaUrgente:
                        factura.setTipoTarifa("Urgente");
                        factura.setUrgente(true);
                        break;
                    case R.id.radioButton_TarifaNormal:
                        factura.setTipoTarifa("Normal");
                        factura.setUrgente(false);
                        break;
                }
            }
        });
        //IMPLEMENTACION DE LOS CHECKBOX
        checkBoxCajaRegalo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (factura.getTipoDecoracion().isEmpty()){
                    factura.setTipoDecoracion("Con caja regalo");
                }
                else{
                    factura.setTipoDecoracion("Con caja regalo y dedicatoria");
                }
            }
        });
        checkBoxTarjetaDedicada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (factura.getTipoDecoracion().isEmpty()){
                    factura.setTipoDecoracion("Con tarjeta dedicada");
                }
                else{
                    factura.setTipoDecoracion("Con caja regalo y dedicatoria");
                }
            }
        });

        //IMPLEMENTACION DEL BOTON Y DEL EDIT TEXT
        buttonCalculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextPesoPaquete.getText().toString().trim().isEmpty()){

                    editTextPesoPaquete.setError("Introduzca el peso!!");

                }else{
                    if (factura.getTipoDecoracion().equals("")){
                        factura.setTipoDecoracion("Sin decoración");
                    }
                    factura.setPesoPaquete(Double.parseDouble(editTextPesoPaquete.getText().toString()));

                    Intent intent = new Intent(MainActivity.this,ResultadoFactura.class);
                    Bundle bundle = new Bundle();

                    bundle.putSerializable("factura",factura);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,REQUEST_RESULTADOFACTURA);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemMenu_AcercaDe:
                Dialogo_AcercaDe dialogoAcercaDe = new Dialogo_AcercaDe();
                dialogoAcercaDe.show(getSupportFragmentManager(),"Acerca de");
                return true;
            case R.id.itemMenu_Azafata:
                Intent intent = new Intent(MainActivity.this,DibujoAzafata.class);
                startActivityForResult(intent,REQUEST_AZAFATA);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        editTextPesoPaquete.setText("");
        checkBoxCajaRegalo.setChecked(false);
        checkBoxTarjetaDedicada.setChecked(false);
        spinnerDestinos.setSelection(0);
        radioGroupTarifas.check(R.id.radioButton_TarifaNormal);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case REQUEST_RESULTADOFACTURA:
                    Toast.makeText(this,"De vuelta a las opciones!",Toast.LENGTH_SHORT).show();
                    break;
                case REQUEST_AZAFATA:
                    Toast.makeText(this,"Un placer, presentarte a nuestro personal",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        else {
            Toast.makeText(this,"Fue cancelada la accion",Toast.LENGTH_SHORT).show();
        }
    }
}