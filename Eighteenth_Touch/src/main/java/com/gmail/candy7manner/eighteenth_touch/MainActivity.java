package com.gmail.candy7manner.eighteenth_touch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    Button btnTouch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        btnTouch = findViewById(R.id.btnTouch);

        btnTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:  // 눌렸을때
                        tvResult.setText("ACTION_DOWN : 눌렸습니다");
                        break;
                    case MotionEvent.ACTION_MOVE: // 눌린상태로 움직일때
                        tvResult.setText("ACTION_MOVE : 움직이고 있습니다.");
                        break;
                    case MotionEvent.ACTION_UP: // 눌렸다가 떼어졌을때
                        tvResult.setText("ACTION_UP : 손을 떼었습니다");
                        break;
                }
                // 이벤트 처리를 여기서 완료하고
                // 다음곳으로 이벤트를 넘기지 않기 위해서
                // true 를 리턴하면 된다.
                return true;
            }
        });

        btnTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("클릭?");
            }
        });
    }
}
