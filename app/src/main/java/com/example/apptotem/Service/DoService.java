package com.example.apptotem.Service;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;
import com.example.apptotem.Model.Employee;
import com.example.apptotem.Model.PFMRequest;
import com.example.apptotem.Model.PFMType;
import com.example.apptotem.Model.RequestFormat;
import com.example.apptotem.Model.Token;
import com.example.apptotem.Model.User;
import com.example.apptotem.Model.UserData;
import com.example.apptotem.RetrofitPackage.RetrofitClass;
import com.example.apptotem.RetrofitPackage.ServiceApi;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoService {

    private static final String TAG = "MainActivity";
    private static ServiceApi client =  RetrofitClass.getInstance().create(ServiceApi.class);
    private static UserData ud;
    private static TextView tv;

    public static void login(User user, final Context context,  Callback<Token> callback) {

        Call<Token> call = client.login(user);
        call.enqueue(callback);
    }

    public static UserData getUserData(String token, final TextView tv, final Context context) {
        Call<UserData> call = client.getUserData("Bearer "+token);
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if (response.isSuccessful()){
                    Log.v(TAG, "Get Success");
                    tv.setText("Benvenuto "+ response.body().getEmployee().getFirstname());
                    ud = response.body();

                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt("id", response.body().getEmployee().getId());
                    editor.apply();

                    Log.v(TAG, "id: " + response.body().getEmployee().getId());

                } else {
                    Log.v(TAG, "Get Error_1");
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Log.v(TAG, "Get Error_2");
            }
        });
        return ud;
    }

    public static void approverEmployee(String token, Callback<List<Employee>> callback, int id) {
        Call<List<Employee>> call = client.approverEmployee("Bearer "+ token, id);
        call.enqueue(callback);
    }

    public static void permitTypes(String token, Callback<List<PFMType>> callback) {
        Call<List<PFMType>> call = client.permitTypes("Bearer "+ token);
        call.enqueue(callback);
    }

    public static void permitRequest(String token, Callback<List<PFMRequest>> callback) {
        Call<List<PFMRequest>> call = client.permitRequest("Bearer "+ token);
        call.enqueue(callback);

    }

    public static void permitRequestTrue(String token, RequestFormat req, Callback<PFMRequest> callback) {

        Call<PFMRequest> call = client.permitRequestTrue("Bearer "+ token, req);
        call.enqueue(callback);
    }

    public static void permitRequestFalse(String token, RequestFormat req, Callback<PFMRequest> callback) {
        Call<PFMRequest> call = client.permitRequestFalse("Bearer "+ token, req);
        call.enqueue(callback);
    }
}


