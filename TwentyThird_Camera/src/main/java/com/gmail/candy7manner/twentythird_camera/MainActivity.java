package com.gmail.candy7manner.twentythird_camera;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

/*  오늘날 스마트폰의 카메라 용도
   단순 사진 촬영을 넘어, 바코드, 문자 인식, AR (증각현실)등 광범위하게 사용
   카메라로 사진찍는 방법 2가지
   방법 1. Intent 로 단말기의 앱 실행한후 촬영결과 받아와서 처리하기
   방법 2. 앱 화면에 직접 카메라 미리 보기 실행후 직접 사진 촬영하여 처리하기
   -------------------------------------------------------------------------
   방법 1. Intent 로 단말기의 앱 실행한후 촬영결과 받아와서 처리하기
   메니페스트 설정 :
       CAMERA, WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE
       uses-feature 세팅
   저장 경로 설정하기 : external-path 리소스 사용
   ContentProvider 세팅 : FILE_PROVIDER_PATHS 설정
   권한 획득하기 (API23+)
   인텐트 생성 MediaStore.ACTION_IMAGE_CAPTURE
   인텐트에 저장 경로 세팅 : MediaStore.EXTRA_OUTPUT
   -------------------------------------------------------------------------
   참고]
      안드로이드 7.0 부터는 file:// 로 시작하는 Uri 정보를 다른 앱에서는 접근 불가
       반드시 content:// 로 시작하는 내용제공자 를 사용하도록 바뀌었슴!
*/


public class MainActivity extends AppCompatActivity {


    String [] permissions = {Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    final int myRequestCode = 101;

    ImageView imageView;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 권한 획득
        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(String.valueOf(permissions)) == PackageManager.PERMISSION_DENIED){
                requestPermissions(permissions, myRequestCode);  // 권한 요청하기
            }
        }

        imageView = findViewById(R.id.imageView);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture(); // 사진 촬영
            }
        });


    } // end onCreate

    public void takePicture(){
        if(file == null){
            file = createFile();
        }

        Uri fileUri = FileProvider.getUriForFile(this, "com.lec.android", file);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);   // 사진 저장될 uri
        if(intent.resolveActivity(getPackageManager()) != null){  // 사진앱(액티비티) 존재 여부 체크 후.
            startActivityForResult(intent, 101);
        }

    }

    protected File createFile(){
        String filename = "capture.jpg";
        File storageDir = Environment.getExternalStorageDirectory();
        File outFile = new File(storageDir, filename);

        return outFile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101 && resultCode == RESULT_OK){
            // 촬영한 사진 파일 읽어서 --> Bitmap --> ImageView
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;    // resample size
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            imageView.setImageBitmap(bitmap);
        }

    }


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