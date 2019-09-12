package com.gmail.candy7manner.tenth_storage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Out_storage extends AppCompatActivity {

// 외부 메모리에 파일 읽기/쓰기
// 1. 외부 메모리 장치가 있는지 확인해야한다
// 2-1 AndroidManifest.xml 외부메모리 저장권한 (WRITE_EXTERNAL_STORAGE) 을 선언해야 함  (API 23 이전 버젼)
// 2-2 API 23+ (마시멜로): 새로운 권한 획득 방법 사용.
//      Run-time 에 onRequestPermissionsResult() 사용 해야 한다!!!
//      https://developer.android.com/training/permissions/requesting.html
// 3. 읽기/쓰기 경로를 지정한다


    EditText etInput;
    Button btnSave, btnRead;
    TextView tvResult;

    String state;   // 외부 저장소의 상태 정보를 담을 변수

    // permission 관련 문자열들
    String [] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    final int myRequestCode = 100;  // 권한요청 코드

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.out_storage);

        etInput = findViewById(R.id.etInput);
        btnRead = findViewById(R.id.btnRead);
        btnSave = findViewById(R.id.btnSave);
        tvResult = findViewById(R.id.tvResult);

        if(checkSelfPermission(String.valueOf(permissions)) == PackageManager.PERMISSION_DENIED){
            requestPermissions(permissions, myRequestCode);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkExternalStorage()) return;   // 외부메모리 사용하지 못하면 끝냄

                String data = etInput.getText().toString();

                try{
                    // 사진담는 경로 획득
                    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                    File f = new File(path, "external.txt");  // 경로 + 파일명
                    FileWriter write = new FileWriter(f, false);  // append : true이면 append mode,false 이면 쓰기 모드(덮어쓰기 된다)
                    PrintWriter out = new PrintWriter(write);
                    out.println(data);
                    out.close();
                    tvResult.setText("저장 완료");

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("myapp", e.getMessage());
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkExternalStorage()) return;  // 외부메모리 사용여부 항상 체크

                try{
                    StringBuffer data = new StringBuffer();
                    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                    File f = new File(path, "external.txt");

                    BufferedReader buffer = new BufferedReader(new FileReader(f));
                    String str = buffer.readLine();
                    while(str != null){
                        data.append(str + "\n");
                        str = buffer.readLine();
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
    } // end onCreate

    // 권한 획득 결과가 오면 실행되는 메소드
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch(requestCode){
            case myRequestCode:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // 권한 요청 승인됨
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_LONG).show();
                } else {
                    // 권한 요청 거부됨.
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show();

                    // 권한이 없으면 진행못하는 액티비티라면 여기서 destroy!
                    // onDestroy();
                }
                return;
        }

    } // end onRequestPermissionsResult

    // 외부 메모리 장착상태 확인 메소드
    boolean checkExternalStorage(){
        state = Environment.getExternalStorageState();
        Log.d("myapp", "외부메모리상태:" + state);

        String msg = "";

        // 외부메모리 상태
        if(Environment.MEDIA_MOUNTED.equals(state)){
            // MEDIA_MOUNTED : 장착, 읽기+쓰기 모두 가능
            msg = "외부 메모리 읽기 쓰기 모두 가능";
            Log.d("myapp", msg);
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            return true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            // MEDIA_MOUNTED_READ_ONLY : 장착, 읽기 만 가능
            msg = "외부 메모리 읽기만 가능";
            Log.d("myapp", msg);
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            return false;
        } else {
            // 읽기 쓰기 모두 안됨.
            msg = "외부메모리 사용불가" + state;
            Log.d("myapp", msg);
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            return false;
        }
    }
} // end Activity
