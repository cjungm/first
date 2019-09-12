package com.gmail.candy7manner.eleventh_handler;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AsyncThread extends AppCompatActivity {

    int mainValue = 0, backValue1 = 0, backValue2 = 0;
    TextView tvMainValue, tvBackValue1, tvBackValue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asyncthread);

        tvMainValue = findViewById(R.id.tvMainValue);
        tvBackValue1 = findViewById(R.id.tvBackValue1);
        tvBackValue2 = findViewById(R.id.tvBackValue2);

        Log.d("myapp", "PRE");

        BackGroundTask bgTask = new BackGroundTask();
        bgTask.execute();    // AsyncTask : 새롭게 스레드 만들어서 백그라운드 비동기 작업 시작!
        Log.d("myapp", "POST");


    } // end onCreate


    // AsyncTask<Params, Progress, Result>
    //    Params : doInBackground 에서 사용할 변수 타입
    //    Progress : onProgressUpdate 에서 사용할 변수 타입
    //    Result : onPostExecute 에서 사용할 변수 타입
    class BackGroundTask extends AsyncTask<Integer, Integer, Integer> {

        // 백그라운드 작업 시작직전에 호출
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("myapp", "onPreExecute");
        }

        // 백그라운드 수행중 동작하는 코드
        // 반.드.시 override 해주어야 함
        @Override
        protected Integer doInBackground(Integer... integers) {
            for(backValue1 = 0; backValue1 < 100; backValue1++){
                if(backValue1 % 10 == 0){
                    publishProgress(backValue1);   // progress 상태를 update --> onProgressUpdate 호출됨
                    // 매개변수값 전달됨.
                }

                try{Thread.sleep(100);} catch(InterruptedException e){e.printStackTrace();}

            }
            // return 백그라운드 작업이 끝남
            return backValue1;  // onPostExecute 에 넘어간다
        }

        // publishProgress(i) 가 prgress 정보를 onProgressUpdate 에 보낸다.
        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.d("myapp", "onProgressUpdate: " + values[0] + "%");
            super.onProgressUpdate(values);
            tvBackValue1.setText("onProgressUpdate: " + values[0] + "%");
        }

        @Override
        protected void onPostExecute(Integer integer) {  // doInBackGround 에서 return 한 값을 매개변수로 받는다
            super.onPostExecute(integer);
            Log.d("myapp", "onPostExecute 결과값: " + integer);

            tvBackValue1.setText("onPostExecute 결과값: " + integer);
        }

    }
} // end Activity

