package com.gmail.candy7manner.sixth_widget2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {

    RatingBar rb;
    TextView tv;

//    RatingBar 사용하기
//    setOnRatingBarChangeListener:     값이 변하면 호출
//    onRatingChanged:                  사용자에 의한 것인지 매개변수로 알려줌

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        rb = findViewById(R.id.ratingBar);
        tv = findViewById(R.id.textView5);

        // RatingBar 의 값이 변할때 호출되는 메소드
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {
                tv.setText("rating: " + v);
            }
        });
    }
}
