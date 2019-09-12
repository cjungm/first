package com.gmail.candy7manner.sixth_widget2;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.ToggleButton;

public class Progressbar extends AppCompatActivity {

    ProgressBar pb1, pb2;

    int value = 0;  // 막대 프로그레스 바의 현재 진행값 저장
    int add = 10;   // 증가량

    ProgressBar pb3;
    int value2 = 0;
    int add2 = 1;

    // Thread 에서 화면을 그리기 위해 필요!
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);

        pb1 = findViewById(R.id.progressBar);
        pb2 = findViewById(R.id.progressBar2);
        ToggleButton b1 = findViewById(R.id.toggleButton);
        Button b2 = findViewById(R.id.button1);

        pb3 = findViewById(R.id.progressBar3);

        // 토글버튼 상태 변화시 호출되는 리스너
        b1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isPressed) {
                if(isPressed){
                    pb1.setVisibility(View.INVISIBLE);
                } else {
                    pb1.setVisibility(View.VISIBLE);
                }
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = value + add;    // 10씩 증가
                if(value > 100 || value < 0){
                    value = -add;
                }

                pb2.setProgress(value);  // 프로그레스바의 진행값을 설정
            }
        });

        // 앱 시작시 Thread 를 시작하여 ProgressBar 증가시키기
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    value2 = value2 + add2;
                    if(value2 > 100 || value2 < 0){
                        add2 = -add2;
                    }

                    // 프로그레스바 세팅.... 별도의 Thread 에서
                    // 메인 UI 접근하려면 반.드.시 Handler 사용해야 함.
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pb3.setProgress(value2);
                        }
                    });

                    try {
                        Thread.sleep(100);  // 시간지연
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } // end run()
        });


        t.start();  // 쓰레드 시작


    } // end onCreate()
}