package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private Button gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView
                (R.layout.activity_main);

        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.tv_result);
        gen = findViewById(R.id.button);

        textView1.setText(generate());
        textView2.setText(regenerate((String) textView1.getText()));

        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText(generate());
                textView2.setText(regenerate((String) textView1.getText()));
            }
        });

    }

    String generate(){
        return  "Всё, что нам нужно – это " + P.PhraserGen();
    }

    String regenerate(String inputP){
        int minusIndex = inputP.indexOf("–");
        String rightPart = inputP.substring(minusIndex + 7);
        String firstChar = inputP.substring(minusIndex+6, minusIndex+7);
        firstChar = firstChar.toUpperCase();
        String leftPart = inputP.substring(0, minusIndex - 1);
        leftPart = leftPart.toLowerCase();
        return firstChar + rightPart + " - это " + leftPart + ".";
    }
}