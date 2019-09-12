package com.gmail.candy7manner.eleventh_handler;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*  타이머 구현하기
   방법 #1 핸들러 객체를 외부에서 생성
   방법 #2 핸들러 객체를 멤버변수로 하고 메소드 내부에서 생성
   방법 #3 CountDownTimer 사용
   방법 #4 handler.postDelayed() 사용
*/
public class Make_timer extends AppCompatActivity {

    int value1 = 0, value2 = 0, value3 = 0, value4 = 0;
    TextView tvResult1, tvResult2, tvResult3, tvResult4;
    Handler mHandler2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_timer);
        tvResult1 =(TextView)findViewById(R.id.tvResult1);
        tvResult2 =(TextView)findViewById(R.id.tvResult2);
        tvResult3 =(TextView)findViewById(R.id.tvResult3);
        tvResult4 =(TextView)findViewById(R.id.tvResult4);

        // #1 핸들러 객체를 외부에서 생성
        mHandler1.sendEmptyMessage(0);  // 앱 시작과 동시에 핸들러에 메세지 전달

        // #2 메소드 내부에서 생성
        // 메소드 내부에서 생성
        mHandler2 = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                value2 += 2;
                tvResult2.setText("Value2 = " + value2);

                // 메세지 처리하고 또다시 핸들러에 메세지 전달
                mHandler2.sendEmptyMessageDelayed(0, 700); // 700ms 지연
            }
        };
        mHandler2.sendEmptyMessage(0);  // 위 핸들러에 메세지 전달 (시작!)


        // #3
        // 핸들러를 사용하지 않고도 일정시간마다 (혹은 후에) 코스를 수행할수 있도록
        // CountDownTimer 클래스가 제공된다.
        // '총시간'  과 '인터벌(간격)' 을 주면 매 간격마다 onTick 메소드를 수행한다.
        new CountDownTimer(10 * 1000, 1000){
            @Override
            public void onTick(long l) {  // millisUntilFinished
                value3++;
                tvResult3.setText("Value3=" + value3);
            }

            // 타이머 종료직후 호출
            @Override
            public void onFinish() {
                tvResult3.setText("CountDownTimer 종료");
            }
        }.start();    // 타이머 시작!

        //#4
        new TimerThread().start();


    } // end onCreate

    // #1 핸들러 객체를 외부에서 생성
    Handler mHandler1 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            value1++;
            tvResult1.setText("Value1=" + value1);

            // 메세지 처리하고 또다시 핸들러에게 메세지 전달!
            mHandler1.sendEmptyMessageDelayed(0, 1000);   // 1초 뒤에 메세지 전달

        }
    };

    // #4
    Handler mHandler4 = new Handler();
    class TimerThread extends Thread{
        @Override
        public void run() {
            mHandler4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(value4 <= 10){
                        tvResult4.setText("Value4 : " + value4);
                        value4 += 1;
                        mHandler4.postDelayed(this, 1000);  // 1초후에 자신을 호출
                    } else {
                        // 타이머 종료후 처리
                        tvResult4.setText("타이머4 종료");
                    }
                }
            }, 1000);  // 1초 후에 시간 표시
        }
    }
}