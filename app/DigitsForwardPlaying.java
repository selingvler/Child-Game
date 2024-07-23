package com.example.atry;

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

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class DigitsForwardPlaying extends AppCompatActivity {

    public void checkResult(ArrayList<Integer> answer, String[] answerArr,EditText input,TextView feedback){
        String userAnswerString = input.getText().toString();
        String[] userAnswerArr = userAnswerString.split(" ");

        boolean isCorrect = true;

        if (userAnswerArr.length != answerArr.length)
            feedback.setText("Wrong. Try again.");
        else {
            for (int i = 0; i < answer.size(); i++) {
                if (Integer.parseInt(userAnswerArr[i]) != Integer.parseInt(answerArr[i]))
                    isCorrect = false;
            }
            if (isCorrect)
                feedback.setText("CORRECT!");
            else
                feedback.setText("Wrong. Try again.");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits_forward_playing);

        TextView digitsBox = findViewById(R.id.digits_box2);
        Button generate = findViewById(R.id.generateDigit2);
        ArrayList<Integer> answer = new ArrayList<>();
        EditText input = findViewById(R.id.enterForward);
        Button check = findViewById(R.id.checkForward);
        TextView feedback = findViewById(R.id.feedbackForward);


        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomNumber = random.nextInt(10);
                answer.add(randomNumber);
                digitsBox.setText(Integer.toString(randomNumber));
            }
        });




        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userAnswerString = input.getText().toString();
                String[] userAnswerArr = userAnswerString.split(" ");

                String[] answerArr = new String[answer.size()];
                for (int i = 0; i < answer.size(); i++)
                    answerArr[i] = answer.get(i).toString();


                boolean isCorrect = true;

                if (userAnswerArr.length != answerArr.length)
                    feedback.setText("Wrong. Try again.");
                else {
                    for (int i = 0; i < answer.size(); i++) {
                        if (Integer.parseInt(userAnswerArr[i]) != Integer.parseInt(answerArr[i]))
                            isCorrect = false;
                    }
                    if (isCorrect)
                        feedback.setText("CORRECT!");
                    else
                        feedback.setText("Wrong. Try again.");
                }

            }
        });
    }
}