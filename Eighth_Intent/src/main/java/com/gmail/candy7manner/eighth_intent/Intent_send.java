package com.gmail.candy7manner.eighth_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Intent_send extends AppCompatActivity {

    // 화면(액티비티)전환 - 인텐트 사용 (인텐트 날린다?)
    // 1. 다음에 넘어갈 액티비티 준비
    // 2. 메니페스트에 액티비티 등록
    // 3. Intent 객체 만들어서 startActivity() 한다


    EditText etName;
    EditText etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_send);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),   // 현재 화면의 제어권자
                        MyTwo.class                 // 다음화면의 액티비티 클래스 지정
                );

                // 데이터를 Intent 에 실어서 보내기
                // name : 데이터 형태로 보냄
                intent.putExtra("num", 3);   // name, data 형태
                intent.putExtra("num2", 7);
                intent.putExtra("long", 33L);
                intent.putExtra("msg", "안녕하세요");

                // 이름, 나이 --> Receive_intent 에 담은뒤 Intent 에 실어 보내기
                Receive_intent p = new Receive_intent(etName.getText().toString(),
                        Integer.parseInt(etAge.getText().toString())
                );
                intent.putExtra("Receive_intent", p);

                startActivity(intent);   // 다음화면으로 넘어간다
            }
        });

        Button btnFinish = findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();  // 액티비티 종료
            }
        });

    } // end onCreate
}