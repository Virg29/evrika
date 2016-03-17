package com.example.nikita.compilationtasks;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.MotionEvent;
import android.widget.Toast;


public class First_activity extends Activity {

    boolean select = false;
    int type;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        Typeface Bebas = Typeface.createFromAsset(getAssets(), "fonts/Bebas.ttf");
        int[] cate = new int[]{R.id.cate0, R.id.cate1, R.id.cate2, R.id.cate3, R.id.cate4, R.id.submit};
        Integer varlenght = cate.length;
        for (Integer i = 0; i < varlenght; i++) {
            TextView textView = (TextView) findViewById(cate[i]);
            textView.setTypeface(Bebas);
        }

        //Объявление кнопок
        LinearLayout buttonlvl1 = (LinearLayout) findViewById(R.id.lvl1);
        LinearLayout buttonlvl2 = (LinearLayout) findViewById(R.id.lvl2);
        LinearLayout buttonlvl3 = (LinearLayout) findViewById(R.id.lvl3);
        LinearLayout buttonlvl4 = (LinearLayout) findViewById(R.id.lvl4);
        LinearLayout submitbutton = (LinearLayout) findViewById(R.id.submitbutton);


        //слушатель прикосновения для "легко"

        buttonlvl1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    color(1);
                }
                return false;
            }
        });

        //слушатель прикосновения для "средне"

        buttonlvl2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    color(2);
                }
                return false;
            }
        });

        //слушатель прикосновения для "выше средне"

        buttonlvl3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    color(3);
                }
                return false;
            }
        });

        //слушатель прикосновения для "сложнааааааааааа"

        buttonlvl4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    color(4);
                }
                return false;
            }
        });

        //слушатель для "подтвердить"

        submitbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (select == true){
                    Intent intent = new Intent(First_activity.this,MainActivity.class);
                    intent.putExtra("type", type);
                    startActivity(intent);
                }
                else{
                    Toast toast2 = Toast.makeText(First_activity.this, "Выберите категорию", Toast.LENGTH_SHORT);
                    toast2.show();
                }
                return false;

            }
        });

    }
    public void color(Integer per){
        //Объявление кнопок
        select = true;
        LinearLayout buttonlvl1 = (LinearLayout) findViewById(R.id.lvl1);
        LinearLayout buttonlvl2 = (LinearLayout) findViewById(R.id.lvl2);
        LinearLayout buttonlvl3 = (LinearLayout) findViewById(R.id.lvl3);
        LinearLayout buttonlvl4 = (LinearLayout) findViewById(R.id.lvl4);

        buttonlvl1.setBackgroundResource(R.drawable.category_set);
        buttonlvl2.setBackgroundResource(R.drawable.category_set);
        buttonlvl3.setBackgroundResource(R.drawable.category_set);
        buttonlvl4.setBackgroundResource(R.drawable.category_set);
        switch (per){
            case(1):
                buttonlvl1.setBackgroundResource(R.drawable.buttonpressed);
                type = 1;
                break;
            case(2):
                buttonlvl2.setBackgroundResource(R.drawable.buttonpressed);
                type = 2;
                break;
            case(3):
                buttonlvl3.setBackgroundResource(R.drawable.buttonpressed);
                type = 3;
                break;
            case(4):
                buttonlvl4.setBackgroundResource(R.drawable.buttonpressed);
                type = 4;
                break;
        }

    }

}