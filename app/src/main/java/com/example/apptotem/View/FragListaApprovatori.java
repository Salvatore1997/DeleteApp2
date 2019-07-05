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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apptotem.Model.ApiError;
import com.example.apptotem.Model.Employee;
import com.example.apptotem.Model.PFMRequest;
import com.example.apptotem.R;
import com.example.apptotem.ViewModel.VMCalls;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragListaApprovatori extends Fragment {

    private final String TAG ="FragListaApprovatori";
    private VMCalls model;

    private RecyclerView rec;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;
    private ArrayList<String> lista = new ArrayList<>();
    private static final int VERTICAL_ITEM_SPACE = 48;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_lista_approvatori, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //tv = getView().findViewById(R.id.textView);
        getActivity().setTitle("Lista Approvatori");
        lista.add(0, "Approvatori:\n");

        Callback<List<Employee>> callback = new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if (response.isSuccessful()) {

                    String listaApp="";
                    for(int i=0; i<response.body().size();i++) {
                        if (i!= response.body().size()) {
                            listaApp += response.body().get(i).getLastname() + " " + response.body().get(i).getFirstname() + ", ";
                            lista.add(response.body().get(i).getLastname() + " " + response.body().get(i).getFirstname() + " ");
                            Log.v(TAG, "elemento: " + i +  " " + lista.get(i));
                        } else {
                          //  listaApp += " " + response.body().get(i).getLastname() + " " + response.body().get(i).getFirstname() + ".";
                            //lista.add(" " + response.body().get(i).getLastname() + " " + response.body().get(i).getFirstname() + "");
                        }
                        Collections.sort(lista);
                        adapter = new MyAdapter(lista);
                        rec.setAdapter(adapter);
                        rec.getAdapter().notifyDataSetChanged();
                    }
                    Log.v(TAG, "approverEmployee Success, code:" + response.code() + " Lista: " + listaApp);
                } else {
                    Log.v(TAG, "approver Error_1, code: " + response.code());
                }

            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.v(TAG, "approver Error_2");
            }
        };

        rec = getView().findViewById(R.id.recyclerView);
        rec.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        rec.setLayoutManager(layoutManager);

        rec.addItemDecoration(new DividerItemDecoration(getActivity()));




        model = ViewModelProviders.of(FragListaApprovatori.this).get(VMCalls.class);
        model.approverEmployee(getContext(), callback);
    }
}
