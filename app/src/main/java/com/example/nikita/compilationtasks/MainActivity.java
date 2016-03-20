package com.example.nikita.compilationtasks;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity{
    //это потомучто мы любим жарить дерьмо
    public static int page = 1;//собственно объяснять не буду
    //это кароче я хз как назыается,но мы попрежнему любим жарить говно!!1жькдрзхк

    //продолжаем тему "база данных для слабаков"

    //говно необходимо прожаривать со всех сторон а nullPointerExpection подвигает людей к этому

    int[] bcate = new int[]{R.string.otvet1_1, R.string.otvet1_2, R.string.otvet1_3, R.string.otvet1_4, R.string.otvet1_5, R.string.otvet2_1, R.string.otvet2_2, R.string.otvet2_3, R.string.otvet2_4, R.string.otvet2_5, R.string.otvet3_1, R.string.otvet3_2, R.string.otvet3_3, R.string.otvet3_4, R.string.otvet3_5, R.string.otvet4_1, R.string.otvet4_2, R.string.otvet4_3, R.string.otvet4_4, R.string.otvet4_5};
    int otvet = bcate[0];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup main = (ViewGroup)findViewById(R.id.scrollView);
        main.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            TextView textView5 = (TextView)findViewById(R.id.question);
            public void onSwipeRight() {
                if (page < 5){
                page++;
                show("left");}
            }
            public void onSwipeLeft() {
                if (page > 1) {
                page--;
                show("right");}
            }

        });
        // Определение нужных шрифтов
        Typeface Bebas = Typeface.createFromAsset(getAssets(), "fonts/Bebas.ttf");
        Typeface PTSans = Typeface.createFromAsset(getAssets(), "fonts/PTSansRegular.ttf");
        // Задача их для нужных элементов
        Integer[] BebasMass = new Integer[]{R.id.precategory, R.id.category, R.id.SecondButtonAns, R.id.FirstButtonAns};
        Integer[] PTSansMass = new Integer[]{R.id.question};
        for (Integer i = 0; i < BebasMass.length; i++) {
            TextView textView = (TextView) findViewById(BebasMass[i]);
            textView.setTypeface(Bebas);
        }

        for (Integer i = 0; i < PTSansMass.length; i++) {
            TextView textView = (TextView) findViewById(PTSansMass[i]);
            textView.setTypeface(PTSans);
        }
        // Изменение цвета/Или другие действия по нажатию кнопки
        //Инициализация переменных
        //кнопки
        LinearLayout firstbutton = (LinearLayout) findViewById(R.id.clickbutton);
        LinearLayout secondbutton = (LinearLayout) findViewById(R.id.clickbutton2);
        //потом убрать
        LinearLayout thirstbutton = (LinearLayout) findViewById(R.id.namequetion);
        //вот что сверху
        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        show("left");
        //слушатели
        secondbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LinearLayout secondbutton = (LinearLayout) findViewById(R.id.clickbutton2);
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    secondbutton.setBackgroundResource(R.drawable.button);
                } else {
                    secondbutton.setBackgroundResource(R.drawable.buttonpressed2);
                }
                return false;
            }

            ;
        });
        firstbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LinearLayout firstbutton = (LinearLayout) findViewById(R.id.clickbutton);
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    firstbutton.setBackgroundResource(R.drawable.button);
                } else {
                    firstbutton.setBackgroundResource(R.drawable.buttonpressed2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("А вот и ответ");
                    builder.setCancelable(false);
                    builder.setMessage(otvet);
                    builder.setNegativeButton("Ок!", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                return false;
            }
        });
    }
    private TranslateAnimation anim;
    private TranslateAnimation mainanim;

    public void show(String forward){
        if (forward == "left"){
            anim = new TranslateAnimation(-600, 1f, 1f, 1f);
        }
        else {
            anim  = new TranslateAnimation(600, 1f, 1f, 1f);
        }

        anim.setDuration(250);
        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        TextView textView5 = (TextView)findViewById(R.id.question);
        if (forward == "left"){
            mainanim  = new TranslateAnimation(1f, -600, 1f, 1f);
        }
        else {
            mainanim = new TranslateAnimation(1f, 600, 1f, 1f);
        }
        mainanim.setDuration(250);
        textView5.startAnimation(mainanim);

        switch (type){
            case(1):
                switch (page){
                    case(1):
                        textView5.setText(R.string.lvl1_coplition1);
                        textView5.startAnimation(anim);
                        otvet = bcate[0] ;
                        break;
                    case(2):
                        textView5.setText(R.string.lvl1_coplition2);
                        textView5.startAnimation(anim);
                        otvet = bcate[1];
                        break;
                    case(3):
                        textView5.setText(R.string.lvl1_coplition3);
                        textView5.startAnimation(anim);
                        otvet = bcate[2];
                        break;
                    case(4):
                        textView5.setText(R.string.lvl1_coplition4);
                        textView5.startAnimation(anim);
                        otvet = bcate[3];
                        break;
                    case(5):
                        textView5.setText(R.string.lvl1_coplition5);
                        textView5.startAnimation(anim);
                        otvet = bcate[4];
                        break;
                }
                break;
            case(2):
                switch (page){
                    case(1):
                        textView5.setText(R.string.lvl2_coplition1);
                        otvet = bcate[5];
                        break;
                    case(2):
                        textView5.setText(R.string.lvl2_coplition2);
                        otvet = bcate[6];
                        break;
                    case(3):
                        textView5.setText(R.string.lvl2_coplition3);
                        otvet = bcate[7];
                        break;
                    case(4):
                        textView5.setText(R.string.lvl2_coplition4);
                        otvet = bcate[8];
                        break;
                    case(5):
                        textView5.setText(R.string.lvl2_coplition5);
                        otvet = bcate[9];
                        break;
                }
                break;

            case(3):
                switch (page){
                    case(1):
                        textView5.setText(R.string.lvl3_coplition1);
                        otvet = bcate[10];
                        break;
                    case(2):
                        textView5.setText(R.string.lvl3_coplition2);
                        otvet = bcate[11];
                        break;
                    case(3):
                        textView5.setText(R.string.lvl3_coplition3);
                        otvet = bcate[12];
                        break;
                    case(4):
                        textView5.setText(R.string.lvl3_coplition4);
                        otvet = bcate[13];
                        break;
                    case(5):
                        textView5.setText(R.string.lvl3_coplition5);
                        otvet = bcate[14];
                        break;
                }

                break;

            case(4):
                switch (page){
                    case(1):
                        textView5.setText(R.string.lvl4_coplition1);
                        otvet = bcate[15];
                        break;
                    case(2):
                        textView5.setText(R.string.lvl4_coplition2);
                        otvet = bcate[16];
                        break;
                    case(3):
                        textView5.setText(R.string.lvl4_coplition3);
                        otvet = bcate[17];
                        break;
                    case(4):
                        textView5.setText(R.string.lvl4_coplition4);
                        otvet = bcate[18];
                        break;
                    case(5):
                        textView5.setText(R.string.lvl4_coplition5);
                        otvet = bcate[19];
                        break;
                }

                break;
        }
        //конец
    }
    private GestureDetector mGesture;
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
        final int SWIPE_MIN_DISTANCE = 120;
        final int SWIPE_MAX_OFF_PATH = 250;
        final int SWIPE_THRESHOLD_VELOCITY = 200;
        return true;
    };
};




