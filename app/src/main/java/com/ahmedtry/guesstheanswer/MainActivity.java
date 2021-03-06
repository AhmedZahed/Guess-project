package com.ahmedtry.guesstheanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewQuestion;

    private static final String[] QUESTIONS = {
            "العملة الرسمية لدولة الكويت هي الريال الكويتي؟",
            "توبقال هي أعلى قمة جبلية في العالم العربي؟",
            "الجزائر هي أكبر دولة عربية من حيث المساحة؟",
            "الدار البيضاء هي عاصمة المغرب؟",
            "كابول هى عاصمة افغانستان؟",
            "اضخم الحيوانات اللافقرية هو القنديل؟",
            "الدولة العربية التي يمر بها خط الاستواء هى السودان؟",
            "القلب هو أكبر عضو في جسم الإنسان؟",
            "أول مسجد في الإسلام هو المسجد النبوي؟",
            "الخال الوحيد لأولاد عمتك هو والدك؟",
            "اولى دول العالم انتاجا للموز هى الاكوادور؟",
            "الأرجنتين عاصمتها باكو؟",
            "عملة فيتنام هى دونج؟"
    };

    private static final boolean[] ANSWERS = {
            false,
            true,
            true,
            false,
            true,
            false,
            false,
            false,
            false,
            true,
            true,
            false,
            true
    };

    public static final String[] ANSWERS_DETAILS = {
            "العملة الرسمية لدولة الكويت هي الدينار الكويتي",
            "توبقال هي أعلى قمة جبلية في العالم العربي و تقع في المغرب",
            "الجزائر هي أكبر دولة عربية و إفريقية من حيث المساحة",
            "الرباط هي عاصمة المغرب",
            "كابول هى عاصمة افغانستان",
            "اضخم الحيوانات اللافقرية هو الحبار",
            "الدولة العربية التي يمر بها خط الاستواء هى الصومال",
            "الكبد هو أكبر عضو في جسم الإنسان",
            "أول مسجد في الإسلام هو مسجد قباء",
            "الخال الوحيد لأولاد عمتك هو والدك",
            "اولى دول العالم انتاجا للموز هى الاكوادور",
            "الأرجنتين عاصمتها بونس إيرس",
            "عملة فيتنام هى دونج"
    };

    public String mCurrentQuiz, mCurrentAnswerDetail;
    private boolean mCurrentAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewQuestion = findViewById(R.id.text_view_quiz);
        showNewQuestion();


    }

    public void showNewQuestion() {
        Random random = new Random();
        int randomQuestionIndex = random.nextInt(QUESTIONS.length);
        mCurrentQuiz = QUESTIONS[randomQuestionIndex];
        mCurrentAnswer = ANSWERS[randomQuestionIndex];
        mCurrentAnswerDetail = ANSWERS_DETAILS[randomQuestionIndex];
        mTextViewQuestion.setText(mCurrentQuiz);
    }

    public void onChangeQuizClicked(View view) {
        showNewQuestion();
    }

    public void onFalseClicked(View view) {
        if (mCurrentAnswer == false) {
            Toast.makeText(this, "صح عليك ", Toast.LENGTH_SHORT).show();
            showNewQuestion();
        } else {
            Toast.makeText(this, "حاول مره تانية ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, AunserActivity.class);
            intent.putExtra("the", mCurrentAnswerDetail);
            startActivity(intent);

        }
    }

    public void onTrueClicked(View view) {
        if (mCurrentAnswer == true) {
            Toast.makeText(this, "صح عليك ", Toast.LENGTH_SHORT).show();
            showNewQuestion();
        } else {
            Toast.makeText(this, "حاول مره تانية ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, AunserActivity.class);
            intent.putExtra("the", mCurrentAnswerDetail);
            startActivity(intent);
        }
    }
    public void onShareQuizonClikd(View view){
        Intent intent = new Intent(this,ShareAvtivity.class);
        intent.putExtra("quiz text extra",mCurrentQuiz);
        startActivity(intent);
    }

}