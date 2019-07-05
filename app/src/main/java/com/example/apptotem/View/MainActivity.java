package com.example.apptotem.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.apptotem.Model.Token;
import com.example.apptotem.Model.User;
import com.example.apptotem.R;
import com.example.apptotem.Service.DoService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText et, et2;
    private Button b;
    private String username,password,token;
    private final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);
        b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = et.getText().toString();
                password = et2.getText().toString();


                    DoService.login(new User("s.stile@anoki.it", "anoki1997"), getApplicationContext(), new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        if (response.isSuccessful()) {
                            Log.v(TAG, "POST SUCCESS, token: "+ response.body().getToken());
                            token = response.body().getToken();

                            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                            SharedPreferences.Editor edit = sharedPref.edit();
                            edit.putString("token", token);
                            edit.apply();

                        } else {
                            Log.v(TAG, "POST ERROR_1, code: "+ response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Log.v(TAG, "POST ERROR_2");

                    }
                });
                startActivity(new Intent(MainActivity.this, NavigationDrawer.class));
            }
        });
    }
}
