package com.example.fuerm.primeracouchbaseapp;


import android.content.Context;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;

import java.io.IOException;

/**
 * Created by fuerm on 17/04/2017.
 */

public class SingletonDB {
    private static Manager manager = null;
    private static Database database = null ;


    //Utilizamos patron de diseño singleton

    public static Database getDatabaseInstance(String dbname) throws CouchbaseLiteException {
        if((database == null) & (manager != null)) {
            database = manager.getDatabase(dbname);
        }
        return database;
    }

    public static Manager getManagerInstance(Context context) throws IOException {
        if(manager == null) {
            manager = new Manager(new AndroidContext(context), Manager.DEFAULT_OPTIONS);
        }
        return manager;
    }

}
