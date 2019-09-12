package com.gmail.candy7manner.thirteenth_menu;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btnPopup = findViewById(R.id.btnPopup);

        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 클릭시 팝업메뉴 나오게 하기
                // PopupMenu 객체 <-- API11 부터 제공
                PopupMenu p = new PopupMenu(
                        getApplicationContext(),   // 현재 화면의 제어권자
                        view   // anchor : 팝업을 띄울 기준이 될 위젯
                );
                getMenuInflater().inflate(R.menu.menu_main5, p.getMenu());

                // 팝업메뉴 이벤트 처리
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        showInfo(menuItem);
                        return false;
                    }
                });

                p.show();  // 팝업메뉴 띄우기
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main5, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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