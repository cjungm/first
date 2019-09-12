package com.gmail.candy7manner.seventh_recycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PhonebookContents extends AppCompatActivity {

    ImageView ivPhoto;
    TextView tvName, tvPhone, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phonebook_contents);

        ivPhoto = findViewById(R.id.ivPhoto);
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);

        Intent intent = getIntent();
        Phonebook pb = (Phonebook)intent.getSerializableExtra("pb");
        ivPhoto.setImageResource(pb.getPhoto());
        tvName.setText(pb.getName());
        tvEmail.setText(pb.getEmail());
        tvPhone.setText(pb.getPhone());

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();  // 리스트로 돌아가기
            }
        });

    }
}