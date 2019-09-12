package com.gmail.candy7manner.twentyfourth_videoview;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

//1. 재생할 동영상 준비,  (직접 촬용, 혹은 다운로드).   그리고 경로 확인
//2. 내부저장장치에 대한 권한 획득 ( 메니페스트 파일 )
//3. 레이아웃에 VideoView 작성
//4. 액티비티에 VideoView 객체, MediaController 객체 생성
//5. 절대경로 획득  Environment.getExternalStorageDirectory().getAbsolutePath()
//6. android.widget.VideoView 객체에 경로 설정하고 재생!

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // VideoView : 동영상을 재생하는 뷰
            VideoView vv = (VideoView) findViewById(R.id.videoView1);

            // MediaController : 특정 View 위에서 작동하는 미디어 컨트롤러 객체
            MediaController mc = new MediaController(this);
            vv.setMediaController(mc); // Video View 에 사용할 컨트롤러 지정

            String path = Environment.getExternalStorageDirectory()
                    .getAbsolutePath(); // 기본적인 절대경로 얻어오기


            // 절대 경로 = SDCard 폴더 = "stroage/emulated/0"
            //          ** 이 경로는 폰마다 다를수 있습니다.**
            // 외부메모리의 파일에 접근하기 위한 권한이 필요 AndroidManifest.xml에 등록
            Log.d("test", "절대 경로 : " + path);

            vv.setVideoPath(path+"/video/kakaotalk_1458998519582.3gp");
            // VideoView 로 재생할 영상
            // 아까 동영상 [상세정보] 에서 확인한 경로
            vv.requestFocus(); // 포커스 얻어오기
            vv.start(); // 동영상 재생
        } // end of onCreate
    } // end of class

