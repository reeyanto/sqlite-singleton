package com.riyanto.sqlitesingleton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.riyanto.sqlitesingleton.adapters.MahasiswaAdapter;
import com.riyanto.sqlitesingleton.models.Mahasiswa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static Context context;
    private static ArrayList<Mahasiswa> mahasiswaList;
    ListView listMahasiswa;
    MahasiswaAdapter mahasiswaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        listMahasiswa = findViewById(R.id.lv_mahasiswa);

        insert(new Mahasiswa("Dodi", "445566", "Manajemen Informatika"));
        insert(new Mahasiswa("Evi", "556677", "Teknik Listrik"));
        insert(new Mahasiswa("Fani", "667788", "Manajemen Informatika"));

        mahasiswaList = getAll();
        mahasiswaAdapter = new MahasiswaAdapter(this, mahasiswaList);
        listMahasiswa.setAdapter(mahasiswaAdapter);
    }

    public static void insert(Mahasiswa mhs) {
        SQLiteDatabase db = Singleton.getInstance(context).getWritableDatabase();

        String sql = String.format(
                "INSERT INTO mahasiswa (nama, nim, prodi) VALUES ('%s', '%s', '%s')",
                mhs.getNama(), mhs.getNim(), mhs.getProdi()
        );
        db.execSQL(sql);
    }

    public static ArrayList<Mahasiswa> getAll() {
        mahasiswaList = new ArrayList<>();
        SQLiteDatabase db = Singleton.getInstance(context).getReadableDatabase();
        String sql = "SELECT * FROM mahasiswa";

        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            mahasiswaList.add(new Mahasiswa(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2))
            );
        }
        return mahasiswaList;
    }
}