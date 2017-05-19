package com.example.fuerm.gestionoficinatecnica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.example.fuerm.gestionoficinatecnica.Adaptadores.AdaptadorDeProyectos;

public class Primera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera);

        getSupportActionBar().setTitle("PLAN DE EMERGENCIA");

        //Usando un gridview
        GridView gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(new AdaptadorDeProyectos(this));






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
                Log.i("ActionBar", "hecho!");;
                return true;
            case R.id.action_settings:
                Log.i("ActionBar", "Settings!");;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
