package com.gmail.candy7manner.nineteenth_graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // XML 레이아웃을 사용하지 않고 화면에 그리기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView m = new MyView(this);
        setContentView(m);
    }
}

class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    // 화면을 그려줄 상황(업데이트)에서 그림을 그리는 일 수행
    @Override
    protected void onDraw(Canvas canvas) {  // 화면을 그려주는 작업
        Paint paint = new Paint();   // 화면에 그려줄 도구를 세팅
        paint.setColor(Color.RED);   // 색상 지정

        setBackgroundColor(Color.YELLOW);  // 배경색
        canvas.drawRect(100, 100, 200, 200, paint);
        canvas.drawCircle(300, 500, 40, paint);

        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10f);  // 선의 굵기
        canvas.drawLine(400, 100, 500, 150, paint);  // 직선

        // path
        Path path = new Path();
        path.moveTo(20, 100);   // path 이동
        path.lineTo(100, 200);   // path 직선
        path.cubicTo(150, 30, 200, 300, 300, 200); // path 베이지어 곡선

        canvas.drawPath(path, paint);

    }
}
