package com.gmail.candy7manner.tenth_storage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Use_sharedpreference extends AppCompatActivity {

    EditText etInput;
    String sfName = "myFile";  // SharedPreference 파일명

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_sharedpreference);

        etInput = findViewById(R.id.etInput);

        // 지난번 저장해 놨던 입력값을 꺼내서 보여주기
        SharedPreferences sf = getSharedPreferences(sfName, MODE_PRIVATE);

        String str = sf.getString("name", "");  // name 이라는 키값으로 꺼냄
        etInput.setText(str);

        Toast.makeText(this, str, Toast.LENGTH_LONG).show();

    } // end of onCreate

    @Override
    protected void onPause() {
        super.onPause();
        // SharedPreferences 에 설정값, 백업하기
        SharedPreferences sf = getSharedPreferences(sfName, MODE_PRIVATE);
        SharedPreferences.Editor editor = sf.edit();   // 저장하기위해 Editor 객체 가져옴
        String str = etInput.getText().toString();  // 사용자가 입력한 값
        editor.putString("name", str);  // 키-값 의 쌍으로 저장
        editor.commit();   // 파일에 최종 반영
    }
} // end Activity
