package com.example.mobileprogramming;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3) ;

        button1.setOnClickListener((View.OnClickListener)this);
        button2.setOnClickListener((View.OnClickListener)this);
        button3.setOnClickListener((View.OnClickListener)this);

        final TextView selector_selected = (TextView) findViewById(R.id.selector_selected);
        final TextView selector_endabled = (TextView) findViewById(R.id.selector_enabled);
        final EditText selector_focused = (EditText) findViewById(R.id.selector_focused);


        // 클릭시 포커스를 준다.
        selector_focused.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selector_focused.requestFocus();
            }
        });

        // 클릭시 비사용 모드로 바꾼다.
        selector_endabled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selector_endabled.setEnabled(false);
            }
        });

        // 클릭시 선택된다.
        selector_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selector_selected.setSelected(true);
            }
        });
    }
    //취소버튼 처리
    private long time= 0;
    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()-time>=2000){
            time=System.currentTimeMillis();
            Toast.makeText(getApplicationContext(),"뒤로 버튼을 한번 더 누르면 종료합니다.",Toast.LENGTH_SHORT).show();
        }else if(System.currentTimeMillis()-time<2000){
            finish();
        }


    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button1){
            Intent intent = new Intent(this,AlarmNormal.class);
            startActivity(intent);

        }
        else if(v.getId()==R.id.button2){
            Intent intent = new Intent(this,AlarmHell.class);
            startActivity(intent);

        }
    }
}
