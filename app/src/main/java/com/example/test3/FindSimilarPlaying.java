package com.example.test3;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class FindSimilarPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_similar_playing);

        ImageView questionImage = findViewById(R.id.questionImage);
        ImageView firstImage = findViewById(R.id.firstImage);
        ImageView secondImage = findViewById(R.id.secondImage);
        TextView text = findViewById(R.id.checkFindSimilar);
        final Handler handler = new Handler();

        questionImage.setVisibility(View.INVISIBLE);
        firstImage.setVisibility(View.INVISIBLE);
        secondImage.setVisibility(View.INVISIBLE);


        int[] images1 = new int[]{
                R.drawable.angry1, R.drawable.cake1, R.drawable.candy1, R.drawable.firefighter1, R.drawable.icecream1, R.drawable.pizza1, R.drawable.sad1, R.drawable.school1, R.drawable.sick1, R.drawable.spagetti1};

        int[] images2 = new int[]{
                R.drawable.angry2, R.drawable.cake2, R.drawable.candy2, R.drawable.firefighter2, R.drawable.icecream2, R.drawable.pizza2, R.drawable.sad2, R.drawable.school2, R.drawable.sick2, R.drawable.spagetti2};


        Random random = new Random();
        int randomNum = random.nextInt(10);
        int questionPicture = images1[randomNum];

        int correctPicture = images2[randomNum];
        int secondRandomNum = random.nextInt(10);
        if (secondRandomNum == randomNum)
            secondRandomNum = random.nextInt(10);

        int wrongPicture = images2[secondRandomNum];


        questionImage.setImageResource(questionPicture);
        questionImage.setVisibility(View.VISIBLE);

        Random place = new Random();
        int placeNum = place.nextInt(2)+1;

        if (placeNum == 1){
            firstImage.setImageResource(correctPicture);
            firstImage.setVisibility(View.VISIBLE);
            secondImage.setImageResource(wrongPicture);
            secondImage.setVisibility(View.VISIBLE);
        }
        else{
            firstImage.setImageResource(wrongPicture);
            firstImage.setVisibility(View.VISIBLE);
            secondImage.setImageResource(correctPicture);
            secondImage.setVisibility(View.VISIBLE);
        }

        firstImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (placeNum == 1)
                    text.setText(R.string.correct4);
                else
                    text.setText(R.string.wrong_next_question_is_coming);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        startActivity(getIntent());

                    }
                }, 150);
            }
        });

        secondImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (placeNum == 2)
                    text.setText(R.string.correct4);
                else
                    text.setText(R.string.wrong_next_question_is_coming);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        startActivity(getIntent());

                    }
                }, 150);
            }
        });

    }
}