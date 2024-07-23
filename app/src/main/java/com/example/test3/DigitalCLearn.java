package com.example.test3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextClock;
import android.widget.TextView;


import com.example.test3.R;

import java.util.Random;


public class DigitalCLearn extends AppCompatActivity {

    TextClock textClock, textAmPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_clearn);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        textClock = findViewById(R.id.textClockId);
        textAmPm = findViewById(R.id.textAmPmId);
        View changeTimeButton = findViewById(R.id.button2);
        TextView textDigital = findViewById(R.id.textDigital);


        Typeface myFont = Typeface.createFromAsset(getApplicationContext().getAssets(), "digital.ttf");
        textClock.setTypeface(myFont);
        textAmPm.setTypeface(myFont);

        changeTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int hour = random.nextInt(12) + 1;
                int minute = random.nextInt(60);

                textClock.setText(String.format("%02d:%02d", hour, minute));
                textAmPm.setText(hour < 12 ? "AM" : "PM");


                String timeInWords = getTimeInWords(hour, minute);
                textDigital.setText(timeInWords);

            }



            private String getTimeInWords(int randomHour, int randomMinute) {
                String timeInWords;
                int displayHour = randomHour % 12;
                displayHour = displayHour == 0 ? 12 : displayHour; // Handle midnight and noon

                // Handle special cases (o'clock, quarter past, half past)
                if (randomMinute == 0) {
                    timeInWords = String.format("%d o'clock", randomHour);
                } else if (randomMinute == 15) {
                    timeInWords = String.format("quarter past %d", displayHour);
                } else if (randomMinute == 30) {
                    timeInWords = String.format("half past %d", displayHour);
                } else if (randomMinute == 45) {
                    timeInWords = String.format("quarter to %d", (displayHour % 12) + 1);
                } else if (randomMinute < 30) {
                    timeInWords = String.format("%d minutes past %d", randomMinute, displayHour);
                } else {
                    timeInWords = String.format("%d minutes to %d", 60 - randomMinute, (displayHour % 12) + 1);
                }


                // Adjust for AM/PM
                timeInWords += (randomHour < 12) ? " AM" : " PM";

                return timeInWords;
            }
        });
    }
}
