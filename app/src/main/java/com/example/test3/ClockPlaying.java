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

public class ClockPlaying extends AppCompatActivity {

    private ClockView clockView;
    private String correctAnswer;
    boolean isTurkish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_playing);

        clockView = findViewById(R.id.clock_view);
        EditText userAnswer = findViewById(R.id.clockAnswer);
        Button check = findViewById(R.id.clockCheck);
        Button changeLanguage = findViewById(R.id.switch_language);
        final Handler handler = new Handler();

        int[] info = clockView.getRandomTime();

        int hour = info[0];
        int minute = info[1];

        // Başlangıçta İngilizce doğru cevap
        correctAnswer = getCorrectAnswerInEnglish(hour, minute);

        // Dil değiştirme butonuna tıklanırsa, doğru cevabı Türkçe olarak güncelle
        changeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTurkish = true;
                correctAnswer = getCorrectAnswerInTurkish(hour, minute);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = userAnswer.getText().toString();
                if (answer.equalsIgnoreCase(correctAnswer)) {
                    userAnswer.setText(isTurkish ? "İyi iş!" : "Good job!");
                } else {
                    userAnswer.setText(correctAnswer);
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        startActivity(getIntent());
                    }
                }, 2500);
            }
        });
    }

    private String getCorrectAnswerInEnglish(int hour, int minute) {
        if (minute == 0) {
            return hour + " o'clock";
        } else if (minute < 30) {
            return minute + " past " + hour;
        } else if (minute == 30) {
            return "half past " + hour;
        } else {
            int min = 60 - minute;
            int hr = (hour + 1) % 24; // 24 saati geçmesin
            return min + " to " + hr;
        }
    }

    private String getCorrectAnswerInTurkish(int hour, int minute) {
        if (minute == 0) {
            return hour + " ";
        } else if (minute < 30) {
            return hour  +" i "+ minute + "geçiyor";
        } else if (minute == 30) {
            return hour + " buçuk";
        } else {
            int min = 60 - minute;
            int hr = (hour + 1) % 24; // 24 saati geçmesin
            return hr + " a " + min + " kala";
        }
    }
}
