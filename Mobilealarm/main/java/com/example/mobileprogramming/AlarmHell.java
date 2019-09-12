package com.example.mobileprogramming;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmHell  extends AppCompatActivity implements View.OnClickListener {
    Button home, addr,btn_finish2;

    AlarmManager alarm_manager2;
    TimePicker alarm_timepicker2;
    DatePicker alarm_datepicker2;
    Context context;
    PendingIntent pendingIntent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_hell);

        home = (Button) findViewById(R.id.home);
        addr = (Button) findViewById(R.id.addr);
        home.setOnClickListener(this);
        addr.setOnClickListener(this);
        btn_finish2 = (Button) findViewById(R.id.btn_finish2);
        btn_finish2.setOnClickListener(this);

        this.context = this;

        // 알람매니저 설정
        alarm_manager2 = (AlarmManager) getSystemService(ALARM_SERVICE);

        // 타임피커 설정
        alarm_timepicker2 = findViewById(R.id.time_picker2);
        alarm_datepicker2 = findViewById(R.id.date_picker2);

        // Calendar 객체 생성
        final Calendar calendar = Calendar.getInstance();

        // 알람리시버 intent 생성
        final Intent my_intent = new Intent(this.context, ReceiveAlarm.class);

        // 알람 시작 버튼
        Button alarm_on2 = findViewById(R.id.btn_start2);
        alarm_on2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                // calendar에 시간 셋팅
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker2.getHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker2.getMinute());
                calendar.set(Calendar.YEAR,alarm_datepicker2.getYear());
                calendar.set(Calendar.MONTH,alarm_datepicker2.getMonth());
                calendar.set(Calendar.DAY_OF_MONTH,alarm_datepicker2.getDayOfMonth());

                // 시간 가져옴
                int hour = alarm_timepicker2.getHour();
                int minute = alarm_timepicker2.getMinute();
                int year = alarm_datepicker2.getYear();
                int month = alarm_datepicker2.getMonth();
                int dayofmonth = alarm_datepicker2.getDayOfMonth();
                Toast.makeText(AlarmHell.this,"Alarm 예정 " + year + "년 " + month + "월 " + dayofmonth + "일 " +
                        hour + "시 " + minute + "분",Toast.LENGTH_SHORT).show();

                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);

                // reveiver에 string 값 넘겨주기
                my_intent.putExtra("state2","alarm on");
                // 보내기
                pendingIntent2 = PendingIntent.getBroadcast(AlarmHell.this, 0, my_intent, PendingIntent.FLAG_UPDATE_CURRENT);
                long aTime = System.currentTimeMillis();
                long bTime = calendar.getTimeInMillis();
                Log.d("여기","여기");

                //하루의 시간을 나타냄
                long interval = 1000 * 60 * 60  * 24;

                //만일 내가 설정한 시간이 현재 시간보다 작다면 알람이 바로 울려버리기 때문에 이미 시간이 지난 알람은 다음날 울려야 한다.
                if(aTime>bTime){
                    bTime += interval;
                }

                // 알람셋팅
                alarm_manager2.set(AlarmManager.RTC_WAKEUP, bTime, pendingIntent2);
                Log.d("여기","여기");
            }
        });


    }

    //건드리지 말 것
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //건드리지 말 것
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.addr) {
            Intent intent = new Intent(this, AlarmHell.class);
            startActivity(intent);
            finish();
        } else if(v.getId() == R.id.btn_finish2){
            Intent intent = new Intent(this,Mission1.class);
            startActivity(intent);
            finish();
        }
    }
}



