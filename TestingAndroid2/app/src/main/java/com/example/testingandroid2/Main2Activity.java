package com.example.testingandroid2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView texto;
    private Integer cont;
    private long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        texto = (TextView) findViewById(R.id.text2);
    }

    public void pulBoton3(View v){
        cont = 0;
        time = System.currentTimeMillis();
        for(int var =0; var< 100000; var++) {
            cont += var;
        }
        time = System.currentTimeMillis() - time;
        texto.setText(String.format("Se han ejecutado 100 000 iteraciones. Tiempo: " + time + " milisegundos"));
    }

    public void pulBoton4(View v){
        cont = 0;
        time = System.currentTimeMillis();
        for(int var =0; var< 1000000; var++){
            cont +=var;
        }
        time = System.currentTimeMillis() - time;
        texto.setText(String.format("Se han ejecutado 1 000 000 iteraciones. Tiempo: " + time + " milisegundos"));
    }

    public void crash(View v){
        throw new IllegalArgumentException();
    }
}
