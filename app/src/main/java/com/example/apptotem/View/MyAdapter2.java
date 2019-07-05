package com.example.apptotem.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apptotem.R;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder2> {

    private ArrayList<String> lista = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rec2_textview, parent, false);

        MyViewHolder2 vh = new MyViewHolder2(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyViewHolder2 myViewHolder2, int i) {
        myViewHolder2.tv.setText(lista.get(i));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {

        public TextView tv;

        public MyViewHolder2(TextView v) {
            super(v);
            tv = v;
        }
    }

    public MyAdapter2(ArrayList<String> lista) {
        this.lista = lista;
    }



}