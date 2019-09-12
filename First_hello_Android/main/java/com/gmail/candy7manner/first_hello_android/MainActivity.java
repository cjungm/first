package com.gmail.candy7manner.first_hello_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //버튼 정의
        tv = findViewById(R.id.tv);

    }

    // KOR 버튼을 클릭했을때 호출되는 메소드 (onClick)
    public void changeKor(View v){
        //Text 변경
        tv.setText("안녕하세요 안드로이드");
        //Toast 메시지 띄우기
        Toast.makeText(this, "한국어", Toast.LENGTH_LONG).show();
        //Logcat을 통해 확인
        Log.d("JJ", "한국어를 클릭했습니다");
    }


    // ENG 버튼을 클릭했을때 호출되는 메소드
    public void changeEng(View v){
        tv.setText("Hello Android");
        Toast.makeText(this, "영어", Toast.LENGTH_LONG).show();
        Log.d("JJ", "영어 를 클릭했습니다");
    }

}
