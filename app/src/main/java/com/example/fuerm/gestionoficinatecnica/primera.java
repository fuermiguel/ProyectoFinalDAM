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
import android.widget.Toast;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.UnsavedRevision;
import com.example.fuerm.gestionoficinatecnica.Adaptadores.AdaptadorDeProyectos;
import com.example.fuerm.gestionoficinatecnica.Adaptadores.Proyecto;
import com.example.fuerm.gestionoficinatecnica.Datos.CargaDatos;
import com.vijay.jsonwizard.activities.JsonFormActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Primera extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static final String DB_NAME                ="app_gestion_oficina_tecnica";
    public static final String TAG                    = "app_oficinaTecnica";
    public static final String USERNAME               = "miguel";//para el config.json del sync gateway
    public static final String PASSWORD               = "pass";
    private static final int   REQUEST_CODE_GET_JSON  = 1;
    private static final String DATA_JSON_PATH        = "plan_emergencia.json";//Plantilla wizard formulario

    //Variables para el manejo de la base de datos.
    Manager manager;
    Database database;
    String idDocument ;
    ReplicationDB replicationDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_primera);

        getSupportActionBar().setTitle("TIPOS DE PROYECTOS");

        //Usando un gridview
        GridView gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(new AdaptadorDeProyectos(this));
        gridview.setOnItemClickListener(this);

        //Creamos base de datos
        createDB(DB_NAME);

        //Realizamos la replicación(Syncronización) con Couchbase server a través de Sync Gateway
        try {
            ReplicationDB.startReplications(DB_NAME,USERNAME,PASSWORD);
        } catch (CouchbaseLiteException e) {
            Log.e(TAG,"error replicando la base de datos");
        }
    }

    //Método que crea la base de datos si no existe

    private void createDB(String dbname){

        try {
            manager = SingletonDB.getManagerInstance(this);
            database = SingletonDB.getDatabaseInstance(dbname);
        } catch (IOException e) {
            Log.e(TAG,"Error creando el objeto manager",e);
            return;
        } catch (CouchbaseLiteException e) {
            Log.e(TAG,"Error obteniendo la base de datos", e);
            return;
        }
    }

    //Método que crea un documento nuevo y retorna el Id del documento

    private  String createDocument(Database database,JSONObject objectJson) {

        Document document = database.createDocument();//Genera el Id de manera automatica
        String documentId = document.getId();
        Log.d(TAG,"El identificador del documento creados es " + documentId);

        Map<String, Object> map = null;
        try {

            map = new CargaDatos(objectJson).getMap();

            Log.d(TAG,"map creado con éxito");

             /*Cuando un documento es guardado a la base de datos, se generan dos propiedades de manera
               automatica _id(identificador de documento) y _rev(identificador de revisión) que se añaden
               a las almacenadas en el documento
            */

            //Cargo los valores en el documento
            document.putProperties(map);

            Log.d(TAG,"Documento salvado con los nuevos datos");

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (CouchbaseLiteException e) {
            Log.e(TAG,"Error poniendo los datos en el documento ", e);
        }

        return documentId;
    }

    //Método que recupera un documento dado su Id y lo retorna.

    private Document retrievedDocument(String docID, Database database){
        Document rDocument = database.getDocument(docID);
        return rDocument;
    }

    //Método que actualiza un documento y lo retorna

    private Document updateDocument(String docID, Database database){
        Document uDocument = database.getDocument(docID);

        Map<String,Object> uproperties = new HashMap<String, Object>();
        uproperties.putAll(uDocument.getProperties());//Copio el mapa al nuevo mapa
        uproperties.put("nuevo nombre" , "nuevo valor");
        uproperties.put("nueva localizacion", "nuevo valor localizacion");

        try {
            uDocument.putProperties(uproperties);
        } catch (CouchbaseLiteException e) {
            Log.e(TAG,"error actualizando el documento", e);
            return null;
        }
        return uDocument;
    }

    //Método que adjunta un archivo binario a un documento dado de una base de datos dada.

    private void addAttachement(Database database, String documentId){
        Document document = database.getDocument(documentId);

        ByteArrayInputStream inputStream =  new ByteArrayInputStream(new byte[] {0,0,0,0});
        UnsavedRevision revision = document.getCurrentRevision().createRevision();//Crea una nueva revisión igual a la actual, no guardada
        revision.setAttachment("Datos Binarios", "application/octect-stream",inputStream);//nombre,tipo(https://kb.iu.edu/d/agtj),datos
        //https://en.wikipedia.org/wiki/Media_type#List_of_common_media_types
        try {
            revision.save();
        } catch (CouchbaseLiteException e) {
            Log.e(TAG,"Error al adjuntar el archivo binario", e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_primera, menu);
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
                intent = new Intent(this, JsonFormActivity.class);
                String json = CommonUtils.loadJSONFromAsset(getApplicationContext(), DATA_JSON_PATH);
                intent.putExtra("json", json);
                startActivityForResult(intent, REQUEST_CODE_GET_JSON);
                break;
            default:
                intent = new Intent(this, EnConstruccion.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        JSONObject object= null;
        if (requestCode == REQUEST_CODE_GET_JSON && resultCode == RESULT_OK) {
            Log.d(TAG, data.getStringExtra("json"));
            Toast.makeText(this, "!!!!!!!!!" +data.getStringExtra("json"), Toast.LENGTH_LONG).show();

            try {
                object = new JSONObject(data.getStringExtra("json"));

            } catch (JSONException e) {
                e.printStackTrace();
            }

            //creamos documento pasando los datos por parámetros como un objeto json
            createDocument(database,object);

            //Recuperamos documento y mostramos sus propiedades por consola
            //Log.d(TAG, "retrievedDocument=" + String.valueOf(
                 //   retrievedDocument(idDocument,database).getProperties()));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}