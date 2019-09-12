package com.gmail.candy7manner.fifth_image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Phoneimgae extends AppCompatActivity {

    /* 폰의 저장장치에 있는 사진을 ImageView 에 띄우기
        1. 권한획득
        2. 이미지의 경로
        3. Bitmap 으로 ImageView 에 띄우기
     */

    ImageView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phoneimgae);

        photoView = findViewById(R.id.photoView);

        String path = "/storage/emulated/0/DCIM/e.jpg";  // 안드로이드 내 이미지 경로

        Bitmap bm = BitmapFactory.decodeFile(path);

        photoView.setImageBitmap(bm);

    } // end onCreate()
} // end Activity