package com.example.apptotem.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.example.apptotem.Model.Employee;
import com.example.apptotem.Model.PFMRequest;
import com.example.apptotem.Model.PFMType;
import com.example.apptotem.Model.RequestFormat;
import com.example.apptotem.Model.UserData;
import com.example.apptotem.R;
import com.example.apptotem.Service.DoService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VMCalls extends ViewModel {

    private final String TAG = "SecondActivity";
    //private MutableLiveData<UserData> userData= new MutableLiveData<>();
    private UserData userData;
    private String token;
    private int id, id2;
    private RequestFormat req;

            //MutableLiveData<UserData>
    public UserData getUserData(Context c, TextView tv) {

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(c);
        token = pref.getString("token", "");
        DoService.getUserData(token, tv, c);
//      Log.v(TAG, "user: " + userData.getValue().getEmployee().getFirstname());

        return userData;
    }

    public void approverEmployee(Context c, Callback<List<Employee>> callback) {

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(c);
        token = pref.getString("token","");
        id = pref.getInt("id",0);
        DoService.approverEmployee(token, callback, id);

    }

    public void permitTypes(Context c, Callback<List<PFMType>> callback) {

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(c);
        token = pref.getString("token","");
        DoService.permitTypes(token, callback);
    }

    public void permitRequest(Context c, Callback<List<PFMRequest>> callback) {

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(c);
        token = pref.getString("token","");
        DoService.permitRequest(token, callback);
    }

    public void permitRequestTrue(Context c, String f, String m, String n, Callback<PFMRequest> callback ) {

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(c);
        token = pref.getString("token","");
        id = pref.getInt("id",0);
        req = new RequestFormat(f, m, n, id);
        DoService.permitRequestTrue(token, req, callback);
    }

    public void permitRequestFalse(Context c, String k, String f, String m, Callback<PFMRequest> callback) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(c);
        token = pref.getString("token","");
        id = pref.getInt("id",0);


        req = new RequestFormat(k, f, m, id);
        DoService.permitRequestFalse(token, req, callback);

    }

    public void deleteAbsence(Context c, Callback<Void> callback, int id2) {

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(c);
        token = pref.getString("token","");
        DoService.deleteAbsence(token, callback, id2);
    }




}
