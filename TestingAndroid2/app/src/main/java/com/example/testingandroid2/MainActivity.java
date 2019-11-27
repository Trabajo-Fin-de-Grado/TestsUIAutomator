package com.example.testingandroid2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView texto;
    private Integer cont;
    private long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (TextView) findViewById(R.id.text2);
    }

    public void actividad2(View v){
        Intent intent = new Intent (v.getContext(), Main2Activity.class);
        startActivityForResult(intent, 0);
    }

    public void pulBoton1(View v){
        cont = 0;
        time = System.currentTimeMillis();
        for(int var =0; var< 1000; var++){
            cont +=var;

        }
        time = System.currentTimeMillis() - time;
        texto.setText(String.format("Se han ejecutado 1 000 iteraciones. Tiempo: " + time + " milisegundos"));

    }

    public void pulBoton2(View v){
        cont = 0;
        time = System.currentTimeMillis();
        for(int var =0; var< 10000; var++){
            cont +=var;
        }
        time = System.currentTimeMillis() - time;
        texto.setText(String.format("Se han ejecutado 10 000 iteraciones. Tiempo: " + time + " milisegundos"));
    }
}
