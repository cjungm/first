package com.example.mobileprogramming;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ReceiveAlarm extends BroadcastReceiver {

    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context=context;
        // intent로부터 전달받은 string
        String get_yout_string2 = intent.getExtras().getString("state2");


        // RingtonePlayingService 서비스 intent 생성
        Intent service_intent2 = new Intent(context, MusicService.class);
        Log.d("여기","여기");



        // RingtonePlayinService로 extra string값 보내기
        service_intent2.putExtra("state2", get_yout_string2);
        // start the ringtone service
        Log.d("전달","여기");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            this.context.startForegroundService(service_intent2);
        }else{
            this.context.startService(service_intent2);
        }
    }
}
