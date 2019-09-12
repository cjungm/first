package com.gmail.candy7manner.seventeenth_location;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Main4Activity extends AppCompatActivity {
/* 구글맵 v2.0 서비스 사용하기
    1. Play Service 라이브러리 추가
    2. 메니페스트에 권한, 각종 설정추가 :
    3. 구글맵 API key 발급 받아 메니페스트에 추가
    4. XML 에 MapFragment 추가  <-- 지도표시용 Fragment
      SupportMapFragment 객체로 사용
    5. GoogleMap 객체를 사용하여 지도 조작
*/

    Button btnMap;
    Button btnMarker;
    EditText etLatitude;
    EditText etLongitude;
    EditText etMarker;

    SupportMapFragment mapFragment;
    GoogleMap map;
    MarkerOptions myLocationMarker;   // 마커 (오버레이 객체)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btnMap = findViewById(R.id.btnMap);
        btnMarker = findViewById(R.id.btnMarker);
        etLatitude = findViewById(R.id.etLatitude);
        etLongitude = findViewById(R.id.etLongitude);
        etMarker = findViewById(R.id.etMarker);


        mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Log.d("myapp", "지도 준비 완료");
                map = googleMap;
            }
        });

        MapsInitializer.initialize(this);

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double lat = Double.parseDouble(etLatitude.getText().toString());
                double lng = Double.parseDouble(etLongitude.getText().toString());

                LatLng curPoint = new LatLng(lat, lng);
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(curPoint, 15));
            }
        });

        btnMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double lat = Double.parseDouble(etLatitude.getText().toString());
                double lng = Double.parseDouble(etLongitude.getText().toString());

                LatLng curPoint = new LatLng(lat, lng);

                myLocationMarker = new MarkerOptions()
                        .position(curPoint)    // 마커를 띄울 좌표
                        .title(etMarker.getText().toString().trim() + "\n")
                        .snippet("●" + String.format("%.3f %.3f", lat, lng))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.apple))   // 별도의 아이콘 추가 가능
                ;
                map.addMarker(myLocationMarker);  // 마커 추가!
            }
        });


    } // end onCreate()


    // TODO

}