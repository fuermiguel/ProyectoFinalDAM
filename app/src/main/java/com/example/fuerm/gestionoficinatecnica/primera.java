package com.example.fuerm.gestionoficinatecnica;

import android.content.Intent;
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
import com.vijay.jsonwizard.activities.JsonFormActivity;

public class Primera extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final int    REQUEST_CODE_GET_JSON = 1;
    private static final String TAG                   = "MainActivity";
    private static final String DATA_JSON_PATH        = "data.json";

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

        Intent intent;

        Proyecto item = (Proyecto) parent.getItemAtPosition(position);

        switch (item.getNombre()) {
            case "Plan de emergencia":
                // intent = new Intent(this, PlanEmergencia.class);
                //getTheme().applyStyle(R.style.sinActionBar,true);
                //setTheme(R.style.sinActionBar);
                intent = new Intent(this, JsonFormActivity.class);
                String json = CommonUtils.loadJSONFromAsset(getApplicationContext(), DATA_JSON_PATH);
                intent.putExtra("json", json);
                startActivityForResult(intent, REQUEST_CODE_GET_JSON);
               // setTheme(R.style.AppTheme);
               // getTheme().applyStyle(R.style.AppTheme,true);
                break;
            default:
                intent = new Intent(this, EnConstruccion.class);
                break;
        }
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_GET_JSON && resultCode == RESULT_OK) {
            Log.d(TAG, data.getStringExtra("json"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}