package com.gmail.candy7manner.fifth_image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Variableimage extends AppCompatActivity {

//    다양한 이미지 세팅 방법
//     방법1 : 프로젝트 내의 res/drawable 폴더에 있는 파일을 보여주기 (id)
//     방법2 : Drawable 객체를 이용해서 보여주는 방법
//     방법3 : bitmap 객체를 이용해서 보여주는 방법

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.variableimage);

        ImageView iv1 = findViewById(R.id.imageView2);
        ImageView iv2 = findViewById(R.id.imageView3);
        ImageView iv3 = findViewById(R.id.imageView4);

        // 방법1 : 프로젝트 내의 res/drawable 폴더에 있는 파일을 보여주기 (id)
        iv1.setImageResource(R.drawable.a2);

        // 방법2 : Drawable 객체를 이용해서 보여주는 방법
        Drawable drawable = getResources().getDrawable(R.drawable.a3);
        iv2.setImageDrawable(drawable);

        // 방법3 : bitmap 객체를 이용해서 보여주는 방법
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.a4);
        iv3.setImageBitmap(bm);

    } // end onCreate()
}