package com.example.apptotem.RetrofitPackage;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    private static Retrofit instance = null;

    public static Retrofit getInstance() {
        if (instance == null) {
            buildInstance();
        }
        return instance;
    }

    public static Retrofit buildInstance() {
        instance = new Retrofit.Builder()
                .baseUrl("https://totem.anoki.it")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return instance;
    }
}
