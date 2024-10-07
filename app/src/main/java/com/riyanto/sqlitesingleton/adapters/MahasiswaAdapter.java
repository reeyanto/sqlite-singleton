package com.riyanto.sqlitesingleton.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.riyanto.sqlitesingleton.R;
import com.riyanto.sqlitesingleton.models.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Mahasiswa> mahasiswaList;

    public MahasiswaAdapter(Context context, ArrayList<Mahasiswa> mahasiswaList) {
        this.context = context;
        this.mahasiswaList = mahasiswaList;
    }

    @Override
    public int getCount() {
        return mahasiswaList.size();
    }

    @Override
    public Object getItem(int position) {
        return mahasiswaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        TextView nama = view.findViewById(R.id.tv_nama);
        TextView nim = view.findViewById(R.id.tv_nim);
        TextView prodi = view.findViewById(R.id.tv_prodi);

        nama.setText(mahasiswaList.get(position).getNama());
        nim.setText(mahasiswaList.get(position).getNim());
        prodi.setText(mahasiswaList.get(position).getProdi());

        return view;
    }
}
