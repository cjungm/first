package com.gmail.candy7manner.third_listener;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    LinearLayout ll;
    EditText et;

    //버튼 클릭 리스너에 대한 5가지 방법
    // 방법1 : 레이아웃 xml 의 onclick 에 지정
    // 방법2 : 익명클래스 (anonymous class) 사용
    /* 방법3 : lambda-expression 사용하기
    AndroidStudio 세팅 변경 필요 : Java8 사용
    File-Project Setting 에서 변경*/
    // 방법4 : implement 한 클래스 사용
    // 방법5 : 액티비티가 implement 한것을 사용

    // 계속 사용되므로 메소드로 정의함
    public void showText(String message){
        Log.d("myapp", message);  // Logcat 출력
        tv.setText(message);   // 화면 TextView 에 출력
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv1);
        ll = findViewById(R.id.ll);
        et = findViewById(R.id.et);


        // 방법2 : 익명클래스 (anonymous class) 사용
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // btn2 가 클릭 되었을때 호출되는 메소드
                showText("버튼2 클릭");
                tv.setBackgroundColor(Color.YELLOW);
            }
        });

        // 다양한 이벤트에 대한 리스너 등록 가능
        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // btn2가 longclick 되었을때 호출되는 메소드
                showText("버튼2 롱클릭");
                tv.setBackgroundColor(Color.CYAN);
                return true;  // event consuming : 더이상 onclick 으로 넘어가지 않는다
            }
        });

        // 방법3 : lambda-expression 사용하기
        // AndroidStudio 세팅 변경 필요 : Java8 사용
        // File-Project Setting 에서 변경
        Button btn3 = findViewById(R.id.btn3);

        btn3.setOnClickListener((v) -> {
            showText("버튼3 클릭");
            ll.setBackgroundColor(Color.rgb(164, 198, 57)); // r,g,b 색상 지정 가능
        });

        btn3.setOnLongClickListener((v) -> {
            showText("버튼3 롱클릭");
            tv.setTextColor(Color.parseColor("#6638e2"));  // 16진수 색상 문자열 가능
            return true;  // event consume
        });

        // 방법4 : implement 한 클래스 사용
        class MyListener implements View.OnClickListener {

            String name;

            // 별도의 클래스 만들면, 리스너 생성단계에서 별개의 세팅값 넘겨줄수 있다.
            public MyListener(String name){ this.name = name; }

            @Override
            public void onClick(View view) {
                String tag = (String)view.getTag();
                String text = (String)((Button)view).getText();  // 버튼위의 text 가져오기
                String message = name + "버튼" + text + "클릭[" + tag + "]";
                showText(message);

                et.setText(et.getText().append(name));

            }
        } // end inner class

        Button btnA = findViewById(R.id.btnA);
        Button btnB = findViewById(R.id.btnB);
        Button btnC = findViewById(R.id.btnC);
        Button btnD = findViewById(R.id.btnD);
        Button btnE = findViewById(R.id.btnE);
        Button btnF = findViewById(R.id.btnF);

        btnA.setOnClickListener(new MyListener("안녕1"));  // 리스너마다 개별설정 가능
        btnB.setOnClickListener(new MyListener("안녕2"));
        btnC.setOnClickListener(new MyListener("안녕3"));
        btnD.setOnClickListener(new MyListener("안녕4"));
        btnE.setOnClickListener(new MyListener("안녕5"));
        btnF.setOnClickListener(new MyListener("안녕6"));

        // 방법5 : 액티비티가 implement 한것을 사용
        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);


        // 연습
        // +, - 버튼 누르면 글씨 크기 커지고, 작아지게 하기
        Button btnInc = findViewById(R.id.btnInc);
        Button btnDec = findViewById(R.id.btnDec);

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float size = tv.getTextSize();

                tv.setTextSize(0, size + 2);
                String message = "글꼴사이즈->" + (int)(tv.getTextSize());
                showText(message);
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float size = tv.getTextSize();

                tv.setTextSize(0, size - 2);
                String message = "글꼴사이즈->" + (int)(tv.getTextSize());
                showText(message);
            }
        });



    } // end onCreate()

    // 방법1 : 레이아웃 xml 의 onclick 에 지정
    public void changeText(View v){
        showText("버튼 1이 클릭되었습니다");
    }

    // 방법5 : 액티비티가 implement 한것을 사용
    @Override
    public void onClick(View view) {
        showText("Clear 버튼이 클릭되었습니다");
        et.setText("");   // EditText 안에 빈 문자로...
    }
}
