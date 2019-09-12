package com.gmail.candy7manner.sixth_widget2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class Seekbar_move extends AppCompatActivity {

    TextView tv;
    SeekBar sb;

//    SeekBar 사용하기
//    setOnSeekBarChangeListener:   SeekBar가 눌렸을 때 호출
//    onProgressChanged:            진행도중에 호출
//    onStartTrackingTouch:         Bar를 수동으로 움직이면 호출
//    onStopTrackingTouch:          Bar의 움직임이 멈추면 호출

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar_move);

        tv = findViewById(R.id.textView3);
        sb = findViewById(R.id.seekBar);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText("onProgessChanged:" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tv.setText("onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv.setText("onStopTrackingTouch");
            }
        });

    } // end onCreate
}