package com.gmail.candy7manner.twentythird_camera;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.IOException;
/*  카메라 화면 보여주기 --> SurfaceView 사용
                                   1.프리뷰설정
                                    --->
   SurfaceView <-->  SurfaceHolder <---   카메라   2.프리뷰 시작
              3. 프리뷰표시        3. 프리뷰 디스플레이
   SuffaceView 는 SurfaceHolder 에 의해 제어되는 모습
               - setPreviewDisplay() 로 미리보기 설정해주어야 함
   초기화 작업후 카메라객체의 startPreview() 호출 --> 카메라 영상이 SurfaceView 로 보이게 된다
   주의!: Surface 타입은 반드시 SURFACE_TYPE_PUSH_BUFFERS)
   SurfaceView 가  SURFACE_TYPE_PUSH_BUFFERS 타입인 경우, 카메라 보여주기 외에 다른 그림 못 그림
   그 위에 다른 그림 (아이콤, 마커, 증강현실..) 그리려면 별도의 레이아웃을 위에 포개야 한다
*/

public class Main2Activity extends AppCompatActivity {

    String [] permissions = {Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    final int myRequestCode = 101;

    CameraSurfaceView cameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 권한 획득
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(String.valueOf(permissions)) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permissions, myRequestCode);  // 권한 요청하기
            }
        }

        FrameLayout previewFrame = findViewById(R.id.previewFrame);
        cameraView = new CameraSurfaceView(this);
        previewFrame.addView(cameraView);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });

    } // end onCreate()

    public void takePicture(){
        cameraView.capture(new Camera.PictureCallback() {
            // 사진 찍은후 호출되는 메소드 : jpeg 변환후
            // 캡쳐한 이미지 데이터가 전달된다 --> bytes
            @Override
            public void onPictureTaken(byte[] bytes, Camera camera) {
                // 전달받은 바이트배열을 Bitmap 객체로 만들기
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

                // 앨범에 저장하기 , MediaStore.Images.Media 사용
                String outUriStr = MediaStore.Images.Media.insertImage(
                        getContentResolver(),
                        bitmap,  // 만들어진 비트맵
                        "Captured Image",   // 비트맵 제목
                        "Captured Image using camera"  // 비트맵 내용
                );

                if(outUriStr == null){
                    Log.d("myapp", "Image 앨범 저장 실패");
                    return;
                }

                Uri outUri = Uri.parse(outUriStr);
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, outUri));

                camera.startPreview();  // 프리뷰 재개
            }
        });
    }

    // SurfaceView 상속 + SurfaceHolder.Callback 구현
    class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

        private SurfaceHolder mHolder;
        private Camera camera = null;  //  android.hardware.Camera

        // 생성자에서는 SurfaceHolder 객체 참조후 설정
        public CameraSurfaceView(Context context) {
            super(context);

            mHolder = getHolder();
            mHolder.addCallback(this);
        }

        // SurfaceView 가 만들어질때 카메라 객체를 참조한 후 미리보기 화면으로 Holder객체 생성
        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            camera = Camera.open();

            // camera 의 orientation 설정
            setCameraOrientation();

            try {
                camera.setPreviewDisplay(mHolder);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        // SurfaceView 의 화면 크기가 변경되는 등의 상황에서 호출
        // --> '변경시점' 에서 미리보기가 시작
        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
            camera.startPreview();
        }

        // SurfaceView 가 없어질때
        // --> '미리보기' 중지
        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            // 카메라 반납
            camera.stopPreview();
            camera.release();
            camera = null;
        }

        public void setCameraOrientation(){
            if(camera == null) return;

            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(0, info);

            WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            int rotation = manager.getDefaultDisplay().getRotation();   // 화면 회전값

            int degree = 0;
            switch (rotation){
                case Surface.ROTATION_0: degree = 0; break;
                case Surface.ROTATION_90: degree = 90; break;
                case Surface.ROTATION_180: degree = 180; break;
                case Surface.ROTATION_270: degree = 270; break;
            }

            int result;
            if(info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT){  // 현재 카메라가 사용자 쪽인지
                result = (info.orientation + degree) % 360;
                result = (360 - result) % 360;
            } else {  // 아니면 바깥 쪽인지
                result = (info.orientation - degree + 360) % 360;
            }

            camera.setDisplayOrientation(result);
        }

        // 사진촬영
        public boolean capture(Camera.PictureCallback handler){
            if(camera == null) return false;

            camera.takePicture(null, null, handler);
            return true;
        }


    } // end CameraSurfaceView

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case myRequestCode:
                if(grantResults.length <= 0){
                    Toast.makeText(this, "Permisison Denied", Toast.LENGTH_SHORT).show();
                    return;
                }

                String result = "";
                for(int i = 0; i < grantResults.length; i++){
                    if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                        result += "Permission Granted:" + permissions[i] + "\n";
                    } else {
                        result += "Permission Denied:" + permissions[i] + "\n";
                    }
                }
                Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                Log.d("myapp", result);
                break;
        }

    }
}