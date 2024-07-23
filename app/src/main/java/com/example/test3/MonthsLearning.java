package com.example.test3;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MonthsLearning extends AppCompatActivity {
    private String correctAnswer;
    private boolean isTurkish = false;
    private int monthIndex;
    private String[] months;
    private String[] aylar;
    private int randomNumber;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_months_learning);

        TextView textMonths = findViewById(R.id.textMonths);
        Button showQuestion = findViewById(R.id.showQuestion);
        Button trButton = findViewById(R.id.languageMonths);
        final Handler handler = new Handler();

        // Ay dizilerini tanımla
        months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        aylar = new String[]{"Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};

        // Rastgele bir ay seç
        randomNumber = random.nextInt(12) + 1;
        monthIndex = randomNumber - 1;

        // Soruyu ve doğru cevabı güncelle
        updateQuestionAndAnswer(textMonths);

        // Dil değiştirme butonuna tıklandığında
        trButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTurkish = !isTurkish;
                updateQuestionAndAnswer(textMonths);
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
    private void updateQuestionAndAnswer(TextView textMonths) {
        if (isTurkish) {
            correctAnswer = aylar[monthIndex];
            textMonths.setText("Yılın " + randomNumber + ". ayı nedir?");
        } else {
            correctAnswer = months[monthIndex];
            textMonths.setText("What is the " + randomNumber + "th month of the year?");
        }
    }
}

