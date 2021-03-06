package com.ahmedtry.guesstheanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AunserActivity extends AppCompatActivity {

    private TextView mTextViewAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aunser);
        mTextViewAnswer = findViewById(R.id.text_view_aunser);
        String answer = getIntent().getStringExtra("the");
        if(answer != null) {
            mTextViewAnswer.setText(answer);
        }
        }
    }
