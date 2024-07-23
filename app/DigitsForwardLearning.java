package com.example.atry;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class DigitsForwardLearning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.digits_forward_learning);

        TextView digitsBox = findViewById(R.id.digits_box);
        Button generate = findViewById(R.id.generateDigit);
        ArrayList<Integer> answer = new ArrayList<>();
        TextView answerBox = findViewById(R.id.answerBox);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomNumber = random.nextInt(10);
                answer.add(randomNumber);
                digitsBox.setText(Integer.toString(randomNumber));

                StringBuilder outputString = new StringBuilder();
                outputString.append("Answer: ");
                for (int i : answer) {
                    outputString.append(i).append(" ");
                }
                answerBox.setText(outputString.toString());

            }
        });

    }

}