package com.example.test3;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MonthsPlaying extends AppCompatActivity {
    private String correctAnswer;
    private boolean isTurkish = false;
    private int monthIndex;
    private String[] months;
    private String[] aylar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months_playing);

        TextView questionMonths = findViewById(R.id.questionMonths);
        EditText input = findViewById(R.id.answerMonths);
        Button check = findViewById(R.id.checkMonths);
        final Handler handler = new Handler();

        LanguageManager languageManager = new LanguageManager(this);
        Button tr = findViewById(R.id.language);


        months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        aylar = new String[]{"Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};

        if (savedInstanceState != null) {
            isTurkish = savedInstanceState.getBoolean("isTurkish");
            monthIndex = savedInstanceState.getInt("monthIndex");
            updateQuestionAndAnswer();
        } else {
            Random random = new Random();
            monthIndex = random.nextInt(12);
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
                    questionMonths.setText(R.string.correctMonths);
                } else {
                    questionMonths.setText(getString(R.string.wrongMonths) + correctAnswer);
                }

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        startActivity(getIntent());
                    }
                }, 1000);
            }
        });
    }

    private void updateQuestionAndAnswer() {
        TextView questionMonths = findViewById(R.id.questionMonths);
        if (isTurkish) {
            questionMonths.setText(String.format(getString(R.string.month_question), monthIndex + 1));
            correctAnswer = aylar[monthIndex];
        } else {
            questionMonths.setText(String.format(getString(R.string.month_question), monthIndex + 1));
            correctAnswer = months[monthIndex];
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isTurkish", isTurkish);
        outState.putInt("monthIndex", monthIndex);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isTurkish = savedInstanceState.getBoolean("isTurkish");
        monthIndex = savedInstanceState.getInt("monthIndex");
        updateQuestionAndAnswer();
    }
}
