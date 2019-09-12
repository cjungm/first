package com.gmail.candy7manner.fourteenth_dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    final int DIALOG_DATE = 1;
    final int DIALOG_TIME = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button b1  = findViewById(R.id.btnDataPicker);
        Button b2  = findViewById(R.id.btnTimePicker);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPickerDialog(DIALOG_DATE);  // 날짜 설정 다이얼로그
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPickerDialog(DIALOG_TIME);  // 시간 설정 다이얼로그
            }
        });
    } // end onCreate()

    protected Dialog showPickerDialog(int id){
        Dialog d = null;

        switch (id){
            case DIALOG_DATE:
                d = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                Toast.makeText(getApplicationContext(),
                                        year + "년 " + (month + 1) + "월 " + day + "일 선택",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                        ,2019, 7, 13      // 기본값 연월일
                );
                ((DatePickerDialog)d).show();
                break;
            case DIALOG_TIME:
                d = new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                                Toast.makeText(getApplicationContext()
                                        , hour + "시 " + minute + "분 을 선택"
                                        , Toast.LENGTH_SHORT).show();
                            }
                        }
                        ,
                        18, 49, false);

                ((TimePickerDialog)d).show();
                break;
        } // end switch

        return d;
    }
}