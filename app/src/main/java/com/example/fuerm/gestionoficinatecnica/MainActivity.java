package com.example.fuerm.gestionoficinatecnica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    //Definimos unas cuantas constantes que nos servirán como etiquetas en los mensajes mostrados por consola.

    final String TAG1 = "app_oficinaTecnica";
    private  static final long DURACION_PANTALLA_INICIO = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couch_base_event);
        Log.d(TAG1, "Comienzo de la App Couchbase Events");
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), Application.class);
        startActivity(intent);
        Log.d(TAG1, "Final de la App Couchbase Events");
    }
}
