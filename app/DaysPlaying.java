package com.example.atry;

import static com.example.atry.DaysLearning.daysBase;

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

public class DaysPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_playing);

        TextView questionDays = findViewById(R.id.questionDays);
        EditText input = findViewById(R.id.answerDays);
        Button check = findViewById(R.id.checkDays);
        final Handler handler = new Handler();

        String answer = daysBase(questionDays);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAnswer = input.getText().toString();


                if (answer.equalsIgnoreCase(userAnswer)){
                    questionDays.setText("CORRECT!");
                }
                else
                    questionDays.setText("Wrong. Answer is: "+ answer);

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