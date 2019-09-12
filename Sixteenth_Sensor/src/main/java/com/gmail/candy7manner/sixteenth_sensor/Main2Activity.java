package com.gmail.candy7manner.sixteenth_sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements SensorEventListener {

    TextView tv;
    SensorManager sm;
    Sensor s;

    // 방위각 체크에 아래 두개 센서 필요
    Sensor accelerometer;
    Sensor magentometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = (TextView)findViewById(R.id.textView1);

        // SensorManager 객체 얻기
        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magentometer = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    }

    @Override
    protected void onResume() {  // 화면 보이기 직전에 센서 자원 획득.
        super.onResume();
        // 센서 값이 변경되었을때 콜백 받기위한 리스너 등록
        sm.registerListener((SensorEventListener) this,
                accelerometer,   // 콜백 원하는 센서
                SensorManager.SENSOR_DELAY_UI);  // 지연시간, 2ms

        sm.registerListener((SensorEventListener) this,
                magentometer,   // 콜백 원하는 센서
                SensorManager.SENSOR_DELAY_UI);  // 지연시간, 2ms
    }

    @Override
    protected void onPause() {  // 화면을 빠져나가기 시작하면 즉시 센서자원 반납
        super.onPause();
        sm.unregisterListener((SensorEventListener) this);
    }

    float [] mGravity;
    float [] mGeomagnetic;
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        // 센서값이 변경되었을때 호출되는 메소드
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            mGravity = sensorEvent.values;
        }
        if(sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            mGeomagnetic = sensorEvent.values;
        }

        if(mGravity != null && mGeomagnetic != null ){

            float R[] = new float[9];
            float I[] = new float[9];

            // 방향센서값 계산
            boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);

            if(success){
                float orientation[] = new float[3];
                SensorManager.getOrientation(R, orientation);

                float azimuth = orientation[0];  // z축 회전 방향
                float pitch = orientation[1];   // x 축 회전 방향
                float roll = orientation[2];    // y 축 회전

                String str = "방향센서 값\n\n"
                        + "\n방위각: " + azimuth
                        + "\n피치:" + pitch
                        + "\n롤:" + roll;

                tv.setText(str);
                Log.d("myapp", str);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // 센서의 정확도가 변경되었을때 호출되는 메소드
    }
}
