package com.example.apptotem.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apptotem.Model.Employee;
import com.example.apptotem.Model.PFMType;
import com.example.apptotem.R;
import com.example.apptotem.ViewModel.VMCalls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragElencoTipi extends Fragment {

    private VMCalls model;
    private final String TAG = "FragElencoTipi2";
    private RecyclerView rec;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> lista2 = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_elenco_tipi, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Elenco tipi PFM");


        Callback<List<PFMType>> callback = new Callback<List<PFMType>>() {
            @Override
            public void onResponse(Call<List<PFMType>> call, Response<List<PFMType>> response) {
                if (response.isSuccessful()) {
                    String elenco = "";
                    for (int i=0; i<response.body().size();i++) {
                        if (response.body().size()!=i) {
                            elenco += response.body().get(i).getPermitType() + ", ";
                            lista2.add(response.body().get(i).getPermitType() + " ");

                        } else {

                        }
                    }

                    Collections.sort(lista2);
                    lista2.add(0, "Elenco tipi PFM:\n");
                    Log.v(TAG, "lista2: " + lista2);

                    adapter = new MyAdapter2(lista2);
                    rec.setAdapter(adapter);
                    rec.getAdapter().notifyDataSetChanged();
                    Log.v(TAG, "Permit Types Success, code:" + response.code() + " Elenco: " + elenco);
                } else {
                    Log.v(TAG, "Permit Types Error_1, code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<PFMType>> call, Throwable t) {
                Log.v(TAG, "Permit Typer Error_2");
            }
        };

        rec = getView().findViewById(R.id.recyclerView2);
        rec.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        rec.setLayoutManager(layoutManager);

        rec.addItemDecoration(new DividerItemDecoration(getActivity()));

        model = ViewModelProviders.of(FragElencoTipi.this).get(VMCalls.class);
        model.permitTypes(getContext(), callback);

    }
}
