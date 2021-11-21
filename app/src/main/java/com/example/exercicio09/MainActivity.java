package com.example.exercicio09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerFragment.DatePickerListener, TimePickerFragment.TimePickerListener{

    public Button btnDefinirData;
    public Button btnDefinirHora;
    public TextView txtData;
    public TextView txtHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDefinirData = findViewById(R.id.btnDefinirData);
        btnDefinirHora = findViewById(R.id.btnDefinirHora);
        txtData = findViewById(R.id.txtData);
        txtHora = findViewById(R.id.txtHora);

        Calendar calendar = Calendar.getInstance();

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);

        
        txtHora.setText(String.format("%02d:%02d", hour, minutes));
        txtData.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year) + " ");

        btnDefinirData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DatePickerFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "dialog");
            }
        });

        btnDefinirHora.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TimePickerFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "dialog");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String date = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year) + " ";
        txtData.setText(date);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hours, int minutes){
        txtHora.setText(String.format("%02d:%02d", hours, minutes));
    }
}