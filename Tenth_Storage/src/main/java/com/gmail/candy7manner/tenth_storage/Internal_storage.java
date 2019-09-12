package com.gmail.candy7manner.tenth_storage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
    안드로이드 에서 자료를 저장하는 4가지 수단
    1. 내부파일 사용 (Internal Storage)
    2. 외부메모리 사용 (External Strage)
    3. SQLite  (내장 DataBase)
    4. SharedPreference
    ** 외부에 (서버, 네트워크, 외부 DB) 사용이 아닌 내부 저장수단
 */

public class Internal_storage extends AppCompatActivity {

    EditText et;
    Button btnAppend, btnRead;
    TextView tvResult;

//    1. 내부파일 사용 (Internal Storage)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internal_storage);

        et = findViewById(R.id.et);
        btnAppend = findViewById(R.id.btnAppend);
        btnRead = findViewById(R.id.btnRead);
        tvResult = findViewById(R.id.tvResult);

        // 추가하기 버튼클릭하면 파일에 추가로 저장하기
        btnAppend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = et.getText().toString();

                try{
                    FileOutputStream fos = openFileOutput("myfile.txt", MODE_APPEND); // 파일명, 저장모드
                    PrintWriter out = new PrintWriter(fos);
                    out.println(data);
                    out.close();
                    tvResult.setText("파일 저장 완료");
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 파일의 내용을 읽어서 TextView 에 보여주기
                try{
                    StringBuffer data = new StringBuffer();
                    FileInputStream fis = openFileInput("myfile.txt"); // 파일명
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(fis));
                    String str = buffer.readLine();   // 파일에서 한줄 읽어오기

                    while(str != null){  // 더이상 읽을게 없으면 null 리턴
                        data.append(str + "\n");
                        str = buffer.readLine();  // 다음 한줄 읽기
                    }

                    tvResult.setText(data);
                    buffer.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}