package com.gmail.candy7manner.twentyfirst_broadcast;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

/*
방송 수신자 (BroadcastReceiver)
안드로이드 기기 장치의 많은 이벤트들을 수신하는 메커니즘
ex) 배터리 부족
  네트워크/WIFI  연결/끊김
  SD 카드 삽입 / 해제
  1.방송 수신을 처리할 리시버 파일 (*.java) 만들기
  2.receiver 를 등록한다 AndroidManifest.xml
      어떤 방송을 받을 것인지 지정해야 한다 ★
      ex) 문자 수신 : android.provider.Telephony.SMS_RECEIVED
  3.권한을 획득한다 AndroidManifest.xml
   ★ API23+ 인경우 SMS 읽기 권한은 실행시간 권한 획득을 해야 한다.
  ※ AVD로 실행하는 경우 문자 메세지 받기.
  : AVD 의 Extended Controls - Phone - SMS message - [SEND MESSAGE] 로 확인
*/


public class MainActivity extends AppCompatActivity {


    // permission 관련 문자열들
    String [] permissions = {Manifest.permission.RECEIVE_SMS};
    final int myRequestCode = 100;  // 권한요청 코드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 권한 획득하기
        // 참조 : AutoPermissions 사용하면 편하다.
        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(String.valueOf(permissions)) == PackageManager.PERMISSION_DENIED){
                requestPermissions(permissions, myRequestCode);
            }
        }

    }

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
}
