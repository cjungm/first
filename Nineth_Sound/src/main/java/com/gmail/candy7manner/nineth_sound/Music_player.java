package com.gmail.candy7manner.nineth_sound;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Music_player extends AppCompatActivity {

    MediaPlayer mp;   // 음악재생을 위한 객체
    int pos;      // 재생이 멈춘 지점 (현재 재생중인 지점)
    Button bStart, bPause, bRestart, bStop;
    boolean isPlaying = false;    // 현재 재생중인지 확인할 변수

    SeekBar sb;    // 음악 재생위치를 나타내는 SeekBar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_player);

        bStart = findViewById(R.id.btn1);
        bPause = findViewById(R.id.btn2);
        bRestart = findViewById(R.id.btn3);
        bStop = findViewById(R.id.btn4);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // MediaPlayer 객체 초기화, 생성
                mp = MediaPlayer.create(
                        getApplicationContext(),  // 현재 화면 제어권자
                        R.raw.chacha   // 음악 리소스
                );

                // 재생이 끝나면 호출되는 리스너
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {

                        mediaPlayer.seekTo(0);
                        mediaPlayer.release();

                        bStart.setVisibility(View.VISIBLE);
                        bPause.setVisibility(View.INVISIBLE);
                        bRestart.setVisibility(View.INVISIBLE);
                        bStop.setVisibility(View.INVISIBLE);

                        isPlaying = false;
                    }
                });

                // SeekBar의 최댓값을 음악재생시간에 맞춤
                sb.setMax(mp.getDuration());   // 음악의 재생시간 (miliisecond)

                mp.setLooping(false);  // false:1회,  true:무한반복
                mp.start();    // 노래 재생 시작

                isPlaying = true;   // 재생중

                new MyThread().start();   // SeekBar 움직일 쓰레드 가동.

                bStart.setVisibility(View.INVISIBLE);
                bStop.setVisibility(View.VISIBLE);
                bPause.setVisibility(View.VISIBLE);
            }
        });

        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 음악종료
                isPlaying = false;  // --> 쓰레드 에 종료

                mp.stop();   // 재생 중지
                mp.release();   // MediaPlayer 자원 해제

                bStart.setVisibility(View.VISIBLE);
                bPause.setVisibility(View.INVISIBLE);
                bRestart.setVisibility(View.INVISIBLE);
                bStop.setVisibility(View.INVISIBLE);

            }
        });

        bPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 일시중지
                pos = mp.getCurrentPosition();  // 현재 재생중인 위치값
                mp.pause();   // 일시중지

                bPause.setVisibility(View.INVISIBLE);
                bRestart.setVisibility(View.VISIBLE);

                isPlaying = false;   // --> 쓰레드 정지
            }
        });

        bRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 멈춘 지점부터 재시작
                mp.seekTo(pos);   // 일시정지 했던 지점으로 이동
                mp.start();   // 재생시작

                bRestart.setVisibility(View.INVISIBLE);
                bPause.setVisibility(View.VISIBLE);

                isPlaying = true;

                new MyThread().start();
            }
        });

        sb = findViewById(R.id.seekBar);


    } // end onCreate

    // SeekBar를 움직일 Thread 정의
    class MyThread extends Thread{
        @Override
        public void run() {
            while(isPlaying) {  // 음악이 연주중이면 SeekBar를 음악의 progress 에 따라 움직여줌.
                sb.setProgress(mp.getCurrentPosition());
            }
        }
    } // end MyThread

} // end Activity
