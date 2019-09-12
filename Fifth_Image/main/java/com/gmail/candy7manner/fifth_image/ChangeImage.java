package com.gmail.candy7manner.fifth_image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChangeImage extends AppCompatActivity {

    //  클릭하면 이미지가 바뀜
    // 이미지 리소스 아이디를 담을 배열 : int []
    int [] imageId = {R.drawable.a1, R.drawable.a2, R.drawable.a3,
            R.drawable.a4, R.drawable.a5, R.drawable.a6 };
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changeImage);

        iv = findViewById(R.id.imageView);

        // 특정 이미지 리소스로 ImageView 세팅하기
        iv.setImageResource(R.drawable.a1);
        iv.setOnClickListener(new MyListener());  // 리스너 장착

    } // end onCreate()

    class MyListener implements View.OnClickListener{
        int i = 0;
        int length = imageId.length;  // 이미지의 개수
        TextView tv = findViewById(R.id.textView);

        @Override
        public void onClick(View view) {

            iv.setImageResource(imageId[i]);   // i번째 이미지로 세팅
            tv.setText("이미지뷰:" + i);

            i++;
            i = i % imageId.length;  // i : 0 ~ 5 순환
        }
    } // end MyListener

}