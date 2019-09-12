package com.gmail.candy7manner.fourth_widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Radiobutton extends AppCompatActivity {

    RadioGroup rg;
    Button btnResult;
    TextView tvResult;

    // 체크박스와는 달리
    // RadioButton 은 각각 선언하는 것이 아니라 RadioGroup 으로 선언하여 사용.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton);

        rg = findViewById(R.id.rgroup1);
        btnResult = findViewById(R.id.btnResult);
        tvResult = findViewById(R.id.tvResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rg.getCheckedRadioButtonId();  // 선택된 라디오버튼의 id
                RadioButton rb = findViewById(id);      // 위 id 값을 통해 RadioButton 뷰객체 가져오기
                tvResult.setText("결과:" + rb.getText());
            }
        });

        // 라디오버튼을 선택했을때도 위와 같은 동작하게 (버튼 누르지 않아도..)
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton rb = findViewById(checkedId);      // 위 id 값을 통해 RadioButton 뷰객체 가져오기
                tvResult.setText("결과:" + rb.getText());
            }
        });

    } // end onCreate
}//end Activity