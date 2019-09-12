package com.gmail.candy7manner.fourteenth_dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dialog dlg1;
    ImageView ivDlgBanner;
    Button btnDlgEvent;

    // 두번째 다이얼로그
    Dialog dlg2;
    TextView tvResult;

//    Dialog Listener
//    setOnCancelListener
//    setOnDismissListener
//    setOnShowListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dlg1 = new Dialog(this);   // 다이얼로그 객체 생성
        dlg1.setContentView(R.layout.dialog_layout1); // 다이얼로그 화면(레이아웃) 등록

        // Dialog 의 뷰객체 얻어오기
        ivDlgBanner = dlg1.findViewById(R.id.ivDlgBanner);
        btnDlgEvent = dlg1.findViewById(R.id.btnDlgEvent);
        btnDlgEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivDlgBanner.setImageResource(R.drawable.korea);
                Toast.makeText(getApplicationContext(),
                        "다이얼로그 버튼 클릭", Toast.LENGTH_LONG).show();
            }
        });

        // Activity에 Dialog 등록
        dlg1.setOwnerActivity(this);
        dlg1.setCanceledOnTouchOutside(false);
        // 다이얼로그 바깥 영역 클릭시 (혹은 back버튼 클릭시) cancel 되는 여부


        // # 두번째 Dialog
        tvResult = findViewById(R.id.tvResult);
        dlg2 = new Dialog(this);
        dlg2.setContentView(R.layout.dialog_layout2);
        dlg2.setOwnerActivity(this);
        dlg2.setCanceledOnTouchOutside(false);   // 바깥을 클릭해도 닫히지 않게

        final EditText etName = dlg2.findViewById(R.id.etName);
        Button bOk = dlg2.findViewById(R.id.btnOk);
        Button bCancel = dlg2.findViewById(R.id.btnCancel);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = etName.getText().toString();
                tvResult.setText(str);
                dlg2.dismiss();   // Dialog 닫기!
            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg2.dismiss();
            }
        });

        // Dialog 에 걸수 있는 리스너들
        dlg1.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {

            }
        });

        dlg1.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });

        dlg1.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {

            }
        });
    } // end onCreate()

    public void showDialog1(View v){
        dlg1.show();  // 다이얼로그 띄우기
    }

    public void showDialog2(View v){
        dlg2.show();
    }

}
