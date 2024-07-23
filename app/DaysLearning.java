package com.example.atry;

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

public class DaysLearning extends AppCompatActivity {

    public static String daysBase(TextView textDays){
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        Random random = new Random();
        int randomNumber = random.nextInt(7)+1;

        textDays.setText("What is the "+ randomNumber + ". day of the week?");
        int dayIndex = randomNumber-1;
        String answer = days[dayIndex];
        return  answer;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_learning);

        TextView textDays = findViewById(R.id.textDays);
        Button showQuestion = findViewById(R.id.showQuestion);
        final Handler handler = new Handler();

        String answer = daysBase(textDays);
        showQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQuestion.setText(answer);
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
}