package com.gmail.candy7manner.twentieth_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    MediaPlayer mp;  // 음악재생

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 서비스에서 가장 먼저 호출됨 (최초 한번만)
        // 서비스가 이미 실행되고 있는 경우에는 호출되지 않습니다.
        Log.d("myapp", "서비스의 onCreate()");
        mp = MediaPlayer.create(this, R.raw.chacha);
        mp.setLooping(false);   // 반복재생 안함

        // 음악종료되면
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("myapp", "음악 종료");
                stopSelf();    // 음악 종료되면 서비스 종료
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 서비스가 종료될때 실행, 서비스 라이프사이클의 마지막.
        Toast.makeText(this, "Service 중지", Toast.LENGTH_LONG).show();
        mp.stop();  // 음악종료
        mp.release();
        Log.d("test", "서비스의 onDestroy()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 타 컴포넌트에서 startService() 를 통해 서비스가 가동되어야 할때마다 호출
        // Service 작업 완료후에는 stopSelf() 나 stopService() 를 호출하여 서비스 종료해야함.
        //   (종료 안하면?  무한 실행됨)
        // Bound Service 의 경우 onStartCommand 를 꼭 재정의할 필요는 없다.

        Toast.makeText(this, "Service 시작: ", Toast.LENGTH_LONG).show();
        Log.d("myapp", "서비스의 onStartCommmand()");
        mp.start();  // 연주시작
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // 타 컴포넌트에서 bindService(),를 통해 연결 시도하면 호출됨
        // IBinder 객체를 리턴하며 서비스 <--->  타컴포넌트  간 통신하는데 사용
        // 연결을 원치 않으면 null 리턴 하면 됨.
        Log.d("myapp", "서비스의 onBind()");
        return null;
    }
}
