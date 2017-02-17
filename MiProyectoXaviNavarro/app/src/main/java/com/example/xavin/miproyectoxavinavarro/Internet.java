package com.example.xavin.miproyectoxavinavarro;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Internet extends AppCompatActivity {

    Button mostrar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        mostrar = (Button) findViewById(R.id.botonm);
        resultado = (TextView) findViewById(R.id.restultado1);

        final String url = "http://www.game.es";

        mostrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new TareaHttpAsincrona().execute(url);
            }
        });
    }

    public  class TareaHttpAsincrona extends AsyncTask<String, String, String> {

        private void comprobarConexionInternet(){
            ConnectivityManager conectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

            if (conectivityManager != null) {
                NetworkInfo[] info = conectivityManager.getAllNetworkInfo();

                if (info != null) {
                    for (int i = 0; i < info.length; i++) {
                        if (info[i].getState() == NetworkInfo.State.CONNECTED)
                            Toast.makeText(Internet.this, "Conexion a Internet realizada con exito", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            else
                Toast.makeText(Internet.this, "Fallo en la conexion a Internet", Toast.LENGTH_SHORT).show();
        }

        protected void onPreExecute(){
            comprobarConexionInternet();
        }

        protected String doInBackground(String... params) {
            HttpURLConnection httpURLConnection = null;
            String salida = "";
            try {
                URL url = new URL(params[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setConnectTimeout(25000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();

                if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream =  httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

                    int i, j;
                    String linea = bufferedReader.readLine();
                    while (linea != null) {
                        if (linea.contains("<title>")) {
                            i = linea.indexOf("<title>") + 16;
                            j = linea.indexOf("</title>") - 3;
                            salida += linea.substring(i, j);
                            salida += "\n\n\n";
                        }
                        linea = bufferedReader.readLine();
                    }
                    bufferedReader.close();
                    inputStream.close();
                }
                return(salida);
            }
            catch(Exception e){
                salida= "Excepción: " + e.getMessage();
            }
            finally {
                httpURLConnection.disconnect();
            }
            return salida;
        }
        protected void onPostExecute(String sal){
            resultado.append(sal);
        }
    }
}