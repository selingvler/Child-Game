package com.example.test3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ClockLearning extends AppCompatActivity {

    private ClockView clockView;
    private boolean isTurkish = false; // Dil durumu bayrağı
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_learning);

        clockView = findViewById(R.id.clock_view);
        TextView text = findViewById(R.id.time_text_view);
        Button restart = findViewById(R.id.restart);
        Button switchLanguage = findViewById(R.id.switch_language); // Dil değiştirme butonu

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        int[] info = clockView.getRandomTime();
        int hour = info[0];
        int minute = info[1];

        String str = formatTimeString(hour, minute, isTurkish);
        text.setText(str);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(ClockLearning.this, ClockLearning.class));
            }
        });

        switchLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTurkish = !isTurkish;

                if (isTurkish) {
                    textToSpeech.setLanguage(new Locale("tr_TR"));
                } else {
                    textToSpeech.setLanguage(Locale.ENGLISH);

                }

                String newStr = formatTimeString(hour, minute, isTurkish);
                text.setText(newStr);
            }
        });
    }

    private String formatTimeString(int hour, int minute, boolean isTurkish) {
        if (isTurkish) {
            if (minute == 0)
                return hour + " saat";
            else if (minute < 30)
                return hour + " geçe " + minute;
            else if (minute == 30)
                return hour + " buçuk";
            else {
                int min = 60 - minute;
                int hr = hour + 1;
                return hr + "'e " + min + " kala";
            }
        } else {
            if (minute == 0)
                return hour + " o'clock";
            else if (minute < 30)
                return minute + " past " + hour;
            else if (minute == 30)
                return "half past " + hour;
            else {
                int min = 60 - minute;
                int hr = hour + 1;
                return min + " to " + hr;
            }
        }
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}
