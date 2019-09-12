package com.gmail.candy7manner.seventeenth_location;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위치기반 어플리케이션 : 사용자의 위치를 활용한 어플리케이션
        // 폰에서 위치정보를 얻는 방법
        // 1. GPS - 위성에서 정보를 받아 삼각측량으로 위치를 계산,
        //           정확하다, 건물 안에서는 안된다
        // 2. 3G망 - 인접된 전화기지국에서오는 전파의 시간 차이로 위치를 계산,
        //          실내에서도 가능
        // 3. WiFi 의 AP

        // ■ 위치정보를 사용하려면, 권한 설정을 해야함 AndroidManifest.xml
        //           android.permission.ACCESS_FINE_LOCATION

        tvResult = (TextView)findViewById(R.id.tvResult);

        // '위치관리자' 객체 얻어오기
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // '위치제공자' 모~두 가져오기
        List<String> list = lm.getAllProviders();

        String str = "[위치제공자] : 사용여부\n-----------------------------\n";
        for(int i = 0; i < list.size(); i++){
            str += "[" + list.get(i) + "] : " + lm.isProviderEnabled(list.get(i)) + "\n";
        }
        tvResult.setText(str);


    } // end of onCreate


}