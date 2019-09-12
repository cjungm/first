package com.gmail.candy7manner.eleventh_handler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
• 작업 스케쥴링:
▫ 작업스레드의 실행 시점을 조절하여, 작업로드가 많은 작업을 나중으로 미룸으로써
응용프로그램이 '끊임'없이 실행될수 있도록함.
• 구현 방법:
▫ 핸들러의사용시 다음과 같은 메소드를 사용할수있음.
boolean sendMessageAtTime (Message msg, long delayMillis)
boolean sendMessageDelayed (Message msg, long delayMillis)
boolean postAtTime (Runnable r, long delayMillis)
boolean postDelayed (Runnable r, long delayMillis)
먼저, 핸들러로 메시지를 지연하여 보내는 경우 즉,
메인스레드가 메인스레드 자신에게 메시지를 보내는 경우의 예제를 보겠습니다.
*/

public class Schedueling extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedueling);
    }

    /* Android api28 으로 만들었어요.. */

    /* #1 :  스케쥴링 예제1(메인스레드가 메인스레드 자신에게 메시지 보내기)
     * */
    public void mOnClick1(View v) {

        new AlertDialog.Builder(this)
                .setTitle("질문1")
                .setMessage("업로드 하시겠습니까?")
                .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mHandler1.sendEmptyMessageDelayed(0, 3000);
                    }
                })
                .setNegativeButton("아니요", null)
                .show();
    }
    /*  #2
        핸들러로 Runnable 을 지연하여 보냄
        메인스레드가 메인스레드 자신에게 Runnable 을 보내는 경우임
        postDelayed() 사용
    */
    public void mOnClick2(View v) {
        new AlertDialog.Builder(this)
                .setTitle("질문2")
                .setMessage("업로드 하시겠습니까?")
                .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mHandler2.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                doUpload(2);
                            }
                        }, 5000);
                    }
                })
                .setNegativeButton("아니요", null)
                .show();
    }

    /* #3 View 에 Runnable 담아서 보냄
        Handler 가 필요없다.
     */
    public void mOnClick3(View v) {
        new AlertDialog.Builder(this)
                .setTitle("질문3")
                .setMessage("업로드 하시겠습니까?")
                .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 아래와 같이 View(Button)을 통해서도 Runnable 을 생성해서 보낼수 있다.
                        Button btnUpload3 = findViewById(R.id.btnUpload3);
                        btnUpload3.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                doUpload(3);
                            }
                        }, 4000);
                    }
                })
                .setNegativeButton("아니요", null)
                .show();

    }

    Handler mHandler1 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 0){
                doUpload(1);
            }
        }
    };

    Handler mHandler2 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };

    void doUpload(int n){
        Toast.makeText(this, n + " : 업로드 완료", Toast.LENGTH_LONG).show();
    }
}
