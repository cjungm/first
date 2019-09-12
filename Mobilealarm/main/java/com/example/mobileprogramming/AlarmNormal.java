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

public class AlarmNormal  extends AppCompatActivity implements View.OnClickListener {
        Button home, addr;


        AlarmManager alarm_manager;
        TimePicker alarm_timepicker;
        DatePicker alarm_datepicker;
        Context context;
        PendingIntent pendingIntent;


        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.alarm_normal);

            home = (Button) findViewById(R.id.home);
            addr = (Button) findViewById(R.id.addr);
            home.setOnClickListener(this);
            addr.setOnClickListener(this);


            this.context = this;

            // 알람매니저 설정
            alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

            // 타임피커 설정
            alarm_timepicker = findViewById(R.id.time_picker);
            alarm_datepicker = findViewById(R.id.date_picker);

            // Calendar 객체 생성
            final Calendar calendar = Calendar.getInstance();

            // 알람리시버 intent 생성
            final Intent my_intent = new Intent(this.context, AlarmReciver.class);

            // 알람 시작 버튼
            Button alarm_on = findViewById(R.id.btn_start);
            alarm_on.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {


                    // calendar에 시간 셋팅
                    calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                    calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());
                    calendar.set(Calendar.YEAR,alarm_datepicker.getYear());
                    calendar.set(Calendar.MONTH,alarm_datepicker.getMonth());
                    calendar.set(Calendar.DAY_OF_MONTH,alarm_datepicker.getDayOfMonth());

                    // 시간 가져옴
                    int hour = alarm_timepicker.getHour();
                    int minute = alarm_timepicker.getMinute();
                    int year = alarm_datepicker.getYear();
                    int month = alarm_datepicker.getMonth();
                    int dayofmonth = alarm_datepicker.getDayOfMonth();
                    Toast.makeText(AlarmNormal.this,"Alarm 예정 " + year + "년 " + month + "월 " + dayofmonth + "일 " +
                            hour + "시 " + minute + "분",Toast.LENGTH_SHORT).show();


                    calendar.set(Calendar.HOUR_OF_DAY, hour);
                    calendar.set(Calendar.MINUTE, minute);




                    // reveiver에 string 값 넘겨주기
                    my_intent.putExtra("state","alarm on");
                    // 보내기

                    pendingIntent = PendingIntent.getBroadcast(AlarmNormal.this, 0, my_intent, PendingIntent.FLAG_UPDATE_CURRENT);
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
                    alarm_manager.set(AlarmManager.RTC_WAKEUP, bTime, pendingIntent);

                }
            });

            // 알람 정지 버튼
            Button alarm_off = findViewById(R.id.btn_finish);
            alarm_off.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(AlarmNormal.this,"Alarm 종료",Toast.LENGTH_SHORT).show();
                    // 알람매니저 취소
                    alarm_manager.cancel(pendingIntent);

                    my_intent.putExtra("state","alarm off");

                    // 알람취소
                    sendBroadcast(my_intent);
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
            }
        }
    }



