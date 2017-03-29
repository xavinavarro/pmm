package com.example.mati.listayspinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button button1,button2, button3, button4;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.bttn1);
        button2 = (Button) findViewById(R.id.bttn2);
        button3 = (Button) findViewById(R.id.bttn3);
        button4 = (Button) findViewById(R.id.bttn4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        button3.setOnClickListener(this);

        button4.setOnClickListener(this);
    }
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.bttn1:
                intent = new Intent(MainActivity.this,MyListaSimple.class);
                startActivity(intent);
                break;
            case R.id.bttn2:
                intent = new Intent(MainActivity.this,MySpinnerSimple.class);
                startActivity(intent);
                break;
            case R.id.bttn3:
                intent = new Intent(MainActivity.this,MyListaObjetos.class);
                startActivity(intent);
                break;
            case R.id.bttn4:
                intent = new Intent(MainActivity.this,SpinnerPersona.class);
                startActivity(intent);
                break;


        }
    }
}
