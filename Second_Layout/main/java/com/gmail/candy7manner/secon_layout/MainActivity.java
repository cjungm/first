package com.gmail.candy7manner.secon_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // 액티비티가 최초 생성될때 수행되는 메소드
    // main() 의 역할?????
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout1);
    }
}