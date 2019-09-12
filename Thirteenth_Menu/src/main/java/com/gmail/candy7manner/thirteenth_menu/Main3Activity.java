package com.gmail.candy7manner.thirteenth_menu;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    /* ActionBar = 타이틀바 + 옵션메뉴
     */
    ActionBar aBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        aBar = getSupportActionBar();  // ActionBar 객체 가져오기
        // aBar.show();  // 액션바 보이기
        // aBar.hide();  // 액션바 안보이게 가능

        Button btnActionIcon = findViewById(R.id.btnActionIcon);
        btnActionIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aBar.setLogo(R.drawable.korea);  // 아이콘으로 변경
                aBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME |
                        ActionBar.DISPLAY_USE_LOGO);
            }
        });
// DISPLAY_SHOW_HOME : 홈아이콘 표시
// DISPLAY_USE_LOGO : 홈아이콘 부분에 로고 아이콘 사용

        /*
        ||   &&  <-- 논리연산자
        |   &    <-- 비트연산자
         */

        Button btnActionTitle = findViewById(R.id.btnActionTitle);
        btnActionTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
            }
        });

    } // end onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main3, menu);

        // 액션바에 EditText 로 입력가능
        View v = menu.findItem(R.id.menu_search).getActionView();
        if(v != null){
            EditText editText = v.findViewById(R.id.editText);
            if(editText != null){
                editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        Toast.makeText(getApplicationContext(), "입력완료", Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        showInfo(item);

        return super.onOptionsItemSelected(item);
    }

    public void showInfo(MenuItem item){
        int id = item.getItemId();   // 옵션메뉴 아이템의 id 값
        String title = item.getTitle().toString();   // 옵션 메뉴의 title
        int groupId = item.getGroupId();   // 옵션 메뉴의 그룹아이디
        int order = item.getOrder();

        String msg = "id:" + id + " title:" + title + " groupid:" + groupId + " order:" + order;
        Log.d("myapp", msg);
        Toast.makeText(getApplicationContext(), title + " 메뉴 클릭", Toast.LENGTH_SHORT).show();
    }
}