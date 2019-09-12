package com.gmail.candy7manner.eighth_intent;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_lifecycle extends AppCompatActivity {

    EditText et1, et2;
    TextView tv;
    Button btn;

    // 엑티비티 생성 주기
    // 액티비티가 생성될때 호출되며
    // 사용자 인터페이스 초기화에 사용

    // 직전의 저장된 액티비티의 상태정보(state) 가 있다면
    // onCreate 호출될때 매개변수로 넘겨짐

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        Log.d("myapp", "onCreate");

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(et1.getText().toString().trim());
                int b = Integer.parseInt(et2.getText().toString().trim());
                tv.setText( "" + (a + b));
            }
        });

    } // end onCreate

    // 액티비티가 사용자에게 보여지기 바로 직전에 호출됨
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("myapp", "onStart");
    }

    // 액티비티가 동작, 즉 사용자와 상호작용. (포커스를 갖기시작) 할때 호출
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("myapp", "onResume");
    }

    // 다른 액티비티가 보여질때 호출됨,
    // 액티비티를 통해 다루던 데이터 저장, 쓰레드 중지.. 처리를 해야 함
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("myapp", "onPause");
    }

    // 액티비티가 더이상 안보여질때 호출되는 메소드.
    // 메모리 상황에 따라서 호출되지 않을수도 있슴.
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("myapp", "onStop");
    }

    // 액티비티 소멸될때 호출.
    // 시스템에 의해서 제거되기도 하고, 코드를 통해 finish() 제거되기도 함
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("myapp", "onDestory");
    }

    // onStop -> onStart 전환될때 호출됨.
    // 다시 시작할때
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("myapp", "onRestart");
    }

    // 직전의 저장된 액티비티의 상태정보(state) 가 있다면
    // onRestoreInstanceState 는 onStart 직후에 호출됨.
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("myapp", "onRestoreInstanceState");

        if(savedInstanceState != null){
            tv.setText(savedInstanceState.getString("value"));  // 백업한 값 복원하여 화면에 그리기
        }

    }

    // 액티비티 소멸전에 호출된다.
    // 주의 !  onPause 뒤에 호출된다고 간주하지 말것
    //    onDestroy 직전에 호출된다고 간주하지 말것.
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("myapp", "onSaveInstanceState");

        outState.putString("value", tv.getText().toString());  // 액티비티의 상태값 Bundle 에 저장

    }

} // end Activity

