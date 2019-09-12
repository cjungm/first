package com.gmail.candy7manner.eleventh_handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/*
핸들러 관련하여 포스팅할때  'Message' 나 'Runnable' 을  해당 핸들러로 ‘보낸다’ 라고 했는데,
핸들러에서는 받은  'Message' 나 'Runnable' 를 바로 처리하는 것이 아닙니다.
이는 동시에 여러가지가 들어올수 있기 때문입니다.
그래서 들어온  'Message' 나 'Runnable' 은  메세지 큐 (Message Queue) 에 차곡차곡 쌓여있다가 들어온 순서대로 처리하게 됩니다.
이때 큐 (Queue) 에서 해당  'Message' 나 'Runnable' 을 끄집어 내어 처리하는 것이 바로 루퍼(Looper) 입니다.
안드로이드의 루퍼(Looper)에 대해 다시 정리하면 다음과 같습니다.
의미:
▫ 해당 핸들러로 전송되는 메시지나 Runnable은 우선 큐에 쌓이게 된다.
▫ 루퍼는큐에서메시지나 Runnable은 꺼내어 해당핸들러로 전달하는역할을 한다.
• 루퍼의 사용 방법:
▫ 메인스레드는 기본적으로 루퍼를 가지므로,  프로그램 개발자는 메인스레드의 루퍼에 대해 관여하지 않아도 된다.
▫ 그러나, 작업스레드의 루퍼는 기본적으로 제공되지 않는다.
▫ 따라서, 작업스레드에서 메시지나 Runnable을 수신하는 경우에는
프로그램 개발자가 작업스레드에 루퍼를 직접 생성하고 실행시켜야, 작업
스레드가 메시지나 Runnable을 수신할 수 있다.
• 사용예:
▫ 작업스레드에서 메시지나 Runnable을 수신할 수 있도록 하기 위해서는
작업스레드의 run 함수안에서 다음을 호출해야 한다.
   Looper.prepare() : 작업스레드를 위한루퍼를준비한다.
   Looper.loop() : 큐에서 메시지를 꺼내 핸들러로 전달한다.
*/


public class Handler_looper extends AppCompatActivity {
    // 작업스레드에서 메시지나 runnable 을 받아야 하는 경우
    int mMainValue = 0;
    TextView tvMainValue;
    TextView tvBackValue;
    EditText etNumber;
    CalcThread mThread;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_looper);

        tvMainValue = (TextView)findViewById(R.id.tvMainValue);
        tvBackValue = (TextView)findViewById(R.id.tvBackValue);
        etNumber = (EditText)findViewById(R.id.etNumber);

        // TODO
        mThread = new CalcThread(mHandler);
        mThread.setDaemon(true);
        mThread.start();

    } // end onCreate()

    // 메인에서 생성한 Handler
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            // 메세지에 담앙온 값을 main ui 에 출력
            switch (msg.what){
                case 0:
                    tvBackValue.setText("Square Result : " + msg.arg1);
                    break;
                case 1:
                    tvBackValue.setText("Root Result : " + ((Double)msg.obj).doubleValue() );
                    break;
            }
        }
    };




    public void mOnClick(View v) {

        Message msg;

        switch (v.getId()){  // 어느 버튼인지?  id 값 추출해서 식별
            case R.id.btnIncrease:
                mMainValue++;
                tvMainValue.setText("MainValue: " + mMainValue);
                break;
            case R.id.btnSquare:
                msg = new Message();
                msg.what = 0;
                msg.arg1 = Integer.parseInt(etNumber.getText().toString());
                mThread.backHandler.sendMessage(msg);  // 메인 --> 작업스레드에 메세지를 던지다!
                break;
            case R.id.btnRoot:
                break;
        } // end switch

    } // end mOnClick()

} // end Activity


class CalcThread extends Thread{
    Handler mainHandler; // 메인스레드쪽 Handler (메인스레드가 생성한 Handler)
    Handler backHandler;  // 작업스레드가 생성한 Handler

    CalcThread(Handler mainHandler){
        this.mainHandler = mainHandler;    // 메인스레드의 Handler 받아오기
    }

    @Override
    public void run() {
        Looper.prepare();  // 작업스레드에서 생성하는 Handler 를 위해 준비하는 Looper

        backHandler = new Handler(){  // '작업스레드' 에서 만든 Handler !!!
            @Override
            public void handleMessage(@NonNull Message msg) {

                Message retMsg = new Message();

                switch(msg.what){
                    case 0:
                        Log.d("myapp", "0번 메제시 수신 --> 작업스레드");
                        try{ Thread.sleep(200); } catch (InterruptedException e){;}
                        retMsg.what = 0;
                        retMsg.arg1 = msg.arg1 * msg.arg1;
                        break;
                    case 1:
                        break;
                }
                mainHandler.sendMessage(retMsg);  // 작업스레드가 계산한 결과값을 메세지 에 담아 메인 Handler 에 보낸다

            }
        };
        Looper.loop();  // 메세지 큐에서 메세지를 꺼내 핸들러로 전달함.

    }
} // end CalcThread
