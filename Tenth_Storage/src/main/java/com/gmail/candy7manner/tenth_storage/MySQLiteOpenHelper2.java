package com.gmail.candy7manner.tenth_storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper2 extends SQLiteOpenHelper {

    public MySQLiteOpenHelper2(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE student" +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT, age INTEGER, address TEXT)"
                ;

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS student";
        sqLiteDatabase.execSQL(sql);  // 기존 테이블 제거
        onCreate(sqLiteDatabase);  // 다시 생성
    }
}
