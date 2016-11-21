package com.example.mati.diferentesbotones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected CheckBox btnCaja1,btnCaja2,btnCaja3;
    protected Button botonEnviar;
    protected TextView txtRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialUISetup();

    }

    public void initialUISetup()
    {
        btnCaja1 = (CheckBox) findViewById(R.id.chkBoxCycling);
        btnCaja2 = (CheckBox) findViewById(R.id.chkBoxTeaching);
        btnCaja3 = (CheckBox) findViewById(R.id.chkBoxBlogging);
        botonEnviar = (Button) findViewById(R.id.btnEnviar);
        txtRespuesta = (TextView) findViewById(R.id.txtViewRespuesta);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getButtonClick(v);
            }
        });

        btnCaja1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getCheckBoxClick(buttonView,isChecked);
            }
        });
        btnCaja2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getCheckBoxClick(buttonView,isChecked);
            }
        });
        btnCaja3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getCheckBoxClick(buttonView,isChecked);
            }
        });
    }
    public void getButtonClick(View v)
    {
        String mensaje="";
        if (btnCaja1.isChecked())
        {
            mensaje += "Cycling ";
        }
        if (btnCaja2.isChecked())
        {
            mensaje += "Teaching ";
        }
        if (btnCaja3.isChecked())
        {
            mensaje += "Blogging ";
        }
        if (mensaje.isEmpty())
        {
            showTextNotification ("Vacio\nSelecciona al menos uno.");
        }
        else
        {
            showTextNotification (mensaje);
        }
        txtRespuesta.setText(mensaje);

    }
    public void getCheckBoxClick(CompoundButton buttonView, boolean isChecked)
    {
        if (buttonView ==btnCaja1 )
        {
            if (btnCaja1.isChecked())
            {
                showTextNotification("Cycling");
                txtRespuesta.setText("Cycling");
            }else
            {
                txtRespuesta.setText("");
            }
        }

        if (buttonView ==btnCaja2)
        {
            if (btnCaja2.isChecked())
            {
                showTextNotification("Teaching");
                txtRespuesta.setText("Teaching");
            }else
            {
                txtRespuesta.setText("");
            }
        }

        if (buttonView ==btnCaja3)
        {
            if (btnCaja3.isChecked())
            {
                showTextNotification("Blogging");
                txtRespuesta.setText("Blogging");
            }else
            {
                txtRespuesta.setText("");
            }
        }
    }
    public void showTextNotification (String cadena)
    {
        Toast.makeText(this,cadena,Toast.LENGTH_SHORT).show();
    }
}
