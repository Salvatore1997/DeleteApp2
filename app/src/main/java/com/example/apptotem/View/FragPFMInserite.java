package com.example.apptotem.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.solver.LinearSystem;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apptotem.Model.PFMRequest;
import com.example.apptotem.R;
import com.example.apptotem.ViewModel.VMCalls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragPFMInserite extends Fragment {

    private TextView tv;
    private VMCalls model;
    private final String TAG = "FragPFMInserite";
    private MyAdapter3 myAdapter3;
    private RecyclerView rec3;
    private ArrayList<String> lista = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
    private SimpleDateFormat outputFormat = new SimpleDateFormat( "dd-MMM-yyyy");
    private ArrayList<String> output = new ArrayList<>();
    private Date date, date2;
    private String dat, dat2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_pfminserite, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("PFM già inserite");
        tv = getView().findViewById(R.id.textView3);
        lista.add(0, "PFM inserite:\n");
        rec3 = getActivity().findViewById(R.id.recyclerView3);

        Callback<List<PFMRequest>> callback = new Callback<List<PFMRequest>>() {
            @Override
            public void onResponse(Call<List<PFMRequest>> call, Response<List<PFMRequest>> response) {
                if (response.isSuccessful()) {

                    String elenco =  "";
                    for (int i=0; i<response.body().size();i++) {
                        //if (i!= response.body().size()-1) {

                            try{
                               date = inputFormat.parse(response.body().get(i).getStartDate());
                               date2 = inputFormat.parse(response.body().get(i).getEndDate());
                               dat = outputFormat.format(date);
                               dat2 = outputFormat.format(date2);
                            ;
                           } catch (Exception e) {

                           }

                        //elenco += "Da: " + response.body().get(i).getStartDate() + "\nA:  " + response.body().get(i).getEndDate() + " "+ response.body().get(i).getPermitType()+",\n ";
                        lista.add("Da:  " + dat + "\nA:    " + dat2 + "\nPer: " + response.body().get(i).getPermitType() + "\n");
                            //output.add(String.format(response.body().get(i).getStartDate();
                        //} else {
                          //  elenco += "Da: " + response.body().get(i).getStartDate() + "    A: " + response.body().get(i).getEndDate() + " "+ response.body().get(i).getPermitType()+".";
                        //}
                    }
                    Log.v(TAG, "Permit Request Success, code: "+ response.code() + " elenco richieste già inserite: " + elenco);


                    myAdapter3 = new MyAdapter3(lista);
                    rec3.setAdapter(myAdapter3);
                    rec3.getAdapter().notifyDataSetChanged();
                } else {
                    Log.v(TAG, "Permit Request Error_1, code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<PFMRequest>> call, Throwable t) {
                Log.v(TAG, "Permit Request Error_2" + t.getMessage());
            }
        };


        rec3 = getView().findViewById(R.id.recyclerView3);
        rec3.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        rec3.setLayoutManager(layoutManager);

        rec3.addItemDecoration(new DividerItemDecoration(getActivity()));

        model = ViewModelProviders.of(FragPFMInserite.this).get(VMCalls.class);
        model.permitRequest(getContext(), callback);
    }


}
