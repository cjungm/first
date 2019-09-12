package com.gmail.candy7manner.eleventh_handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Thread1 extends AppCompatActivity {

    //* Thread 클래스(run 함수의 구현 포함)를 별도로 정의하고,
    // Thread의 객체를 메인 Activity내에서 생성하고 Tread를 start시킴.

    int mainValue = 0;
    int backValue1 = 0;
    int backValue2 = 0;
    TextView tvMainValue;
    TextView tvBackValue1;
    TextView tvBackValue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread1);

        tvMainValue = (TextView)findViewById(R.id.tvMainValue);
        tvBackValue1 = (TextView)findViewById(R.id.tvBackValue1);
        tvBackValue2 = (TextView)findViewById(R.id.tvBackValue2);

        // 일반적인 자바 프로그래밍에서는 메인스레드가 종료되면, 작업스레도도 잘(?) 종료되지만
        // 안드로이드 액티비티에선 메인스레드가 종료되도 (어플이 종료되도) 작업스레드가
        // 종료되지 않는 경우가 있습니다.  그래서 setDaemon(true) 메소드를 통해
        // 메인스레드와 종료동기화를 시킵니다.

        BackThread1 thread1 = new BackThread1();  // 작업쓰레드 생성
        thread1.setDaemon(true);   // 메인쓰레드와 종료 동기화!
        thread1.start();   // 작업쓰레드 시작!

        BackRunnable runnable = new BackRunnable();
        Thread thread2 = new Thread(runnable); //
        thread2.setDaemon(true);  // 메인쓰레드와 종료 동기화!
        thread2.start();


    } // end onCreate

    public void mOnClick(View v){
        mainValue++;
        tvMainValue.setText("메인스레드값:" + mainValue);
        tvBackValue1.setText("작업스레드1 값:" + backValue1);
        tvBackValue2.setText("작업스레드2 값:" + backValue2);

    } // end mOnClick()


    class BackThread1 extends Thread{
        @Override
        public void run() {
            while(true){
                backValue1++;   // 작업쓰레드 값1 증가

                try{
                    Thread.sleep(1000);   // 1초 단위 지연
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                // 만약 작업쓰레드가 메인 UI를 건드리려 하면?
                // tvBackValue1.setText(backValue1);
            }
        }
    }

    // Runnable 인터페이스를 구현한 클래스
    class BackRunnable implements Runnable{

        @Override
        public void run() {
            while(true){
                backValue2 += 2;
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

}