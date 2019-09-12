package com.gmail.candy7manner.nineteenth_graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        MyView3 m = new MyView3(this);

        ll.addView(m);  // 위 LinearLayout 에 View 추가(포함)
        setContentView(ll);
    }

    class MyView3 extends View {

        Paint paint = new Paint();
        Path path = new Path();

        public MyView3(Context context) {
            super(context);
            paint.setStyle(Paint.Style.STROKE);  // '선' 으로 그려지도록 설정
            paint.setStrokeWidth(10f);  // 선의 굵기
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawPath(path, paint);   // 저장된 path 를 그리기.
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(x, y);   // path 에 그리는게 아니라 위치만 이동.
                    break;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(x, y);  // path 에 그리기
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }

            invalidate();   // 화면 다시그리기 --> onDraw();

            return true;
        }
    }
}
