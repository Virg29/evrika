package com.example.nikita.compilationtasks;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
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
        LinearLayout firstbutton = (LinearLayout)findViewById(R.id.clickbutton);
        LinearLayout secondbutton = (LinearLayout)findViewById(R.id.clickbutton2);
        // Примечание: я разобрался как сделать то же самое на иксмл, сократив кол-во букв до 10 штук,
        // но пожалуй оставлю это тут, ведь код выглядит круто
        secondbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LinearLayout secondbutton = (LinearLayout)findViewById(R.id.clickbutton2);
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    secondbutton.setBackgroundResource(R.drawable.button);
                }
                else {
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
                }
                return false;
            }

            ;
        });
        };
    }


