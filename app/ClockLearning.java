package com.example.atry;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClockLearning extends AppCompatActivity {

    private ClockView clockView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_learning);

        clockView = findViewById(R.id.clock_view);
        TextView text = findViewById(R.id.time_text_view);
        Button restart = findViewById(R.id.restart);

        int[] info = clockView.getRandomTime();

        int hour = info[0];
        int minute = info[1];



        text.setText(hour + ":" + minute);
        //sadece 5 10 15 şeklinde yapılabilir, tek sayılarda başına 0 gelmesi sağlanmalı

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(ClockLearning.this, ClockLearning.class));
            }
        });
    }
}