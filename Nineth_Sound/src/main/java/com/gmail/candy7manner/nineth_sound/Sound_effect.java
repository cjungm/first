package com.gmail.candy7manner.nineth_sound;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sound_effect extends AppCompatActivity {

    // SoundPool : 짧은 '음향효과' 재생

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_effect);

        Button b = findViewById(R.id.btnPlay);

        // 최대음악파일개수,    스트림타입,     음질-기본값0
        final SoundPool sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        // 각각의 재생하고자 하는 음악들을 SoundPool 에 로딩한다
        // 로딩 후에는 SoundPool 에서 관리하는 고유 sound id 리턴값(int)
        final int soundId = sp.load(this, R.raw.gun, 1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(
                        soundId,   // 준비한 sound
                        1,  // 왼쪽 볼륨   0.0 ~ 1.0  float
                        1, // 오른쪽 볼륨
                        0,    // 우선순위 int
                        0, // 반복횟수 int :   -1:무한반복,   0:반복안함
                        0.5f     // 재생속도 float :  0.5(절반속도),   2.0 (2배속)
                );
            }
        });


    }
}
