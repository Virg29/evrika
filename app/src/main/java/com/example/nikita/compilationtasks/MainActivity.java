package com.example.nikita.compilationtasks;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.editText1);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Bebas.ttf");
        textView.setTypeface(typeFace);
        TextView textView2 = (TextView)findViewById(R.id.editText2);
        textView2.setTypeface(typeFace);
        TextView textView3 = (TextView)findViewById(R.id.textView);
        textView3.setTypeface(typeFace);
        TextView textView4 = (TextView)findViewById(R.id.textView2);
        textView4.setTypeface(typeFace);
    }
}
