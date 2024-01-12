package com.example.practica_cardview;

import static java.lang.invoke.VarHandle.AccessMode.GET;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import webservices.Asynchtask;
import webservices.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(
                "https://uealecpeterson.net/turismo/categoria/getlistadoCB"
                        + bundle.getString("Usr") + "&pass=" + bundle.getString("clave"),
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");


        final String[] datos =
                new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);
        Spinner cbCategoria = (Spinner) findViewById(R.id.cbCategoria);


        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        cbCategoria.setAdapter(adaptador);



    }

    @Override
    public void processFinish(String result) throws JSONException {
        /*TextView txtBancos = (TextView)findViewById(R.id.txtListaBancos);

        String lstBancos="";*/
        JSONArray JSONlista = new JSONArray(result);
        for(int i=0; i< JSONlista.length();i++){
            JSONObject banco= JSONlista.getJSONObject(i);
            lstBancos = lstBancos + "\n" +
                    banco.getString("name").toString();
        }
        txtBancos.setText("Respuesta WS Lista de Bancos" + lstBancos);

    }
}