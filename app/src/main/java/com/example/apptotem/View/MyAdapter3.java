package com.example.apptotem.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.apptotem.Model.PFMRequest;
import com.example.apptotem.R;
import com.example.apptotem.Service.DoService;
import com.example.apptotem.ViewModel.VMCalls;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder3> {

    private ArrayList<String> lista = new ArrayList<>();
    private VMCalls model;
    private final static String TAG = "FragPFMInserite";
    private ArrayList<Integer> listaId = new ArrayList<>();
    private Callback<Void> callback;
    private Context c;
    private int t;

    @NonNull
    @Override
    public MyViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rec3_textview, parent, false);

        MyViewHolder3 vh = new MyViewHolder3(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder3 holder, final int i) {
//        holder.tv(lista.get(i));
        //holder.rec_text3.setText(lista.get(i));

        TextView d = holder.tv;
        d.setText(lista.get(i));

        callback = new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.v(TAG,"Delete Success, code: " + response.code());
                } else {
                    Log.v(TAG,"Delete Error_1, code. " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.v(TAG,"Delete Error_2");
            }
        };

        final Button b2 = holder.b;
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.deleteAbsence(c, callback, listaId.get(i));
                lista.remove(i);
                listaId.remove(i);
                notifyItemRemoved(i);
                notifyItemRangeChanged(i, getItemCount());
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class MyViewHolder3 extends RecyclerView.ViewHolder {

        public TextView tv;
        public Button b;

        public MyViewHolder3(View v) {
            super(v);
            tv = v.findViewById(R.id.rec_text3);
            b = v.findViewById(R.id.button70);
        }
    }

    public MyAdapter3(ArrayList<String> lista, ArrayList<Integer> listaId, VMCalls model, Context c) {
        notifyItemInserted(lista.size()-1);
        this.lista = lista;
        this.listaId = listaId;
        this.model = model;
        this.c = c;
    }
}
