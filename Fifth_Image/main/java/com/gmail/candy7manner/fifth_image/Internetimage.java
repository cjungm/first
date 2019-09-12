package com.gmail.candy7manner.fifth_image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Internetimage extends AppCompatActivity {

    // 외부 쓰레드에서 메인 UI화면을 접근할때 사용
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internetimage);

        // 인터넷 상의 이미지 보여주기
        // 1. 권한을 획득한다 : 메니페스트 파일
        // 2. Thread 에서 웹의 이미지를 받아온다
        // 3. 외부 Thread 에서 메인 UI 에 접근하려면 Handler 를 사용해야 한다.

        // Thread t = new Thread(Runnable 객체..)
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {  // 오래 걸릴 작업들 / 동시 진행해야 하는 작업들. 쓰레드로 구현한다.

                try {
                    final ImageView iv = findViewById(R.id.imageView5);
                    //받아올 이미지 URL
                    URL url = new URL("https://post-phinf.pstatic.net/MjAxOTAzMjRfMjcz/MDAxNTUzMzkyNTQzMTkw.GWB0EUeTZ9fPX_OugeSwTStOUmNUq0zcracKr4hGR7kg.8zoty2s6foMP7jtTxLzIx5uWMfGSikM9WLAUQEOGYw0g.JPEG/3-1.jpg?type=w1200");

                    InputStream is = url.openStream();
                    //비트맵으로 받아오기
                    final Bitmap bm = BitmapFactory.decodeStream(is);

                    // 외부 쓰레드 에서, 메인 화면에 그려줄 작업.
                    // 메인 UI 에 접근할때는 반.드.시 Handler 객체 사용

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(bm);
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();  // 쓰레드 시작

    } // end onCreate
} // end Activity