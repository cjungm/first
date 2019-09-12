package com.gmail.candy7manner.eighth_intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class Make_Layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // setContentView()  <-- 없다!

        // Java 코드내에서 Layout 및 포함된 View 객체들을 생성해서 화면에 그려줄수 있다.
        LinearLayout ll = new LinearLayout(this);

        ll.setOrientation(LinearLayout.VERTICAL);

        // 필요한 위젯(뷰 객체)들 정의하고, 속성 세팅
        Button b1 = new Button(this);
        Button b2 = new Button(this);

        b1.setText("첫번째 버튼");
        b2.setText("두번째 버튼");

        ll.addView(b1, LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.addView(b2, LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        setContentView(ll);  // 액티비티 화면에 보여줄 layout 객체 등록

    } // end onCreate()
} // end class
