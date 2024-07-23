package com.example.atry;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class DigitsBackwardLearning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits_backward_learning);

        TextView digitsBox = findViewById(R.id.digits_box2);
        Button generate = findViewById(R.id.generateDigit2);
        ArrayList<Integer> answer = new ArrayList<>();
        TextView answerBox = findViewById(R.id.answerBox2);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomNumber = random.nextInt(10);
                answer.add(randomNumber);
                digitsBox.setText(Integer.toString(randomNumber));

                StringBuilder outputString = new StringBuilder();
                outputString.append("Answer: ");

                ListIterator<Integer> iterator = answer.listIterator(answer.size());

                while (iterator.hasPrevious()) {
                    Integer i = iterator.previous();
                    outputString.append(i).append(" ");
                }

                answerBox.setText(outputString.toString());

            }
        });

    }
}