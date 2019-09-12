package com.gmail.candy7manner.thirteenth_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildActivity1 extends AppCompatActivity {

    Button btnChild2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child1);

        btnChild2 = findViewById(R.id.btnChild2);

        btnChild2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChildActivity2.class);
                startActivity(intent);
            }
        });


    }
}