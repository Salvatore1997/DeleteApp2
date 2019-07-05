package com.example.apptotem.View;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apptotem.Model.UserData;
import com.example.apptotem.R;
import com.example.apptotem.ViewModel.VMCalls;

public class WelcomeFrag extends Fragment {

    private TextView tv;
    private String firstName, message;
    private VMCalls model;
   // private MutableLiveData<UserData> ud = new MutableLiveData<>();
    private UserData ud;
    private static final String TAG ="MainActivity";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv = getView().findViewById(R.id.welcome_tv);
        getActivity().setTitle("Benvenuto");

        model = ViewModelProviders.of(getActivity()).get(VMCalls.class);
        model.getUserData(getContext(), tv);

        /*model.getUser().observe(getActivity(), new Observer<UserData>() {
            @Override
            public void onChanged(@Nullable UserData userData) {

            }
        });
        ud  = model.getUser();
        ud = model.getUserData(getActivity().getApplicationContext());*/



        //Log.v(TAG, "user: " + ud.getValue());
//        Log.v(TAG, "user: " + ud.getEmployee().getFirstname());
//        firstName = ud.getValue().getEmployee().getFirstname();
  //      message = "Benvenuto " + firstName;
        //    tv.setText(message);




    }

}
