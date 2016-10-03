package com.example.mati.ejemplobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkBoxBaloncesto;
    CheckBox chkBoxFutbol;
    CheckBox chkBoxHockey;
    Button btnHobby;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void initialUISetup()
    {
        chkBoxBaloncesto = (CheckBox) findViewById(R.id.chkBoxBaloncesto);
        chkBoxFutbol = (CheckBox) findViewById(R.id.chkBoxFutbol);
        chkBoxHockey = (CheckBox) findViewById(R.id.chkBoxHockey);
        btnHobby = (Button)findViewById(R.id.btnHobby);
        txtHobby = (TextView)findViewById(R.id.txtHobby);
        btnHobby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                getHobbyClick(v);
            }
        });
    }

     public void getHobbyClick(View v) {
        String strMessage = "";
        if(chkBoxBaloncesto.isChecked())
        {
            strMessage+="Baloncesto";
        }
        if(chkBoxFutbol.isChecked())
        {
            strMessage+="Futbol";
        }
        if(chkBoxHockey.isChecked())
        {
            strMessage+="Hockey";
        }
        showTextNotification(strMessage);
    }
    public void showTextNotification(String msgToDisplay) {
        txtHobby.setText(msgToDisplay);

        //Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }
}


