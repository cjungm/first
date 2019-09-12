package com.gmail.candy7manner.twentyfirst_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

// 방송되고 있는 내용중에 원하는 항목을 받았을 경우
//  처리할 내용 작성
//  예제: 문자 수신
public class MyReceiver extends BroadcastReceiver {

    // 수신되었을때 호출되는 메소드
    // 매개변수 intent에   방송의 '종류' 가 들어있고
    //    필드에 '추가정보' 들이 들어있다.
    @Override
    public void onReceive(Context context, Intent intent) {
        // SMS 메세지 파싱
        Bundle bundle = intent.getExtras();
        String str = "";

        if(bundle != null){  // 수신된 내용이 있으면
            // 실제 메세지는 Object 타임의 배열에 PDU 형식으로 저장됨.
            // PDU(Protocol Data Unit) 는 SMS 전송 포맷,  3GPP 기관에서 관리
            Object [] pdus = (Object[])bundle.get("pdus");

            SmsMessage[] msgs = new SmsMessage[pdus.length];
            for(int i = 0; i < msgs.length; i++){
                // PDU 포맷으로 되어 있는 메세지 복원
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);

                str += msgs[i].getOriginatingAddress()
                        + " 에게 문자왔슴, " +
                        msgs[i].getMessageBody().toString()
                        + "\n";
            }
            Toast.makeText(context, str, Toast.LENGTH_LONG).show();
            Log.d("myapp", str);
        }


    }
}
