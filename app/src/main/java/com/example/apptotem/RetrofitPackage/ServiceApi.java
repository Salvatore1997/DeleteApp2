package com.example.apptotem.RetrofitPackage;

import com.example.apptotem.Model.Employee;
import com.example.apptotem.Model.PFMRequest;
import com.example.apptotem.Model.PFMType;
import com.example.apptotem.Model.RequestFormat;
import com.example.apptotem.Model.Token;
import com.example.apptotem.Model.User;
import com.example.apptotem.Model.UserData;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceApi {
    //Login
    @POST("/totem/api/jwt/login")
    Call<Token> login(@Body User user);

    //dati utente dopo Login
    @GET("/totem/api/check/isLoggedIn")
    Call<UserData> getUserData(@Header("Authorization") String token);

    //elenco di dipendenti che possono approvare il PFM dell' utente
    @GET("/totem/api/approverEmployee?")
    Call<List<Employee>> approverEmployee(@Header("Authorization") String token,
                                          @Query("{id}") int id);

    //elenco dei tipi di richeste PFM che puoi inserire
    @GET("/totem/api/permitTypes/")
    Call<List<PFMType>> permitTypes(@Header("Authorization") String token);

    //elenco delle richeste PFM già inserite
    @GET("/totem/api/permitRequest")
    Call<List<PFMRequest>> permitRequest(@Header("Authorization") String token);

    //richiesta PFM allDay = true
    @POST("/totem/api/permitRequest")
    Call<PFMRequest> permitRequestTrue(@Header("Authorization") String token,
                                       @Body RequestFormat request);

    //richesta PFM allDay = false
    @POST("/totem/api/permitRequest")
    Call<PFMRequest> permitRequestFalse(@Header("Authorization") String token,
                                        @Body RequestFormat request);

}
