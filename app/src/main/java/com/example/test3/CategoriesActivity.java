package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CategoriesActivity extends AppCompatActivity {
    FirebaseAuth auth;
    Button clockbtn;
    Button multbtn;
    ImageButton btnlogout;
    Button direbtn,digbtn, spellbtn, btnseasons, btndays, btnmonths, digitsf, digitsb, similar, ball;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories);
        clockbtn = (Button) findViewById(R.id.clockbtn);
        multbtn = (Button) findViewById(R.id.multbtn);
        direbtn = (Button) findViewById(R.id.dirbtn);
        spellbtn = (Button) findViewById(R.id.spellbtn);
        btnlogout = (ImageButton) findViewById(R.id.buttonout);
        btnseasons = (Button) findViewById(R.id.buttonseasons);
        digbtn = (Button) findViewById(R.id.digclockbtn);
        btndays = (Button) findViewById(R.id.buttonweek);
        btnmonths = (Button) findViewById(R.id.buttonyear);
        digitsf = (Button) findViewById(R.id.buttondigitsf);
        digitsb = (Button) findViewById(R.id.buttondigitsb);
        similar = (Button) findViewById(R.id.buttonsimilar);
        ball = (Button) findViewById(R.id.buttonball);


        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if(user==null){
            Intent intent = new Intent(getApplicationContext(), logorreg.class);
            startActivity(intent);
            finish();
        }


        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), logorreg.class);
                startActivity(intent);
                finish();

            }
        });

        clockbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clock = new Intent(CategoriesActivity.this,SelectActivity.class );
                clock.putExtra("page","clock");
                startActivity(clock);
            }
        });
        digbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clock = new Intent(CategoriesActivity.this,SelectActivity.class );
                clock.putExtra("page","digclock");
                startActivity(clock);
            }
        });
        multbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mult = new Intent(CategoriesActivity.this,SelectActivity.class );
                mult.putExtra("page","multiplication");

                startActivity(mult);
            }
        });

        direbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dir = new Intent(CategoriesActivity.this,SelectActivity.class );
                dir.putExtra("page","direction");

                startActivity(dir);
            }
        });
        spellbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spell = new Intent(CategoriesActivity.this,SelectActivity.class );
                spell.putExtra("page","spell");

                startActivity(spell);
            }
        });
        btnseasons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spell = new Intent(CategoriesActivity.this,SelectActivity.class );
                spell.putExtra("page","seasons");

                startActivity(spell);
            }
        });
        btndays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spell = new Intent(CategoriesActivity.this,SelectActivity.class );
                spell.putExtra("page","days");

                startActivity(spell);
            }
        });
        btnmonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spell = new Intent(CategoriesActivity.this,SelectActivity.class );
                spell.putExtra("page","months");

                startActivity(spell);
            }
        });
        digitsf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spell = new Intent(CategoriesActivity.this,SelectActivity.class );
                spell.putExtra("page","digitsf");

                startActivity(spell);
            }
        });
        digitsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spell = new Intent(CategoriesActivity.this,SelectActivity.class );
                spell.putExtra("page","digitsb");

                startActivity(spell);
            }
        });
        similar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spell = new Intent(CategoriesActivity.this,SelectActivity.class );
                spell.putExtra("page","similar");

                startActivity(spell);
            }
        });
        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ball = new Intent(CategoriesActivity.this,EyeTrackingActivity.class );

                startActivity(ball);
            }
        });
    }
}