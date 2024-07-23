package com.example.atry;

import android.os.Bundle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

public class EyeTrackingActivity extends AppCompatActivity {

    Ball ball;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ball = new Ball(this);
        setContentView(ball);
    }
}