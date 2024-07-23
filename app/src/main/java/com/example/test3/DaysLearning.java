package com.example.test3;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class DaysLearning extends AppCompatActivity {
    private String correctAnswer;
    private boolean isTurkish = false;
    private int dayIndex;
    private String[] days;
    private String[] gunler;
    private int randomNumber;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_learning);

        TextView textDays = findViewById(R.id.textDays);
        Button showQuestion = findViewById(R.id.showQuestion);
        Button trButton = findViewById(R.id.languageDays);
        final Handler handler = new Handler();

        // Gün dizilerini tanımla
        days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        gunler = new String[]{"Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar"};

        // Rastgele bir gün seç
        randomNumber = random.nextInt(7) + 1;
        dayIndex = randomNumber - 1;

        // Soruyu ve doğru cevabı güncelle
        updateQuestionAndAnswer(textDays);

        // Dil değiştirme butonuna tıklandığında
        trButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTurkish = !isTurkish;
                updateQuestionAndAnswer(textDays);
            }
        });

        // Cevap gösterme butonuna tıklandığında
        showQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQuestion.setText(correctAnswer);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        startActivity(getIntent());
                    }
                }, 500);
            }
        });
    }

    // Soruyu ve doğru cevabı güncelleyerek ekranı yenilemeden değişiklikleri uygular
    private void updateQuestionAndAnswer(TextView textDays) {
        if (isTurkish) {
            correctAnswer = gunler[dayIndex];
            textDays.setText(String.format(getString(R.string.what_is_the_dth_day_of_the_week), randomNumber));
        } else {
            correctAnswer = days[dayIndex];
            textDays.setText(String.format(getString(R.string.what_is_the_dth_day_of_the_week), randomNumber));
        }
    }
}
