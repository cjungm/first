package com.gmail.candy7manner.seventeenth_location;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
// 지오코딩(GeoCoding) : 주소,지명 => 위도(latitude),경도(longitude) 좌표로 변환하는 구글 서비스
//  위치정보를 얻기위한 권한을 획득 필요, AndroidManifest.xml
//    ACCESS_FINE_LOCATION : 현재 나의 위치를 얻기 위해서 필요함
//    INTERNET : 구글서버에 접근하기위해서 필요함

    TextView tvResult;
    EditText etLatitude;
    EditText etLongitude;
    EditText etAddress;
    Button btnGeoCoder1;
    Button btnGeoCoder2;
    Button btnMap1;
    Button btnMap2;

    Geocoder geocoder;  // 지오코딩

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvResult = (TextView) findViewById(R.id.tvResult); // 결과창
        btnGeoCoder1 = (Button) findViewById(R.id.btnGeoCoder1);
        btnGeoCoder2 = (Button) findViewById(R.id.btnGeoCoder2);
        btnMap1 = (Button) findViewById(R.id.btnMap1);
        btnMap2 = (Button) findViewById(R.id.btnMap2);

        etLatitude = (EditText) findViewById(R.id.etLatitude);
        etLongitude = (EditText) findViewById(R.id.etLongitude);
        etAddress = (EditText) findViewById(R.id.etAddress);

        geocoder = new Geocoder(this);
        btnGeoCoder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 위도, 경도 변환후 지오코딩 정보 얻어오기
                List<Address> list = null;

                double lat = Double.parseDouble(etLatitude.getText().toString());
                double lng = Double.parseDouble(etLongitude.getText().toString());
                try {
                    list = geocoder.getFromLocation(
                            lat,  // 위도
                            lng,  // 경도
                            10);   // 얻어올 결과의 최대 개수
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("myapp", "입출력 오류 - 서버에서 주소변환시 에러 발생");
                }

                if(list != null){
                    if(list.size() == 0){
                        tvResult.setText("해당되는 주소 정보 없습니다");
                    } else {
                        StringBuffer result = new StringBuffer(list.size() + "개의 결과\n");
                        for(Address addr : list){
                            result.append("-----------------------\n");
                            result.append(addr.toString() + "\n");
                        }
                        tvResult.setText(result);
                    }
                }
            }
        });

        btnMap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 위도, 경도 입력후 지도버튼 클릭 => 지도앱(화면)으로 인텐트 날리기
                double lat = Double.parseDouble(etLatitude.getText().toString());
                double lng = Double.parseDouble(etLongitude.getText().toString());

                Intent intent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("geo:" + lat + "," + lng)
                );
                startActivity(intent);
            }
        });

        btnGeoCoder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Address> list = null;
                String str = etAddress.getText().toString();
                try {
                    list = geocoder.getFromLocationName(
                            str,   // 지역,지명, 주소.. 이름
                            10);    // 읽어올 결과 최대 개수
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("myapp", "입출력 오류 - 주소변환시 에러 발생");
                }

                if(list != null){
                    if(list.size() == 0){
                        tvResult.setText("해당되는 주소 정보 없습니다");
                    } else {
                        StringBuffer result = new StringBuffer(list.size() + "개의 결과\n");
                        for(Address addr : list){
                            result.append("-----------------------\n");
                            result.append(addr.toString() + "\n");
//                            addr.getCountryName();  // 국가명
//                            addr.getLatitude();
//                            addr.getLongitude();
                        }
                        tvResult.setText(result);
                    }
                }
            }
        });

        btnMap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 주소 입력후 지도버튼 클릭시 해당 위도,경도 값의 지도앱 화면 이동
                List<Address> list = null;
                String str = etAddress.getText().toString();
                try {
                    list = geocoder.getFromLocationName(
                            str,   // 지역,지명, 주소.. 이름
                            10);    // 읽어올 결과 최대 개수
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("myapp", "입출력 오류 - 주소변환시 에러 발생");
                }

                if(list != null){
                    if(list.size() == 0){
                        tvResult.setText("해당되는 주소 정보 없습니다");
                    } else {
                        Address addr = list.get(0);
                        double lat = addr.getLatitude();
                        double lng = addr.getLongitude();

                        Intent intent = new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("geo:" + lat + "," + lng)
                        );
                        startActivity(intent);
                    }
                }
            }
        });



    } // end of onCreate
}