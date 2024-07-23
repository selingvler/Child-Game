package com.example.test3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import java.util.Random;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SeasonsDeneme extends AppCompatActivity {
    private boolean isTurkish = false;
    private int randomNumber;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasons_deneme);

        Integer[] images = {
                R.drawable.fall,
                R.drawable.spring,
                R.drawable.winter,
                R.drawable.summer,
        };

        String[] correctAnswers = {
                "Fall",
                "Spring",
                "Winter",
                "Summer",
        };

        String[] dogruCevaplar = {
                "Sonbahar",
                "İlkbahar",
                "Kış",
                "Yaz",
        };

        ImageView imageView = findViewById(R.id.imageView);
        Button button3 = findViewById(R.id.button3);
        Button languageButton = findViewById(R.id.languageButton); // Assuming you have a button for language change
        TextView textView = findViewById(R.id.textView);
        EditText userAnswer = findViewById(R.id.userAnswer);
        final Handler handler = new Handler();

        randomNumber = random.nextInt(4);
        imageView.setImageResource(images[randomNumber]);

        languageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTurkish = !isTurkish;
                updateQuestionAndAnswer(textView);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userText = userAnswer.getText().toString();
                String correctAnswer = isTurkish ? dogruCevaplar[randomNumber] : correctAnswers[randomNumber];

                if (userText.equalsIgnoreCase(correctAnswer)) {
                    textView.setText(isTurkish ? "İyi iş!" : "Good job!");
                } else {
                    textView.setText((isTurkish ? "Yanlış! Cevap " : "Wrong! Answer is ") + correctAnswer);
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

        updateQuestionAndAnswer(textView);
    }

    private void updateQuestionAndAnswer(TextView textView) {
        // This method can be expanded to update other UI elements if needed
        // Currently, it does not update any text related to the question itself because the image represents the question
        textView.setText(""); // Clear the textView for the new question
    }
}
