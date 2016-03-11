package com.example.nikita.compilationtasks;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    }
  //  LinearLayout myView = (LinearLayout)findViewById(R.id.clickbutton);
   // public void clickbutton(View v) {
   //     myView.setBackgroundResource(R.drawable.buttonpressed);
    //}
}
