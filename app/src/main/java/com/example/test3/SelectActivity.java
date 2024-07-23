package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test3.databinding.ActivitySeasonsBinding;

public class SelectActivity extends AppCompatActivity {
Button playb;
Button learnb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select);
   playb = (Button) findViewById(R.id.bplay);
   learnb = (Button) findViewById(R.id.blearn);

learnb.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent receivedIntent= getIntent();
        String value = receivedIntent.getStringExtra("page");
        if (value.equals("clock")){
            Intent learnsimilr = new Intent(SelectActivity.this, ClockLearning.class );
            startActivity(learnsimilr);}
        if (value.equals("multiplication")){
        Intent learnmult = new Intent(SelectActivity.this, MultiplicationActivity.class );
        startActivity(learnmult);}

        if (value.equals("direction")){
            Intent learndir = new Intent(SelectActivity.this,DirectionsActivity.class );
            startActivity(learndir);}
        if (value.equals("spell")){
            Intent learnspell = new Intent(SelectActivity.this,SpellGamActivity.class );
            startActivity(learnspell);}
        if (value.equals("similar")){
            Intent learnsimilr = new Intent(SelectActivity.this,FindSimilar.class );
            startActivity(learnsimilr);}
        if (value.equals("digitsb")){
            Intent learnsimilr = new Intent(SelectActivity.this,DigitsBackwardLearning.class );
            startActivity(learnsimilr);}
        if (value.equals("digitsf")){
            Intent learnsimilr = new Intent(SelectActivity.this,DigitsForwardLearning.class );
            startActivity(learnsimilr);}
        if (value.equals("months")){
            Intent learnsimilr = new Intent(SelectActivity.this,MonthsLearning.class );
            startActivity(learnsimilr);}
        if (value.equals("days")){
            Intent learnsimilr = new Intent(SelectActivity.this,DaysLearning.class );
            startActivity(learnsimilr);}
        if (value.equals("seasons")){
            Intent learnsimilr = new Intent(SelectActivity.this, SeasonsXml.class );
            startActivity(learnsimilr);}
        if (value.equals("digclock")){
            Intent learnsimilr = new Intent(SelectActivity.this, DigitalCLearn.class );
            startActivity(learnsimilr);}
    }
});
playb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent receivedIntent= getIntent();
                String value = receivedIntent.getStringExtra("page");
                if (value.equals("multiplication")){
                Intent play = new Intent(SelectActivity.this, MultgameActivity.class );
               startActivity(play);}
                if (value.equals("clock")){
                    Intent learnsimilr = new Intent(SelectActivity.this, ClockPlaying.class );
                    startActivity(learnsimilr);}
                if (value.equals("direction")){
                    Intent play = new Intent(SelectActivity.this,DirGameActivity.class );
                    startActivity(play);}
                if (value.equals("spell")){
                    Intent playspell = new Intent(SelectActivity.this,TextCatActivity.class );
                    startActivity(playspell);}
                if (value.equals("similar")){
                    Intent plysimilr = new Intent(SelectActivity.this,FindSimilarPlaying.class );
                    startActivity(plysimilr);}
                if (value.equals("digitsb")){
                    Intent learnsimilr = new Intent(SelectActivity.this,DigitsBackwardPlaying.class );
                    startActivity(learnsimilr);}
                if (value.equals("digitsf")){
                    Intent learnsimilr = new Intent(SelectActivity.this,DigitsForwardPlaying.class );
                    startActivity(learnsimilr);}
                if (value.equals("days")){
                    Intent learnsimilr = new Intent(SelectActivity.this,DaysPlaying.class );
                    startActivity(learnsimilr);}
                if (value.equals("seasons")){
                    Intent learnsimilr = new Intent(SelectActivity.this, SeasonsDeneme.class );
                    startActivity(learnsimilr);}
                if (value.equals("months")){
                    Intent learnsimilr = new Intent(SelectActivity.this, MonthsPlaying.class );
                    startActivity(learnsimilr);}
                if (value.equals("digclock")){
                    Intent learnsimilr = new Intent(SelectActivity.this, DigitalCGame.class );
                    startActivity(learnsimilr);}


            }
        });
    }
}