package com.gmail.candy7manner.twentieth_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
  서비스 Service - 안드로이드의 4대 컴포넌트 중 하나
 - 화면이 없이 백그라운드에서 동작함
 ex) 배경음악 재생, 파일 다운로드, 파일 입출력,
     네트워크 트랜잭션.
     주기적인 작업 (업데이트, 사용량, GPS 등..)
     IPC (Interprocess communication) 기능
     '콘텐츠 제공자'와의 통신
 - 일반적으로 Activity (혹은 Application) 에서 호출되어 시작하게 됨.
  - Service 의 종류
      1. unbound service (혹은 started service 라고도 함): "시작 타입 서비스"
          >일단 시작하면 무한 실행
          >보통은 Activity에서 startService() 를 호출하여 서비스 시작
          >호출한 Activity가 소멸되어도 서비스 동작.
          >호출한 쪽에 결과 반환 불가.
          >파일 다운로드는 started service로 구현하곤 한다.
      2. bound service : "연결 타입 서비스"
          >Service 를 호출한 Activity가 실행되는 동안만 실행
          >보통은 Activity에서 bindService() 를 호출하여 서비스 시작.
          >[Activity - Service] 는 마치 [클라이언트 - 서버] 처럼 동작.
              즉, Activity 에서는 Service 에 '요청' 하고
              Service 는 Activity 에 '결과' 를 보내줄수 있다
          >bound service 는 Activity 와 bind 되어있는 동안에만 실행.
          >하나의 Service 에 다수의 Activity가 bind 가능.
      3. 복합 unbound + bind service
          >두가지 방식으로도 작동 가능
          >그러려면 양쪽의 콜백 메소드들을 구현해 놓아야 한다.
           즉 onStartCommand() 와 onBind() 둘다 구현해야 한다.
  - Service 도 Intent 를 사용하여 시작한다.
  - Service 는 호출한 프로세스의 메인 쓰레드 안에서 실행된다.
      먄악 CPU 많이 소모하는 작업이라면 Service 안에서 새로운 쓰레드로 동작시켜서 메인 쓰레드의 부담을 덜어야 한다.
  - Service 구현 순서.
      1. 사용할 Service (*.java)를 만든다.  (Service 클래스 상속)
      2. AndroidManifest.xml 에 Service를 등록한다
      3. 필요한 콜백 메소드 구현
      4. Service 를 시작하도록 호출한다
  - 아래 예제를 실행시키면서, 음악실행중에 다른 앱 전환해보면서 동작과 Log 를 확인해보자.
*/


public class MainActivity extends AppCompatActivity {

    Button btnStart;
    Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 서비스 시작하기
                Log.d("myapp", "액티비티-시버스 시작버튼 클릭");

                Intent intent = new Intent(getApplicationContext(),
                        MyService.class);    // 시작할 컴포넌트
                startService(intent);   // 서비스 시작

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 서비스 종료
                Log.d("myapp", "액티비티-서비스 종료버튼 클릭");
                Intent intent = new Intent(getApplicationContext(),
                        MyService.class);
                stopService(intent);   // 서비스 종료
            }
        });




    } // end onCreate


}
