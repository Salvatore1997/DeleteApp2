package com.example.apptotem.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apptotem.R;

import java.util.ArrayList;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder3> {

    private ArrayList<String> lista = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rec3_textview, parent, false);

        MyViewHolder3 vh = new MyViewHolder3(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder3 holder, int i) {
        holder.tv.setText(lista.get(i));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class MyViewHolder3 extends RecyclerView.ViewHolder {

        public TextView tv;

        public MyViewHolder3(TextView v) {
            super(v);
            tv = v;
        }
    }

    public MyAdapter3(ArrayList<String> lista) {
        this.lista = lista;
    }



}
