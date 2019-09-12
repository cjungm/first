package com.gmail.candy7manner.fourteenth_dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    final int DIALOG_TEXT = 1;
    final int DIALOG_LIST = 2;    // 리스트 형식
    final int DIALOG_RADIO = 3;    // 하나만 선택가능
    final int DIALOG_MULTICHOICE = 4;  // 여러개 선택가능

    TextView tvResult;

    int choice;      // singleChoiceItems 에서 선택

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // AlertDialog : Dialog 를 상속받은 클래스
        //        다이얼로그를 쉽게 만들수 있도록 지원
        tvResult = findViewById(R.id.tvResult);

        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert(DIALOG_TEXT);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert(DIALOG_LIST);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert(DIALOG_RADIO);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert(DIALOG_MULTICHOICE);
            }
        });
    }  // end onCreate()

    protected AlertDialog.Builder showAlert(int id){
        AlertDialog.Builder builder = null;

        switch (id){
            case DIALOG_TEXT:
                builder = //new AlertDialog.Builder(this);
                        new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_DARK);
                builder.setTitle("다이얼로그 제목임")
                        .setMessage("안녕하신지요?")
                        .setPositiveButton("긍정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "긍정", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("부정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "부정", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNeutralButton("중립", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "중립", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();

                break;
            case DIALOG_LIST:
                builder = new AlertDialog.Builder(this);
                final String [] str = {"사과", "배", "수박", "딸기"};
                builder.setTitle("리스트 형식 다이얼로그")
                        .setNegativeButton("취소", null)
                        .setItems(str, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),
                                        "선택된 것은: " + str[i],
                                        Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
                break;
            case DIALOG_RADIO:
                // 사용자 정의 style 적용한 AlertDialog
                builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));

                final String str2[] = {"빨강", "파랑", "녹색"};
                builder.setTitle("색을 고르세요")
                        .setSingleChoiceItems(
                                str2,    // 리스트 배열 목록
                                -1,  // 기본 설정값
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        // i : 몇번째 선택되었는지
                                        choice = i;
                                    }
                                }
                        )
                        .setPositiveButton("선택완료", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), str2[choice] + " 를 선택",
                                        Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
                break;
            case DIALOG_MULTICHOICE:
                builder = new AlertDialog.Builder(this);

                final String [] data = {"한국", "북한", "미국", "러시아"};
                final boolean [] checked = {true, false, true, false};

                builder.setTitle("MultiChoice 다이얼로그")
                        .setMultiChoiceItems(
                                data,  // 체크박스 리스트 항목
                                checked,  // 초깃값(선택여부) 배열
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                        checked[i] = b;
                                        //checked = new boolean[3];  // checked 는 final 이라 불가!
                                    }
                                }
                        )
                        .setPositiveButton("선택완료", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String str = "선택한 값은: ";
                                for(int j = 0; j < checked.length; j++){
                                    if(checked[j]){
                                        str = str + data[j] + ", ";
                                    }
                                }
                                tvResult.setText(str);  // 선택결과값 출력
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();

                break;
        } // end switch

        return builder;

    } // end showAlert()
}