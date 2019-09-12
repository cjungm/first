package com.gmail.candy7manner.twentysecond_contentprovider;

import android.app.Activity;
import android.content.ContentProvider;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//         컨텐트 프로바이더 (ContentProvider)
//         어플리케이션 내에서만 사용할 수 있는 데이터를 공유하기위한
//         방법으로 안드로이드의 4대 컴포넌트 중 하나이다
//
//         폰에 저장되있는 전화번호부를 읽어보기(권한 필요)
//         AndroidManifest.xml

        TextView tv = (TextView)findViewById(R.id.textView2);

        Cursor c =  getContentResolver().query(
                ContactsContract.CommonDataKinds
                        .Phone.CONTENT_URI,  // 조회할 컬럼명
                null, // 조회할 컬럼명
                null, // 조건 절
                null, // 조건절의 파라미터
                null);// 정렬 방향

        String str = ""; // 출력할 내용을 저장할 변수
        c.moveToFirst(); // 커서를 처음위치로 이동시킴
        do {
            String name = c.getString
                    (c.getColumnIndex(ContactsContract
                            .CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = c.getString
                    (c.getColumnIndex(ContactsContract
                            .CommonDataKinds.Phone.NUMBER));
            str += "이름 : " + name
                    +"폰번호 : " + phoneNumber + "\n";
        } while (c.moveToNext());//데이터가 없을 때까지반복
        tv.setText(str);
    } // end of onCreate
} // end of class

