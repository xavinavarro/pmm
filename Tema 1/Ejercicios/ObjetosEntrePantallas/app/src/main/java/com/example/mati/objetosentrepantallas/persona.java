package com.example.mati.objetosentrepantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class persona extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);


        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        button = (Button) findViewById(R.id.button);

        Button.setOnClickListener()
    }
}