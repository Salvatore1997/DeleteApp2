package com.example.apptotem.View;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.arch.lifecycle.ViewModel;
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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.apptotem.Model.ApiError;
import com.example.apptotem.Model.PFMRequest;
import com.example.apptotem.R;
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

public class FragAllDayFalse extends Fragment {

    private static final String TAG = "FragAllDayFalse";
    private EditText et, et2, et3;
    private Button b;
    private String giornata, giornata2, oraDa, oraA, daDef, aDef, per;
    private Date date1,date2;
    private final Calendar myCalendar = Calendar.getInstance();
    private VMCalls model;
    private TimePickerDialog time, time2;
    private DatePickerDialog.OnDateSetListener data;
    private Spinner sp2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_all_day_false, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et = getActivity().findViewById(R.id.textView20);
        et2 = getActivity().findViewById(R.id.textView33);
        et3 = getActivity().findViewById(R.id.editTextN);
        b = getActivity().findViewById(R.id.button44);
        sp2 = getActivity().findViewById(R.id.spinner2);

        data = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {
                TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
                String myFormat = "yyyy-MM-dd"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

                et.setText(sdf.format(myCalendar.getTime()));
            }
        };

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), data, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        et2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                time = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                et2.setText(String.format("%02d:%02d",sHour, sMinute));
                            }
                        }, hour, minutes, true);
                time.show();
            }
        });

        et3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr2 = Calendar.getInstance();
                int hour = cldr2.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr2.get(Calendar.MINUTE);
                // time picker dialog
                time2 = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                et3.setText(String.format("%02d:%02d",sHour, sMinute));
                            }
                        }, hour, minutes, false);
                time2.show();
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giornata = et.getText().toString();
                giornata2 = et.getText().toString();
                oraDa = et2.getText().toString();
                oraA = et3.getText().toString();


                model = ViewModelProviders.of(FragAllDayFalse.this).get(VMCalls.class);

                Callback<PFMRequest> callback = new Callback<PFMRequest>() {
                    @Override
                    public void onResponse(Call<PFMRequest> call, Response<PFMRequest> response) {
                        if (response.isSuccessful()) {
                            Log.v(TAG, "Permit Request False Success, code: "+ response.code() + " EmployeeId: "  + response.body().getEmployeeId());
                        } else {
                            Log.v(TAG, "Permit Request False Error_1, code: "+ response.code());
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
                        Log.v(TAG, "Permit Request False Error_2");

                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                };

                // daDef="2003-09-18T09:00:00+02:00";

                giornata+= "T" + oraDa + ":00+02:00";
                giornata2+= "T" + oraA + ":00+02:00";
                per = sp2.getSelectedItem().toString();

                TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                try {
                    date1 = format.parse(giornata);
                    date2 = format.parse(giornata2);
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

                Log.v(TAG, "Giornata: " + daDef);
                Log.v(TAG, "Giornata2: " + aDef);

                model.permitRequestFalse(getContext(),per ,daDef, aDef, callback);
            }
        });
    }
}
