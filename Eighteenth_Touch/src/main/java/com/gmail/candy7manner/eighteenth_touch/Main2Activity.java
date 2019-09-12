package com.gmail.candy7manner.eighteenth_touch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    // 3개까지의 멀티 터치를 다루기 위한 배열
    int id[] = new int[3];
    int x[] = new int[3];
    int y[] = new int[3];
    String result;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvResult = findViewById(R.id.tvResult);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int pointer_count = event.getPointerCount();   // 현재 터치 발생한 포이트 개수
        if(pointer_count > 3) pointer_count = 3;   // 최대 3개까지의 멀티터치만 처리

        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:   // 한개의 터치 down 되었을때
                id[0] = event.getPointerId(0);  // 터치한 순간에 부여되는 포인터 고유번호
                x[0] = (int)(event.getX());
                y[0] = (int)(event.getY());
                result = "싱글터치 : \n";
                result += "(" + x[0] + ", " + y[0] + ")";
                break;

            case MotionEvent.ACTION_POINTER_DOWN:  // 두개 이상의 터치 down 되었을때
                result = "멑티터치 : \n";

                for(int i = 0; i < pointer_count; i++){
                    id[i] = event.getPointerId(i);
                    x[i] = (int)(event.getX(i));
                    y[i] = (int)(event.getY(i));
                    result += String.format("id[%d](%d, %d)", id[i], x[i], y[i]);
                }

                break;

            case MotionEvent.ACTION_MOVE:
                result = "멀티터치 MOVE :\n";
                for(int i = 0; i < pointer_count; i++){
                    id[i] = event.getPointerId(i);
                    x[i] = (int)(event.getX(i));
                    y[i] = (int)(event.getY(i));
                    result += String.format("id[%d](%d, %d)", id[i], x[i], y[i]);
                }
                break;

            case MotionEvent.ACTION_UP:
                result = "";
                break;
        }

        tvResult.setText(result);

        return super.onTouchEvent(event);
    }
}

