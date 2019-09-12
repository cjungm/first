package com.gmail.candy7manner.seventh_recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class Overview extends AppCompatActivity {

    PhonebookAdapter adapter;  // Adapter 객체
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview);

        rv = findViewById(R.id.rv);

        // RecyclerView 를 사용하기 위해 LayoutManager 지정
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                this
                , RecyclerView.VERTICAL
                , false);
        //세로로 지정하는 경우
        //new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        //new GridLayoutManager(this, 2);

        rv.setLayoutManager(layoutManager);

        // Adapter 객체 생성
        adapter = new PhonebookAdapter();
        initAdapter(adapter);  // 샘플데이터
        rv.setAdapter(adapter);
    } // end onCreate()

    //한 번에 10개의 데이터를 담은 어뎁터
    void initAdapter(PhonebookAdapter adapter){
        for(int i = 0; i < 10; i++){
            int idx = Details.next();
            adapter.addItem(new Phonebook(Details.FACEID[idx], Details.NAME[idx], Details.PHONE[idx], Details.EMAIL[idx]));
        }
    }


    // 데이터 삽입 (맨 앞에)
    protected void insertData(View v){
        int idx = Details.next();
        adapter.addItem(0, new Phonebook(Details.FACEID[idx], Details.NAME[idx], Details.PHONE[idx], Details.EMAIL[idx]));
        // 데이터 변경되면?  Adapter 에게 알려주어야 한다 notify
        adapter.notifyDataSetChanged();
    }

    // 데이터 추가 (맨 뒤에)
    protected void appendData(View v){
        int idx = Details.next();
        adapter.addItem(new Phonebook(Details.FACEID[idx], Details.NAME[idx], Details.PHONE[idx], Details.EMAIL[idx]));
        adapter.notifyDataSetChanged();
    }

} // end Activity
