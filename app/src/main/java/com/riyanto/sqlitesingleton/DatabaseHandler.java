package com.riyanto.sqlitesingleton;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHandler";
    private static final String DBNAME = "akademik.db";

    public DatabaseHandler(@Nullable Context context) {
        super(context, DBNAME, null, 1);
        Log.d(TAG, "DatabaseHandler: diinstansiasi");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE mahasiswa (nama TEXT, nim TEXT, prodi TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS mahasiswa";
        sqLiteDatabase.execSQL(sql);

        onCreate(sqLiteDatabase);
    }
}
