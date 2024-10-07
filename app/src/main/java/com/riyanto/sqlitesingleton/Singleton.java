package com.riyanto.sqlitesingleton;

import android.content.Context;

public class Singleton {

    private static DatabaseHandler db;

    public static synchronized DatabaseHandler getInstance(Context context) {
        if(db == null) {
            db = new DatabaseHandler(context);
        }
        return db;
    }
}
