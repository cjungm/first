package com.gmail.candy7manner.eighth_intent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Startactivity_result extends AppCompatActivity {

    EditText et1, et2;
    Button btnResult;
    TextView tvResult;

//    startActivityForResult:   intent를 통해 전달한 값의 결과를 받는 메소드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startactivity_result);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btnResult = findViewById(R.id.btnResult);
        tvResult = findViewById(R.id.tvResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(et1.getText().toString());
                int b = Integer.parseInt(et2.getText().toString());

                Intent intent = new Intent(getApplicationContext(), Receice_Next.class);
                intent.putExtra("num1", a);
                intent.putExtra("num2", b);

                // 화면전환.
                //startActivity(intent);
                // 값을 돌려받을 경우 화면 넘기는 메소드
                startActivityForResult(intent, 1);
            }
        });
    }// end onCreate()

    // 넘어갔던 화면으로부터 결과값을 돌려 받을때 호출
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){  // 정상 반환인 경우만

            int a = data.getIntExtra("plus", 0);
            int b = data.getIntExtra("minus", 0);

            tvResult.setText(requestCode + "] 받아온값: " + a + " : " + b );
        }
    } // end onActivityResult
}
