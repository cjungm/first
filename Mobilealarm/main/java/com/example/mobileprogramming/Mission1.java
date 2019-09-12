package com.example.mobileprogramming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Mission1 extends Activity implements View.OnClickListener {
    EditText edtName,edtResult;
    Button home2,prod,btnAdd,btnNext;
    TextView view2;
    Random rnd = new Random();
    int a = rnd.nextInt(1000)+0;
    int b = rnd.nextInt(1000)+0;
    final int c = a + b;
    String numStr1 = String.valueOf(a);
    String numStr2 = String.valueOf(b);
    int answer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mission1);
        home2=(Button)findViewById(R.id.home2);
        prod=(Button)findViewById(R.id.prod);
        home2.setOnClickListener(this);
        prod.setOnClickListener(this);
        edtName     =(EditText)findViewById(R.id.edtName);
        edtResult   =(EditText)findViewById(R.id.edtResult);
        btnAdd      =(Button) findViewById(R.id.btnAdd);
        view2        =(TextView)findViewById(R.id.view2);
        btnNext=(Button)findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);



        view2.setText(numStr1+ " + " +numStr2);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer =edtName.getText().toString();
                answer2 = Integer.parseInt(answer);
                if(answer2==c) {
                    edtResult.setText("정답입니다.");
                }
            }
        });
    }
    @Override
        public void onBackPressed() {
            super.onBackPressed();
        }
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.home2){
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            else if(v.getId()==R.id.btnNext){
                Intent intent = new Intent(this,Mission2.class);
                startActivity(intent);
                finish();
            }
    }
}