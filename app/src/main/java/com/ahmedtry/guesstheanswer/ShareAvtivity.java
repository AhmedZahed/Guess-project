package com.ahmedtry.guesstheanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ShareAvtivity extends AppCompatActivity {
    private String mQuestionText;
    public EditText mEditTextTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_avtivity);

        mQuestionText = getIntent().getStringExtra("quiz text extra");
        mEditTextTitle = findViewById(R.id.edit_Text_Title);

        SharedPreferences sharedPreferences = getSharedPreferences("app_pref",MODE_PRIVATE);
        String questionTitle = sharedPreferences.getString("share_title","");
        mEditTextTitle.setText(questionTitle);
    }

    public void onShareQuizonClikd(View view){
        String questionTitle = mEditTextTitle.getText().toString();
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT,questionTitle + "\n" + mQuestionText);
        shareIntent.setType("text/plain");
        startActivity(shareIntent);


        SharedPreferences sharedPreferences = getSharedPreferences("app_pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("share_title", questionTitle);
        editor.apply();

    }
}
