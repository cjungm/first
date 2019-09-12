package com.gmail.candy7manner.nineteenth_graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    // 화면터치하면 사각형이 그 위치로 움직이게 하
    // View 객체 + onDraw() + onTrouchEvent()
    // invalidate()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView2 m = new MyView2(this);
        setContentView(m);
    }

    class MyView2 extends View {

        int x = 100, y = 100;

        public MyView2(Context context) {
            super(context);
        }

        // 화면이 그려질때 호출
        // ex)처음 액티비티 시작할때, 화면이 가려졌다 나타날때..
        //    invalidate 되었을때
        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            canvas.drawRect(x - 100, y - 100, x + 100, y + 100, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    x = (int)event.getX();
                    y = (int)event.getY();
                    invalidate();  // 화면을 다시 그려주기 --> onDraw() 를 호출합니다.
            }
            return true;
        }
    }
}
