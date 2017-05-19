package com.example.fuerm.gestionoficinatecnica;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    //Definimos unas cuantas constantes que nos servirán como etiquetas en los mensajes mostrados por consola.

    final String TAG1 = "app_oficinaTecnica";
    private  static final long DURACION_PANTALLA_INICIO = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG1, "Comienzo de la App Couchbase Events");

        //Establecemos la orientación de la pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Ocultamos el título
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Definimos el layout
        setContentView(R.layout.activity_pantalla_inicio);

        //Definimos una tarea
        TimerTask task = new TimerTask(){

            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), Application.class);
                startActivity(intent);
            }
        };

        //Defino el tiempo hasta que se ejecute la tarea.
        Timer timer = new Timer();
        timer.schedule(task, DURACION_PANTALLA_INICIO);

    }
}
