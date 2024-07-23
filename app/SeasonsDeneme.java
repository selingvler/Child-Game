package com.example.atry;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seasons_deneme);

        Integer[] images={
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



        ImageView imageView = findViewById(R.id.imageView);
        Button button3= findViewById(R.id.button3);
        TextView textView = findViewById(R.id.textView);
        Random r = new Random();
        EditText userAnswer = findViewById(R.id.userAnswer);
        final Handler handler = new Handler();


        int randomNumber = r.nextInt(4);
        imageView.setImageResource(images[randomNumber]);


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                String userText = userAnswer.getText().toString();
                String correctAnswer = correctAnswers[randomNumber];

                if (userText.equalsIgnoreCase(correctAnswer)) {
                    // User input is correct
                    textView.setText("Good job!"); // Display "Good job!"

                } else {
                    // User input is wrong
                    textView.setText("Wrong! Answer is " + correctAnswer); // Display "Wrong answer!" and correct answer
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
}