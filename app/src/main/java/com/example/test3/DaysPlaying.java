package com.example.test3;



import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class DaysPlaying extends AppCompatActivity {
    private String correctAnswer;
    private boolean isTurkish = false;
    private int dayIndex;
    private String[] days;
    private String[] gunler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_playing);

        TextView questionDays = findViewById(R.id.questionDays);
        EditText input = findViewById(R.id.answerDays);
        Button check = findViewById(R.id.checkDays);
        final Handler handler = new Handler();

        LanguageManager languageManager = new LanguageManager(this);
        Button tr = findViewById(R.id.languageDays);


        days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        gunler = new String[]{"Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar"};


        if (savedInstanceState != null) {
            isTurkish = savedInstanceState.getBoolean("isTurkish");
            dayIndex = savedInstanceState.getInt("dayIndex");
            updateQuestionAndAnswer();
        } else {

            Random random = new Random();
            dayIndex = random.nextInt(7);
            updateQuestionAndAnswer();
        }


        tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTurkish = true;
                languageManager.updateResource("tr");
                updateQuestionAndAnswer();
            }
        });


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAnswer = input.getText().toString();
                if (correctAnswer.equalsIgnoreCase(userAnswer)) {
                    questionDays.setText(getString(R.string.correctMonths));
                } else {
                    questionDays.setText(getString(R.string.wrongMonths) + correctAnswer);
                }

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        startActivity(getIntent());
                    }
                }, 2000);
            }
        });
    }

    private void updateQuestionAndAnswer() {
        TextView questionDays = findViewById(R.id.questionDays);
        if (isTurkish) {
            correctAnswer = gunler[dayIndex];
            questionDays.setText(String.format(getString(R.string.days_question), dayIndex + 1));
        } else {
            correctAnswer = days[dayIndex];
            questionDays.setText(String.format(getString(R.string.days_question), dayIndex + 1));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isTurkish", isTurkish);
        outState.putInt("dayIndex", dayIndex);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isTurkish = savedInstanceState.getBoolean("isTurkish");
        dayIndex = savedInstanceState.getInt("dayIndex");
        updateQuestionAndAnswer();
    }
}