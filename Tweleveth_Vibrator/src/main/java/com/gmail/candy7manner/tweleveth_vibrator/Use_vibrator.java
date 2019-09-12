package com.gmail.candy7manner.tweleveth_vibrator;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Use_vibrator extends AppCompatActivity {

    // 진동
    // 1. 진동 권한을 획득해야한다. AndroidManifest.xml
    // 2. Vibrator 객체를 얻어서 진동시킨다

    Button btnVib1,btnVib2,btnVib3,btnVib4;

    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_vibrator);

        btnVib1 = (Button)findViewById(R.id.btnVib1);
        btnVib2 = (Button)findViewById(R.id.btnVib2);
        btnVib3 = (Button)findViewById(R.id.btnVib3);
        btnVib4 = (Button)findViewById(R.id.btnVib4);

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        btnVib1.setText("1초 진동");
        btnVib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(1000);   // 지정시간동안 진동
            }
        });

        btnVib2.setText("지정한 패턴으로 진동");
        btnVib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long [] pattern = {100, 300, 100, 700, 300, 2000};  // millisec
                // 대기, 진동, 대기, 진동 ...
                vibrator.vibrate(pattern,   // 진동패턴은 배열로
                        -1);  // 반복 회수
                // 0 : 무한반복,   -1 : 반복 없슴.
            }
        });

        btnVib3.setText("무한반복 진동");
        btnVib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(new long[] {100, 1000, 100, 500, 100, 500, 1000},
                        0);  // 0: 무한반복
            }
        });

        btnVib4.setText("진동 취소");
        btnVib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.cancel();   // 진동 취소
            }
        });
    } // end of onCreate
} // end of class