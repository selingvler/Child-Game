package com.example.test3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class DirectionsActivity extends AppCompatActivity {
ImageView imagedir;
TextView tvdirect;
Button buttondir;
Random r;
Integer [] images = {R.drawable.goahead, R.drawable.gopast, R.drawable.stop, R.drawable.turnleft,
        R.drawable.turnright, R.drawable.up};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_directions);
        imagedir = (ImageView) findViewById(R.id.imageViewdir);
        buttondir = (Button) findViewById(R.id.buttondir);
        tvdirect = (TextView) findViewById(R.id.tvdirec);

        r = new Random();

        buttondir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomIndex = r.nextInt(images.length);
                imagedir.setImageResource(images[randomIndex]);
                switch (randomIndex){
                    case 0:
                        tvdirect.setText(R.string.go_ahead);
                        break;
                    case 1:
                        tvdirect.setText(R.string.go_past);
                        break;
                    case 2:
                        tvdirect.setText(R.string.stop);
                        break;
                    case 3:
                        tvdirect.setText(R.string.turn_left);
                        break;
                    case 4:
                        tvdirect.setText(R.string.turn_right);
                        break;
                    case 5:
                        tvdirect.setText(R.string.go_straight_on);
                        break;
                }
            }
        });

    }
}