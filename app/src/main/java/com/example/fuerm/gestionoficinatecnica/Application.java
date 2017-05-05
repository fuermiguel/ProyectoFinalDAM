package com.example.fuerm.gestionoficinatecnica;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.UnsavedRevision;
import com.example.fuerm.gestionoficinatecnica.Datos.CargaDatos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fuerm on 17/04/2017.
 */

public class Application extends AppCompatActivity {
    public  static final String DB_NAME ="couchbaseevents";//Nombre de la base de datos
    public static final String TAG = "couchbaseevents";//Etiqueta para mostrar los Log
    public static final String USERNAME = "miguel";//Lo podemos ver en el config.json del sync gateway
    public static final String PASSWORD = "pass";

   //Variables para el manejo de la base de datos
    Manager manager;
    Database database;
    String idDocument ;
    ReplicationDB replicationDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        //Creamos base de datos
        createDB(DB_NAME);

        //Creamos documento en la base de datos creada
        idDocument = createDocument(database);

        //Recuperamos documento y mostramos sus propiedades por consola
        Log.d(TAG, "retrievedDocument=" + String.valueOf(
                retrievedDocument(idDocument,database).getProperties()));

        //Actualizamos documento y mostramos por pantallas las propiedades del documento
        Log.d(TAG, "updatedDocument=" + String.valueOf(
                updateDocument(idDocument,database).getProperties()));

        //Adjuntamos binario al documento
        addAttachement(database, idDocument);

        //Recuperamos el documento y comprobamos el adjunto
        Log.d(TAG, "retrievedDocument=" + String.valueOf(
                retrievedDocument(idDocument,database).getProperties()));

        //replicationDB = new ReplicationDB();

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

    private  String createDocument(Database database) {

        Document document = database.createDocument();//Genera el Id de manera automatica
        String documentId = document.getId();
        Log.d(TAG,"El identificador del documento creados es " + documentId);
        Map<String, Object> map = (Map<String, Object>) new CargaDatos();

        /*Cuando un documento es guardado a la base de datos, se generan dos propiedades de manera
        automatica _id(identificador de documento) y _rev(identificador de revisión) que se añaden
         a las almacenadas en el documento
         */

        try {
            //Cargo los valores en el documento
            document.putProperties(map);
            Log.d(TAG,"Documento salvado con los nuevos datos");
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
}
