package com.gmail.candy7manner.seventeenth_location;

import android.Manifest;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

      /* 현재 위치 정보 가져오기 : GPS (Global Positioning System)
   1. AndroidManifest.xml 위치정보 권한획득 (ACCESS_FINE_LOCATION) 선언  (API23 이전 버젼은 이걸로 충분)
      1-2 API23+ 에서는 (마시멜로): 새로운 권한 획득 방법 사용.
            Run-time 에 onRequestPermissionsResult() 사용 해야 한다!!!
            https://developer.android.com/training/permissions/requesting.html
   2. LocationManager 획득
   3. LocationProvider 지정
       이전에 사용한 Provider 있는지 여부
       없으면 새로 지정
       ※ GPS 는 에뮬레이터에서는 기본적으로 동작하지 않는다
       ※ 실내에서는 GPS_PROVIDER 를 요청해도 응답이 없거나 느리다. 특별한 처리를 안하면 아무리 시간이 지나도 응답이 없으면
           해결방법은
            ① 타이머를 설정하여 GPS_PROVIDER 에서
                일정시간 응답이 없는 경우 NETWORK_PROVIDER로 전환
           ② 혹은, 둘다 한꺼번헤 호출하여 들어오는 값을 사용하는 방식.
        ※ 폰에 GPS 를 꺼놔도, LocationManager 가 최초 위치 정보 확인할때 GPS 켜지면서 초기화됨.
   4. LocationListener 생성 : onLocationChanged() 에서 위치정보 (Location) 확인
   안드로이드 좌표계:  경도(longitude), 위도(latitude) 사용
       대한민국은 위도 36~38도,   경도 126~128도 사이 위치
       ex) 서울시청 : 37.566767, 126.978370       <-- 구글맵 등에서 위치 좌표 제공
    */

    TextView tvResult;
    ToggleButton btnLocate;

    // 권한획득용
    String [] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};
    final int myRequestCode = 101;

    LocationManager manager = null;  // 위치관리자
    MyListener mLocationListener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  // 세로 모드로 고정 (테스트를 위해)

        tvResult = findViewById(R.id.tvResult);
        btnLocate = findViewById(R.id.btnLocate);

        // 권한 획득 하기
        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(String.valueOf(permissions)) == PackageManager.PERMISSION_DENIED){
                requestPermissions(permissions, myRequestCode);  // 사용자에게 권한 요청
            }
        }
        // LocationManager 객체
        manager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        // LocationListener 객체
        mLocationListener = new MyListener();

        btnLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnLocate.isChecked()){  // 위치정보 수신 시작

                    try{
                        // 주어진 위치제공자가 기억하는 가장 최근의 위치정보 획득. 없으면 null 리턴
                        Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if(location != null){
                            tvResult.setText("최근위치\n" + locationInfo(location));
                        }

                        // 위치 요청
                        manager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,   // 등록할 위치 제공자
                                100,    // 통지 사이의 최소 시간 간격 (ms)
                                1,   // 통지 사이의 최소 변경 거리 (m)
                                mLocationListener);   // LocationListener 등록

                        manager.requestLocationUpdates(
                                LocationManager.NETWORK_PROVIDER,   // 등록할 위치 제공자
                                100,    // 통지 사이의 최소 시간 간격 (ms)
                                1,   // 통지 사이의 최소 변경 거리 (m)
                                mLocationListener);   // LocationListener 등록

                        Toast.makeText(getApplicationContext(), "내위치 확인요청", Toast.LENGTH_SHORT).show();

                    } catch (SecurityException e){
                        e.printStackTrace();
                    }


                    //manager.requestLocationUpdates(.., mLocationListener, ..);

                } else {  // 위치정보 수신 해제
                    manager.removeUpdates(mLocationListener);
                }
            }
        });


    } // end onCreate()

    // LocationListener 구현
    // : LocationManager 에서 전달되는 위치정보를 받기 위해 정의
    class MyListener implements LocationListener {

        // 위치가 변경(확인)되었을때 호출됨
        // 위치정보는 Location 객체로 받음
        @Override
        public void onLocationChanged(Location location) {
            Log.d("myapp", "onLocationChanged : " + location);
            tvResult.setText("내위치\n" + locationInfo(location));
            Toast.makeText(getApplicationContext(), "위치정보갱신!", Toast.LENGTH_SHORT).show();
            Log.d("myapp", locationInfo(location));
        }


        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {
            Log.d("myapp", "onStatusChanged : " + s);
        }

        @Override
        public void onProviderEnabled(String s) { // 위치제공자 가용하게 되었을때
            Log.d("myapp", "onProviderEnabled : " + s);
        }

        @Override
        public void onProviderDisabled(String s) { // 위치제공자 가용 못하게 될때
            Log.d("myapp", "onProviderDisabled : " + s);
        }
    }

    // Location 정보 추출
    protected String locationInfo(Location location){
        double longitude = location.getLongitude();  // 경도
        double latitude = location.getLatitude();  // 위도
        double altitude = location.getAltitude();   // 고도
        String provider = location.getProvider();  // 위치제공자
        float accuracy = location.getAccuracy();   // 정확도.

        return "위치정보 : " + provider + "\n위도 : " + longitude + "\n경도 : " + latitude
                + "\n고도 : " + altitude + "\n정확도 : " + accuracy;
    }


    // TODO  권한 획득
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch(requestCode){
            case myRequestCode:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "위치권한 획득!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "위치권한 획득실패!", Toast.LENGTH_LONG).show();
                    // 권한이 없으면 더이상 진행못하는 액티비티인 경우는 바로 종료시켜야 함.
                    // finish();
                }
                return;
        }
    }
} // end Activity

/*
   실제 기기로 창가쪽에서 테스트 해보면, 처음에는 network로 잡히다가 나중에 gps 로 전환된다. (약간 시간 걸린다)
   전환이 되는 것은. accuracy 가 결정적인 역할을 한다.
   GPS 의 accuracy 가  NETWORK 보다 높다.
*/