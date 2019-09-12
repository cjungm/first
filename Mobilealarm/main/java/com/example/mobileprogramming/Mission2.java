package com.example.mobileprogramming;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;

public class Mission2 extends AlarmHell  {
    SensorManager sm;
    SensorEventListener accL; // 자이로
    SensorEventListener oriL; // 가속도
    Sensor oriSensor;
    Sensor accSensor;
    TextView ax, ay, az; // 자이로
    TextView ox, oy, oz; // 가속도
    TextView mDistance;
    TextView mSteps;
    EditText editShakeHold;
    Button btnReset,btnEnd;
    ArrayList<Float> SensorX = new ArrayList<>();
    ArrayList<Float> SensorY = new ArrayList<>();
    ArrayList<Float> SensorZ = new ArrayList<>();

    private long lastTime = 0;
    private float speed = 0;

    private float lastX = 0;
    private float lastY = 0;
    private float lastZ = 0;

    private float x, y, z;
    private int SHAKE_THRESHOLD = 800;

    private int StepCount = 0;
    String str;
    Vibrator mVib;

    AlarmManager alarm_manager2;
    PendingIntent pendingIntent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) { // 최초 생성시
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mission2);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        oriSensor = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        accSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        oriL = new oriListener();
        accL = new accListener();
        ax = (TextView)findViewById(R.id.acc_x);
        ay = (TextView)findViewById(R.id.acc_y);
        az = (TextView)findViewById(R.id.acc_z);
        ox = (TextView)findViewById(R.id.ori_x);
        oy = (TextView)findViewById(R.id.ori_y);
        oz = (TextView)findViewById(R.id.ori_z);
        mSteps = (TextView)findViewById(R.id.mSteps);
        mDistance = (TextView)findViewById(R.id.mDistance);
        editShakeHold = (EditText)findViewById(R.id.editShakeHold);
        btnReset = (Button)findViewById(R.id.btnReset);
        mVib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        btnEnd = (Button)findViewById(R.id.btnEnd);
        // 알람매니저 설정
        alarm_manager2 = (AlarmManager) getSystemService(ALARM_SERVICE);
        // 알람리시버 intent 생성
        final Intent my_intent = new Intent(this.context, ReceiveAlarm.class);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Client 연결부
                String str;
                StepCount = 0;
                str = String.format("%d", StepCount);
                mSteps.setText(str+"걸음");
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numInt = Integer.parseInt(str);
                if(numInt>20){
                    Toast.makeText(Mission2.this,"Alarm 종료",Toast.LENGTH_SHORT).show();
                    // 알람매니저 취소
                    alarm_manager2.cancel(pendingIntent2);

                    my_intent.putExtra("state","alarm off");

                    // 알람취소
                    sendBroadcast(my_intent);
                    finish();
                }
            }
        });

    }  @Override
    public void onResume() { // 일시 중지된 상태에서 액티비티로 다시 onResume() 실행
        super.onResume();

        sm.registerListener(accL, accSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(oriL, oriSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() { // 액티비티가 일시 중지했을 때 호출
        super.onPause();

        sm.unregisterListener(oriL);
        sm.unregisterListener(accL);
    }



    private class accListener implements SensorEventListener { // 자이로 센서 값이 바뀔떄마다 호출해주는곳
        public void onSensorChanged(SensorEvent event) {
            Log.i("SENSOR", "Acceleration changed.");
            Log.i("SENSOR", "  Acceleration X: " + event.values[0]
                    + ", Acceleration Y: " + event.values[1]
                    + ", Acceleration Z: " + event.values[2]);

            try{
                SHAKE_THRESHOLD = Integer.parseInt(editShakeHold.getText().toString());
            }
            catch (Exception e)
            {
                return;
            }

            long currentTime = System.currentTimeMillis();
            long gabOfTime = (currentTime - lastTime);
            int count;
            long cal;

            String str3 = String.format("%d", currentTime) + " " + String.format("%d", lastTime);

            if(gabOfTime > 100) {
                lastTime = currentTime;
                x = event.values[0];
                y = event.values[1];
                z = event.values[2];

                speed = Math.abs(x+y+z - lastX - lastY - lastZ) / gabOfTime * 10000;
                if(speed > SHAKE_THRESHOLD){
                    StepCount++;
                    str = String.format("%d", StepCount);
                    mSteps.setText(str+"걸음");
                    int numInt = Integer.parseInt(str);
                    if(numInt>20)
                    {
                        mVib.vibrate(1000);
                    }
                }

                lastX = event.values[0];
                lastY = event.values[1];
                lastZ = event.values[2];
            }

            if(SensorX.isEmpty())
            {
                SensorX.add(event.values[0]);
                SensorY.add(event.values[0]);
                SensorZ.add(event.values[0]);
                return;
            }

            int averX = 0;
            int averY = 0;
            int averZ = 0;
            Iterator<Float> iter;

            iter = SensorX.iterator();
            count = 0;
            while (iter.hasNext())
            {
                averX += iter.next();
                count++;
            }
            averX = averX / count;

            iter = SensorY.iterator();
            count = 0;
            while (iter.hasNext())
            {
                averY += iter.next();
                count++;
            }
            averY = averY / count;

            iter = SensorZ.iterator();
            count = 0;
            while (iter.hasNext())
            {
                averZ += iter.next();
                count++;
            }
            averZ = averZ / count;


            SensorX.add(event.values[0]);
            SensorY.add(event.values[1]);
            SensorZ.add(event.values[2]);

            if(SensorX.size() > 50)
                SensorX.remove(0);
            if(SensorY.size() > 50)
                SensorY.remove(0);
            if(SensorZ.size() > 50)
                SensorZ.remove(0);

            // if(event.values[0] > 7)
            // Toast.makeText(MainActivity.this, "UP", Toast.LENGTH_SHORT).show();
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    private class oriListener implements SensorEventListener { // 가속도 센서 값이 바뀔때마다 호출해주는곳
        public void onSensorChanged(SensorEvent event) {

            Log.i("SENSOR", "Orientation changed.");
            Log.i("SENSOR", "  Orientation X: " + event.values[0]
                    + ", Orientation Y: " + event.values[1]
                    + ", Orientation Z: " + event.values[2]);
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }


}
