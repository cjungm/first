package com.gmail.candy7manner.eighteenth_touch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main3Activity extends AppCompatActivity {

    ImageView ivRobot;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ivRobot = findViewById(R.id.ivRobot);
        ll = findViewById(R.id.linearLayout1);

        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_DOWN:
                        // 이미지 뷰 이동
                        ivRobot.setX(motionEvent.getX());
                        ivRobot.setY(motionEvent.getY());
                }
                return true;
            }
        });



    }
}