package com.example.mati.spinnertitular;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

public class Titular extends AppCompatActivity {

    private Titular[] datos = new Titular[]{
            new Titular("Xavi", "Navarro",R.drawable.img1),
            new Titular("David", "Saez",R.drawable.img2),
            new Titular("Adrian", "Polit",R.drawable.img3),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titular);

        AdaptadorTitulares adapter = new AdaptadorTitulares(this);
        ListView IstOpciones = (ListView)findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener()){
            public void onItemClick(AdapterView arg0, View arg1, int position, long id){

            }
        }
    }
}
