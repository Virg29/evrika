package com.example.nikita.compilationtasks;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Определение нужных шрифтов
        Typeface Typeface1 = Typeface.createFromAsset(getAssets(), "fonts/Bebas.ttf");
        Typeface Typeface2 = Typeface.createFromAsset(getAssets(), "fonts/PTSansRegular.ttf");
        // Задача их для нужных элементов
        TextView textView = (TextView)findViewById(R.id.FirstButtonAns);
        textView.setTypeface(Typeface1);
        TextView textView2 = (TextView)findViewById(R.id.SecondButtonAns);
        textView2.setTypeface(Typeface1);
        TextView textView3 = (TextView)findViewById(R.id.category);
        textView3.setTypeface(Typeface1);
        TextView textView4 = (TextView)findViewById(R.id.precategory);
        textView4.setTypeface(Typeface1);
        TextView textView5 = (TextView)findViewById(R.id.question);
        textView5.setTypeface(Typeface2);
        // Изменение цвета/Или другие действия по нажатию кнопки

        //Инициализация переменных
        //кнопки
        LinearLayout firstbutton = (LinearLayout)findViewById(R.id.clickbutton);
        LinearLayout secondbutton = (LinearLayout)findViewById(R.id.clickbutton2);
        //это кароче я хз как назыается
        Intent intent = getIntent();
        int type = intent.getIntExtra("type",0);
        int page = 1;


        if (type == 1){
        //запуск некой функции которая будет распозновать жест и создавать новый лейаут уже с другим текстом посмотришь его в strings.xml там все разбито и потои разберемся
            textView5.setText(R.string.lvl1_coplition1);


        }
        else if (type == 2) {
            textView5.setText(R.string.lvl2_coplition1);





        }
        else if (type == 3) {
            textView5.setText(R.string.lvl3_coplition1);






        }
        else if (type == 4){
            textView5.setText(R.string.lvl4_coplition1);




        }

        //слушатели
        secondbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LinearLayout secondbutton = (LinearLayout)findViewById(R.id.clickbutton2);
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    secondbutton.setBackgroundResource(R.drawable.button);
                }
                else  {
                    secondbutton.setBackgroundResource(R.drawable.buttonpressed2);
                }
                return false;
            };
        });

        firstbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LinearLayout firstbutton = (LinearLayout) findViewById(R.id.clickbutton);
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    firstbutton.setBackgroundResource(R.drawable.buttonpressed);
                } else {
                    firstbutton.setBackgroundResource(R.drawable.answer);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Подсказка!");
                    builder.setCancelable(false);
                    builder.setMessage(R.string.lvl1_coplition1);
                    builder.setNegativeButton("чта,как блядь?!", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                return false;
            }

            ;
        });
        };






    }


