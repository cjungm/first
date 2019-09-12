package com.gmail.candy7manner.sixth_widget2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class Spinselector extends AppCompatActivity {

    TextView tv;
    Spinner s;

//    Spinner 사용하기
//    setOnItemSelectedListener:      스피너 누르면 호출되는 메소드
//    onItemSelected:                 아이템이 선택되면 adapter에서 몇번째 아이템인지 매개변수로 받아옴
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinselector);

        tv = findViewById(R.id.textView2);
        s = findViewById(R.id.spinner1);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // position 값은 i
                // 해당 position 의 값은 adapter 에서 가져옴
                tv.setText("position: " + i + adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    } // end onCreate()
}