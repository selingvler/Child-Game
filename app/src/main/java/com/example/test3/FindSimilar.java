package com.example.test3;

import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FindSimilar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_similar);

        ImageView questionImage = findViewById(R.id.questionImage);
        ImageView firstImage = findViewById(R.id.firstImage);
        ImageView secondImage = findViewById(R.id.secondImage);
        Button continueb = findViewById(R.id.buttoncont);
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
        firstImage.setImageResource(correctPicture);
        firstImage.setVisibility(View.VISIBLE);
        secondImage.setImageResource(wrongPicture);
        secondImage.setVisibility(View.VISIBLE);

        continueb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

    /*
    int generator(){
        ArrayList<String> number = new ArrayList<String>(
                Arrays.asList("0","1","2","3","4","5","6","7","8","9"));
        Random random = new Random();
        int randomNum = random.nextInt(number.size());
        if (!number.isEmpty())
            number.remove(randomNum);
        else
            generator();
        return randomNum;
    }

     */
}







