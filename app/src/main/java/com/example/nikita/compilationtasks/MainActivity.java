package com.example.nikita.compilationtasks;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Определение нужных шрифтов
        Typeface Bebas = Typeface.createFromAsset(getAssets(), "fonts/Bebas.ttf");
        Typeface PTSans = Typeface.createFromAsset(getAssets(), "fonts/PTSansRegular.ttf");
        // Задача их для элементов
        Integer[] BebasMass = new Integer[]{R.id.precategory, R.id.category, R.id.SecondButtonAns, R.id.FirstButtonAns, R.id.submitans, R.id.cancelans};
        Integer[] PTSansMass = new Integer[]{R.id.tiponquest, R.id.question, R.id.answeronquest};
        for (Integer i = 0; i < BebasMass.length; i++) {
            TextView textView = (TextView) findViewById(BebasMass[i]);
            textView.setTypeface(Bebas);
        }

        for (Integer i = 0; i < PTSansMass.length; i++) {
            TextView textView = (TextView) findViewById(PTSansMass[i]);
            textView.setTypeface(PTSans);
        }
        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        show("left");
        setQandA("right");

    };
    public String string2;
    private TranslateAnimation mainanim;
    public static int page = 1;//Переменная, которая отвечаеь за активный текст(если page==1: То будет выбран соответствующий текст из словаря strings)
    public String variable; // Потом убери


    public void show(String forward){

        ViewGroup main = (ViewGroup)findViewById(R.id.scrollView);
        main.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            TextView textView5 = (TextView) findViewById(R.id.question);

            public void onSwipeRight() {
                if (page < 5) {
                    page++;
                    show("left");
                    setQandA("left");
                }
            }

            public void onSwipeLeft() {
                if (page > 1) {
                    page--;
                    show("right");
                    setQandA("right");
                }
            }

        });

    }


    public void setQandA(String forward){
        Intent intent = getIntent();
        int type = intent.getIntExtra("type", 0);
        string2 = getString(R.string.jsonslovar);
        String tip;                                    //там потом с переменными пошаманить прийдеться куда их пехать
        String question = null;                               //а так это зарезервированные переменные которые ниже заполняются
        String params = string2;      //присваиваем словарь
        JSONArray jsonArray = null;                     //инициализация массива
        tip = null;
        String answer = null;
        try{ //без трайа не работает
            JSONObject jsonP = new JSONObject(params);//парсинг
            switch (type){
                case 1:
                    jsonArray = jsonP.optJSONArray("lvl1");//тут происходит разбиение на уровн
                    break;
                case 2:
                    jsonArray = jsonP.optJSONArray("lvl2");
                    break;
                case 3:
                    jsonArray = jsonP.optJSONArray("lvl3");
                    break;
                case 4:
                    jsonArray = jsonP.optJSONArray("lvl4");
                    break;
            }
            JSONObject jsonObject = jsonArray.getJSONObject(page - 1);//разбиваем массив на объекты
            tip = jsonObject.optString("tip").toString();//вот присвоение
            question = jsonObject.optString("question").toString();//и это
            answer = jsonObject.optString("answer").toString();

        }catch (org.json.JSONException error){
            error.printStackTrace();
        }
        TextView mainquestion = (TextView)findViewById(R.id.question);
        mainquestion.setText(question);
        TextView mainanswer = (TextView)findViewById(R.id.answeronquest);
        mainanswer.setText(answer);
        TextView maintip = (TextView)findViewById(R.id.tiponquest);
        maintip.setText(tip);
        if (forward == "left"){
            mainanim  = new TranslateAnimation(-600, 1f, 1f, 1f);
        }
        else {
            mainanim = new TranslateAnimation(600, 1f, 1f, 1f);
        }

        mainanim.setDuration(250);
        mainquestion.startAnimation(mainanim);
    }




    public void ListenerAnswer1(View v) {
        RelativeLayout b = (RelativeLayout)findViewById(R.id.tiplayout);
        b.setVisibility(View.VISIBLE);
    };
    public void closetip(View v){
        RelativeLayout b = (RelativeLayout)findViewById(R.id.tiplayout);
        b.setVisibility(View.INVISIBLE);
    }
    public void ListenerAnswer2 (View v){
        RelativeLayout b = (RelativeLayout)findViewById(R.id.answerlayout);
        b.setVisibility(View.VISIBLE);
    }
    public void close (View v){
        RelativeLayout b = (RelativeLayout)findViewById(R.id.answerlayout);
        b.setVisibility(View.INVISIBLE);
    }
};