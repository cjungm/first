package com.gmail.candy7manner.fifth_image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Usevisibility extends AppCompatActivity {

    ImageView iv1, iv2;  // 1번 이미지, 2번 이미지
    //클릭으로 이미지 바꾸기
    //setVisibility 이용하기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usevisibility);

        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);

        // 1번 이미지가 클릭되면, 1번째 이미지는 안보이게 하고  2번째 이미지는 보이게 하기.
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv1.setVisibility(View.INVISIBLE);   // 안보이게 하기
                iv2.setVisibility(View.VISIBLE);  // 보이게 하기
            }
        });

        // 2번 이미지 클릭되면.. 그 반대로 동작
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv1.setVisibility(View.VISIBLE);
                iv2.setVisibility(View.INVISIBLE);
            }
        });

    } // end onCreate
}
