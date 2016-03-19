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

    //это потомучто мы любим жарить дерьмо
    int page = 1;//собственно объяснять не буду
    //это кароче я хз как назыается,но мы попрежнему любим жарить говно!!1жькдрзхк

    //продолжаем тему "база данных для слабаков"

   //говно необходимо прожаривать со всех сторон а nullPointerExpection подвигает людей к этому

    int[] bcate = new int[]{R.string.otvet1_1,R.string.otvet1_2,R.string.otvet1_3,R.string.otvet1_4,R.string.otvet1_5,R.string.otvet2_1,R.string.otvet2_2,R.string.otvet2_3,R.string.otvet2_4,R.string.otvet2_5,R.string.otvet3_1,R.string.otvet3_2,R.string.otvet3_3,R.string.otvet3_4,R.string.otvet3_5,R.string.otvet4_1,R.string.otvet4_2,R.string.otvet4_3,R.string.otvet4_4,R.string.otvet4_5};
    int otvet = bcate[0];



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Определение нужных шрифтов
        Typeface Bebas = Typeface.createFromAsset(getAssets(), "fonts/Bebas.ttf");
        Typeface PTSans= Typeface.createFromAsset(getAssets(), "fonts/PTSansRegular.ttf");
        // Задача их для нужных элементов
        Integer[] BebasMass = new Integer[]{R.id.precategory, R.id.category, R.id.SecondButtonAns, R.id.FirstButtonAns};
        Integer[] PTSansMass = new Integer[]{R.id.question};
        for (Integer i = 0; i<BebasMass.length; i++){
            TextView textView = (TextView)findViewById(BebasMass[i]);
            textView.setTypeface(Bebas);
        }

        for (Integer i = 0; i<PTSansMass.length; i++){
            TextView textView = (TextView)findViewById(PTSansMass[i]);
            textView.setTypeface(PTSans);
        }
        // Изменение цвета/Или другие действия по нажатию кнопки
        //Инициализация переменных
        //кнопки
        LinearLayout firstbutton = (LinearLayout)findViewById(R.id.clickbutton);
        LinearLayout secondbutton = (LinearLayout)findViewById(R.id.clickbutton2);
        //потом убрать
        LinearLayout thirstbutton = (LinearLayout)findViewById(R.id.namequetion);
        //вот что сверху
        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        show();
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
                    if (page < 5){
                        page++;                                                                                             //ЭТО ДЛЯ ДЕМОНСТРАЦИИ
                    }
                    show();
                }
                return false;
            };
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

            ;
        });
        thirstbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LinearLayout secondbutton = (LinearLayout)findViewById(R.id.namequetion);
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    secondbutton.setBackgroundResource(R.drawable.button);
                }
                else if(event.getAction() == MotionEvent.ACTION_DOWN)  {
                    secondbutton.setBackgroundResource(R.drawable.buttonpressed2);
                    if (page > 1){
                        page--;                                                                                             //ЭТО ДЛЯ ДЕМОНСТРАЦИИ
                    }
                    show();
                }
                return false;
            };
        });
    };
    public void show(){

        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        TextView textView5 = (TextView)findViewById(R.id.question);
        switch (type){
            case(1):
                switch (page){
                    case(1):
                        textView5.setText(R.string.lvl1_coplition1);
                        otvet = bcate[0] ;
                        break;
                    case(2):
                        textView5.setText(R.string.lvl1_coplition2);
                        otvet = bcate[1];
                        break;
                    case(3):
                        textView5.setText(R.string.lvl1_coplition3);
                        otvet = bcate[2];
                        break;
                    case(4):
                        textView5.setText(R.string.lvl1_coplition4);
                        otvet = bcate[3];
                        break;
                    case(5):
                        textView5.setText(R.string.lvl1_coplition5);
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
                        otvet = bcate[15];
                        break;
                }

                break;

            case(4):
                switch (page){
                    case(1):
                        textView5.setText(R.string.lvl4_coplition1);
                        otvet = bcate[16];
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
}


