package com.gmail.candy7manner.eleventh_handler;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
자바는 자바가상머신 위에서 자체적으로 스레드를 생성하고 운영하긴 하지만, 사실 스레드 부분 만큼은 운영체제의 영향을 받게 됩니다.  안드로이드에서 돌아가는 자바도 결국 안드로이드 운영체제의 영향을 받을수 밖에 없는데, ..
안드로이드의 경우 '작업스레드' 가 '메인스레드'의 변수를 참조하거나 변경을 할수 있어도, '메인스레드' 에서 정의된 UI 를 변경할수는 없습니다.   그래서 Handler 를 통해서 이를 해결합니다.
가령 일전의 예에서
class BackThread1 extends Thread{  // Thread 를 상속받은 작업스레드 생성
  @Override
  public void run() {
      while (true) {
          backValue1++;  // 작업스레드 값 증가.
         tvBackValue1.setText("작업스레드 값: " + backValue1); // 안드로이드에선 불가능하다.
          try {
              Thread.sleep(1000);   // 1000ms, 즉 1초 단위로 작업스레드 실행
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }
} // end class BackThread1
CalledFromWrongThreadException 을 발생시킵니다.
이러한 문제로 인해 안드로이드에서 여러 Thread(스레드) 를 사용할때 메인스레드의 UI 등에 접근하려면 Handler 를 사용해야 합니다.
Handler 의 필요성에 대해 다시 한번 정리하면
•  안드로이드 에서 Handler 란?:
 ▫ 메인스레드와 작업스레드 간에 통신을 할 수 있는 방법.
• Handler가필요한주요이유:
  ▫ 작업스레드에서는 메인스레드의 변수를 참조하거나 변경할 수는 있지만, 메인스레 드에서 정의된 UI(예: 위젯, View 등)을 변경할 수는 없다.
  ▫ 작업스레드에서메인스레드의UI를변경할필요가 있을경우,작업스레드는 Handler를 통해 메인스레드에게 UI를 변경하라고 알릴 수 있다.
• 사용 방법:
 ▫ 핸들러를생성하는스레드만이다른스레드가전송하는'Message'나 'Runnable객체'를 수신하는 기능을 할 수 있다.
• 사용 예:
 ▫ 메인스레드에서생성한핸들러는메인스레드나작업스레드어디에서나참조할수 있으며, 메시지 전송 함수인 sendMessgae나 Runnable 전송 함수인 post 를 호출할 수 있다.
 ▫ 이 경우 전송되는 메시지나 Runnable은 핸들러 객체를 생성한 메인스레드에서만 수신할수있다.
*/

public class Thread2 extends AppCompatActivity {

    int mainValue = 0;
    int backValue1 = 0;
    int backValue2 = 0;
    TextView tvMainValue;
    TextView tvBackValue1, tvBackValue2, tvBackValue3, tvBackValue4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread2);

        tvMainValue = (TextView)findViewById(R.id.tvMainValue);
        tvBackValue1 = (TextView)findViewById(R.id.tvBackValue1);
        tvBackValue2 = (TextView)findViewById(R.id.tvBackValue2);
        tvBackValue3 = (TextView)findViewById(R.id.tvBackValue3);
        tvBackValue4 = (TextView)findViewById(R.id.tvBackValue4);

        // 방법1, 방법2
        BackThread1 thread1 = new BackThread1();
        thread1.setDaemon(true);
        thread1.start();

        // 방법3
        BackThread3 thread3 = new BackThread3(handler3);  // 메인스레드의 핸들러를 외부클래스에 넘겨주어 사용케 함.
        thread3.setDaemon(true);
        thread3.start();

        // 방법4
        BackThread4 thread4 = new BackThread4(handler4);
        thread4.setDaemon(true);
        thread4.start();


    } //end onCreate()

    // 버튼을 누르면 mainValue 증가
    public void mOnClick(View v){
        mainValue++;
        tvMainValue.setText("MainValue:" + mainValue);
    }

    // 방법1, 2
    class BackThread1 extends  Thread{
        @Override
        public void run() {
            while(true){

                // 방법1) 메인에서 생성된 Handler 객체에 Message 전달
                backValue1 ++;
                handler1.sendEmptyMessage(1);  // ★

                // 방법2) 메인에서 생성된 Handler 객체에 Runnable 전달
                backValue2 += 2;
                handler2.post(new Runnable() {
                    @Override
                    public void run() {
                        tvBackValue2.setText("BackValue2: " + backValue2);
                    }
                });

                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
    }

    // 방법3
    class BackThread3 extends  Thread{
        int backValue = 0;
        Handler handler;

        BackThread3(Handler handler){
            this.handler = handler;  // 메인에서 생성한 Handler 받아와야 한다
        }

        @Override
        public void run() {
            while(true){
                backValue += 3;

                Message msg = new Message();  // 메세지 생성!
                msg.what = 0;
                msg.arg1 = backValue;  // 메세지에 '값'도 담아서 보낼수 있다.
                handler.sendMessage(msg);   // 메인스레드에 값을 담은 메세지 보내기

                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }

            }
        } // end run()
    }


    // 방법4
    class BackThread4 extends  Thread{
        int backValue = 0;
        Handler handler;

        BackThread4(Handler handler){
            this.handler = handler;  // 메인에서 생성된 Handler 받아오기
        }

        @Override
        public void run() {
            while(true){
                backValue += 4;

                // 방법4
                // Message 의 obtain 메소드로 메세지 생성 가능
                // obtain(Handler h, int what, int arg1, int arg2)
                Message msg = Message.obtain(handler, 0, backValue, 0);
                handler.sendMessage(msg);   // 메인스레드에 핸들러 메세지 보냄

                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }

            } // end while
        } // end run
    } // end BackThread4




    // 방법1
    // 메인쓰레드에서 Handler 객체를 생성한다
    // Handler 객체를 생성한 쓰레드만이 다른 쓰레드가 전송하는 Message 나 Runnable 객체를 수신할수 있다.
    // 아래 생성된 Handler 객체는 handleMessage() 를 오버라이딩 하여 Message 를 수신함
    Handler handler1 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 1){   // Message id 가 1 이면
                tvBackValue1.setText("BackValue1:" + backValue1);  // 메인쓰레드의 UI 내용 변경 가능
            }
        }
    };

    // 방법2
    Handler handler2 = new Handler();  // 메인에서 생성한 핸들러

    // 방법3
    Handler handler3 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 0){
                // 메세지를 통해 받은 값을 BackValue3로 출력
                tvBackValue3.setText("BackValue3: " + msg.arg1);
            }
        }
    };

    // 방법4
    Handler handler4 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 0){
                tvBackValue4.setText("BackValue4: " + msg.arg1);
            }
        }
    };

} // end Activity