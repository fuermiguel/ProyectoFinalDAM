package com.example.fuerm.gestionoficinatecnica;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.fuerm.gestionoficinatecnica.Adaptadores.AdaptadorDeProyectos;
import com.example.fuerm.gestionoficinatecnica.Adaptadores.Proyecto;

public class Primera extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera);

        getSupportActionBar().setTitle("PLAN DE EMERGENCIA");

        //Usando un gridview
        GridView gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(new AdaptadorDeProyectos(this));
        gridview.setOnItemClickListener(this);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_primera, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_hecho:
                Log.i("ActionBar", "hecho!");
                return true;
            case R.id.action_settings:
                Log.i("ActionBar", "Settings!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*
    Manejamos que proyecto se ha pulsado.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent ;

        Proyecto item = (Proyecto) parent.getItemAtPosition(position);

        switch (item.getNombre()){
            case "Plan de emergencia" :
                intent = new Intent(this, PlanEmergencia.class);
                break;
            default:
                intent = new Intent(this, EnConstruccion.class);
                break;
        }
        startActivity(intent);
    }
}
