package com.gmail.candy7manner.eighth_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Receice_Next extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면이 없는 액티비티
        Intent intent = getIntent();
        int a = intent.getIntExtra("num1", 0);
        int b = intent.getIntExtra("num2", 0);

        intent.putExtra("plus", a + b);
        intent.putExtra("minus", a - b);

        setResult(RESULT_OK, intent);  // 호출한 화면으로 되돌려 주기
        // ↑resultCode 값

        finish();  // 두번째 화면 종료
    }
}
