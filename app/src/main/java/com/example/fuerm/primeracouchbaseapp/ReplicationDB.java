package com.example.fuerm.primeracouchbaseapp;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.auth.Authenticator;
import com.couchbase.lite.auth.AuthenticatorFactory;
import com.couchbase.lite.replicator.Replication;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by fuerm on 17/04/2017.
 */

public class ReplicationDB {


    public static void startReplications(String dbname, String username, String password) throws CouchbaseLiteException{

        Database database =  SingletonDB.getDatabaseInstance(dbname);

        Replication pull = database.createPullReplication(createSyncURL(false,dbname));
        Replication push = database.createPushReplication(createSyncURL(false,dbname));
        pull.setContinuous(true);
        push.setContinuous(true);

        //Si usamos autentificación
        Authenticator authenticator = AuthenticatorFactory.createBasicAuthenticator(username, password);
        push.setAuthenticator(authenticator);
        pull.setAuthenticator(authenticator);


        pull.start();
        push.start();
    }



    private static URL createSyncURL(boolean isEncrypted, String dbname){
        URL syncURL = null;
        //Para obtener el localhost desde el emulador debemos usar la ip 10.0.2.2
        String host = "http://10.0.2.2";
        String port = "4984";

        try {
            syncURL = new URL(host + ":" + port + "/" + dbname);
        } catch (MalformedURLException me) {
            me.printStackTrace();
        }
        return syncURL;
    }
}

