package com.gmail.candy7manner.tenth_storage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Use_saqlite extends AppCompatActivity {

    // SQLite3 : 안드로이드에 기본탑재된 모바일 용으로 제작된 경량화 DB
    //          C언어로 엔진이 제작되어 가볍다
    //          안드로이드에서 sqLite3 를 쉽게 사용할 수 있도록 SQLiteOpenHelper클래스제공

    // SQLite 를 사용한 데이터 저장
    //   1. SQLiteOpenHelper 를 상속받은 클래스 정의
    //      onCreate(), onUpgrade() 작성
    //   2. 위 Helper 로부터 SQLiteDatabase  DB 객체 추출
    //   3. DML 명령은 : execSQL()
    //      SELECT 명령은 : rawQuery() --> 결과는 Cursor 객체 사용하여 다룸


    MySQLiteOpenHelper1 helper;
    String dbName = "sf_file.db";   // 파일의 형태로 DB 저장됨
    int dbVersion = 1;          // 데이터베이스 버젼
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_saqlite);

        helper = new MySQLiteOpenHelper1(
                this,   // 현재 화면 제어권자
                dbName,         // DB 이름
                null,   // 커서팩토리, null 이면 표준 커서 사용
                dbVersion
        );

        try {
            db = helper.getWritableDatabase();
        } catch (SQLiteException e){
            e.printStackTrace();
            Log.d("myapp", "데이터 베이스를 얻어올수 없슴");
            finish();
        }

        insert();   // INSERT : 데이터 삽입
        select();   // SELECT : 결과 조회

    } // end onCreate()

    void insert(){
        db.execSQL("INSERT INTO mytable (name) VALUES ('Seo')");
        db.execSQL("INSERT INTO mytable (name) VALUES ('Choi')");
        db.execSQL("INSERT INTO mytable (name) VALUES ('Park')");
        db.execSQL("INSERT INTO mytable (name) VALUES ('Heo')");
        db.execSQL("INSERT INTO mytable (name) VALUES ('Kim')");
        Log.d("myapp", "INSERT 성공");
    }

    void select(){
        Cursor c = db.rawQuery("SELECT * FROM mytable", null);
        while(c.moveToNext()){  // SELECT 결과 각 row 별로 데이터 추출
            int id = c.getInt(0);   // 컬럼인덱스 0 부터!!!!!!!!!!!!!
            String name = c.getString(1);
            Log.d("myapp", "id:" + id + ", name:" + name);
        }
    }
}
