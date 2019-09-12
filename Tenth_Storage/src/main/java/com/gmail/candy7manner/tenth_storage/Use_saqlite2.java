package com.gmail.candy7manner.tenth_storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Use_saqlite2 extends AppCompatActivity {

    EditText etName, etAge, etAddress;
    Button btnInsert, btnUpdate, btnDelete, btnSelect;
    TextView tvResult;   // 결과창

    String dbName = "sf_file2.db";
    int dbVersion = 1;     // 데이터베이스 버젼
    MySQLiteOpenHelper2 helper;
    SQLiteDatabase db;
    String tableName = "student";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_saqlite2);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etAddress = findViewById(R.id.etAddress);
        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnSelect = findViewById(R.id.btnSelect);
        tvResult = findViewById(R.id.tvResult);

        helper = new MySQLiteOpenHelper2(
                this,  // 현재화면 제어권자
                dbName,  // 데이터베이스 이름
                null,  // 커서팩토리,  null 이면 표준커서 사용
                dbVersion    // 데이터베이스 버젼
        );
        try{
            db = helper.getWritableDatabase();
        } catch (SQLiteException e){
            e.printStackTrace();
            Log.e("myapp", "데이터 베이스를 열수 없습니다");
            finish();  // <--? 액티비티 종료
        }

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString().trim();
                String age = etAge.getText().toString().trim();
                String address = etAddress.getText().toString().trim();

                if("".equals(name) || "".equals(age) || "".equals(address)){
                    tvResult.setText("INSERT 실패 - 항목을 입력하세요");
                    return;  // 그냥 종료
                }
                int a;
                try{
                    a = Integer.parseInt(age);
                } catch (NumberFormatException e){
                    tvResult.setText("INSERT 실패 - age 는 숫자로 입력하세요");
                    return;  // 그냥 종료
                }

                insert(name, a, address);
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                select();
            }
        });
    } // end onCreate

    void select() {
        Cursor c = db.query(tableName, null, null, null, null, null, null);

        // db.query("테이블명", columns, "owner = ?", new String[] {"Mike"} , null, null, null);
        //                              --> WHERE owner = 'Mike'
        // db.query("테이블명", columns, "owner = ? AND price = ?", new String[] {"Mike", "100"} , null, null, null);
        //                              --> WHERE owner = 'Mike' AND price = 100

        while(c.moveToNext()){
            int id = c.getInt(0);
            String name = c.getString(1);
            int age = c.getInt(2);
            String address = c.getString(3);

            String msg = "_id:" + id + ", name:" + name + ", age:" + age + ", address:" + address;
            Log.d("myapp", msg);
            tvResult.append("\n" + msg);
        }

        // 키자판 내리기
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

    }

    void insert(String name, int age, String address){
        ContentValues values = new ContentValues();
        // 키, 값의 쌍으로 데이터 입력
        values.put("name", name);
        values.put("age", age);
        values.put("address", address);

        // auto increment 된 PK 값
        long result = db.insert(tableName, null, values); // INSERT 쿼리 실행
        //  INSERT INTO 테이블;  <-- 그러나 SQLite 는 허용 안함.
        // ContnetValue 에 값이 없는 경우 ... 안됨...
        //    결국 하나라도 값을 채워줘야 정상적으로 수행됨.
        //    그래서 두번째 매개변수 nullColumnHack 값으로 채워짐.
        Log.d("myapp", result + "row INSERT 성공");
        tvResult.setText(result + "row INSERT 성공");
    }
} // end Activity