package com.gmail.candy7manner.fourth_widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Checkbox extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox cb1, cb2, cb3, cb4;
    TextView tvResult2;

//    onCheckedChanged:   상태가 변할때 마다 호출되는 메소드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox);

        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);

        Button btnComplete = findViewById(R.id.btnComplete);
        final TextView tvResult = findViewById(R.id.tvResult);
        tvResult2 = findViewById(R.id.tvResult2);

        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = "";
                if(cb1.isChecked()) result += cb1.getText();  // is...  has...
                if(cb2.isChecked()) result += cb2.getText();
                if(cb3.isChecked()) result += cb3.getText();
                if(cb4.isChecked()) result += cb4.getText();
                tvResult.setText("선택결과: " + result);
            }
        });

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
    } // end onCreate

    // CheckBox 상태가 변할때 마다 호출되는 메소드
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        int count = 0;
        if(cb1.isChecked()) count++;
        if(cb2.isChecked()) count++;
        if(cb3.isChecked()) count++;
        if(cb4.isChecked()) count++;
        tvResult2.setText(count + "개 선택");


    } // enc onCheckedChanged()

} // end Activity