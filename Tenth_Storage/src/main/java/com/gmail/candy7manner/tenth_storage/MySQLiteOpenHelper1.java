package com.gmail.candy7manner.tenth_storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// SQLiteOpenHelper : 안드로이드세어 SQLite 데이터베이스를 쉽게 사용할 수 있도록 하는 클래스
public class MySQLiteOpenHelper1 extends SQLiteOpenHelper {

    public MySQLiteOpenHelper1(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.d("myapp", "SQLiteOpenHelper 생성");
    }

    // 최초에 데이터베이스가 없을 경우, 데이터베이스 생성을 위해 호출됨
    // DDL 등 테이블 생성하는 코드 작성
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("myapp", "SQLiteOpenHelper onCreate() 호출");

        String sql = "CREATE TABLE mytable (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT" +
                ")"
                ;
        sqLiteDatabase.execSQL(sql);   // 쿼리문 실행
    }

    // 데이터 베이스의 '버젼' 이 바뀌었을때 호출되는 메소드
    // 버젼이 바뀌었을때 기존 DB를 어떻게 변경할 것인지 작성
    // 각 버젼의 변경 내용들을 버전 마다 작성해야 함.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.d("myapp", "SQLiteOpenHelper onUpgrade() 호출");

        String sql = "DROP TABLE mytable";  // 기존의 테이블 제거
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}