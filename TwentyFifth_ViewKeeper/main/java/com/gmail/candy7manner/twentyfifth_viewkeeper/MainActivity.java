package com.gmail.candy7manner.twentyfifth_viewkeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

//    안드로이드 화면(액티비티)가 계속 켜짐 (혹은 꺼짐 방지) 하려면,
//    액티비티의 onCreate() 에 아래라인 추가하면 됩니다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //화면 꺼짐 방지
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
}

