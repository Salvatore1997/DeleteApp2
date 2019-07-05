package com.example.apptotem.View;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apptotem.Model.ApiError;
import com.example.apptotem.Model.PFMRequest;
import com.example.apptotem.Model.RequestFormat;
import com.example.apptotem.R;
import com.example.apptotem.RetrofitPackage.RetrofitClass;
import com.example.apptotem.RetrofitPackage.ServiceApi;
import com.example.apptotem.ViewModel.VMCalls;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragAllDayTrue extends Fragment {

    private static final String TAG = "FragAllDayTrue";
    private VMCalls model;
    private RequestFormat request;
    private Button b3;
    private EditText et, et2, et3;
    private int id;
    private String da,a,per,daDef,aDef;
    private Spinner sp;
    private Date date1,date2;
    private static ServiceApi client =  RetrofitClass.getInstance().create(ServiceApi.class);
    private final Calendar myCalendar = Calendar.getInstance();
    private final Calendar myCalendar2 = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener dateDa, dateA;
    public FragAllDayTrue() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_all_day_true, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Effettua Richiesta Giornata");

        b3 = getActivity().findViewById(R.id.button4);
        et = getActivity().findViewById(R.id.textView);
        et2 = getActivity().findViewById(R.id.textView3);

        sp = getActivity().findViewById(R.id.spinner);

        dateDa = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {

                TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
                String format = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(format);

                et.setText(sdf.format(myCalendar.getTime()));
            }
        };

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), dateDa, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        dateA = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar2.set(Calendar.YEAR, year);
                myCalendar2.set(Calendar.MONTH, month);
                myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel2();
            }

            private void updateLabel2() {
                TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
                String format2 = "yyyy-MM-dd";
                SimpleDateFormat sdf2 = new SimpleDateFormat(format2);

                et2.setText(sdf2.format(myCalendar2.getTime()));
            }
        };

        et2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), dateA, myCalendar2
                        .get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH),
                        myCalendar2.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                da = et.getText().toString() + "T09:00:00+02:00";
                Log.v(TAG, "DADATA: " + da);
                a = et2.getText().toString() + "T18:00:00+02:00";
//                id = Integer.parseInt(et3.getText().toString());
                per = sp.getSelectedItem().toString();

                TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                try {
                    date1 = format.parse(da);
                    date2 = format.parse(a);
                } catch(Exception e) {
                    Log.v(TAG, "Eccezione1: "+ e.getMessage());
                }

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                try {
                    daDef = dateFormat.format(date1);
                    aDef = dateFormat.format(date2);
                } catch (Exception e) {
                    Log.v(TAG, "Eccezione2: " + e.getMessage());
                }
                Log.v(TAG, "Employeeid: " + id);
                Log.v(TAG, "Date inserite: " + daDef);
                Log.v(TAG, "Date inserite: " + aDef);

                //request = new RequestFormat(per, daDef, aDef, id);
                // request = new RequestFormat(per, "2015-08-18T09:00:00+02:00", "2015s-08-19T18:00:00+02:00", id);

               // daDef="2003-09-18T09:00:00+02:00";
                // aDef="2003-09-19T18:00:00+02:00";

                model = ViewModelProviders.of(FragAllDayTrue.this).get(VMCalls.class);

                Callback<PFMRequest> callback = new Callback<PFMRequest>() {
                    @Override
                    public void onResponse(Call<PFMRequest> call, Response<PFMRequest> response) {
                        if (response.isSuccessful()) {
                            Log.v(TAG, "Permit Request True Success, code: "+ response.code() + " EmployeeId: "  + response.body().getEmployeeId());
                        } else {
                            Log.v(TAG, "Permit Request True Error_1, code: "+ response.code());
                            ResponseBody errorBody = response.errorBody();
                            String message;
                            if( errorBody != null ) {
                                try {

                                    Gson gson = new Gson();
                                    ApiError error = gson.fromJson(errorBody.string(), ApiError.class);
                                    message = error.getMessages().size() > 0 ? error.getMessages().get(0).getText() : "Error Unknown1";
                                } catch (IOException e) {
                                    message = "Error unknown2";
                                }
                            } else {
                                message = "Error unknown3";
                            }


                            Toast.makeText(getActivity(),message, Toast.LENGTH_SHORT).show();
                            Log.v(TAG, "message1 = " + message );
                    }

                    }

                    @Override
                    public void onFailure(Call<PFMRequest> call, Throwable t) {
                        Log.v(TAG, "Permit Request True Error_2");

                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                };

                model.permitRequestTrue(getContext(), per, daDef, aDef, callback);

            }
        });


    }
}
