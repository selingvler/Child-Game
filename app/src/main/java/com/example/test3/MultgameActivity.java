package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;

import com.example.test3.R;

import java.util.Random;

public class MultgameActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multgame);
     textView = (TextView) findViewById(R.id.tvmoyun);
        editText = (EditText) findViewById(R.id.etoyun);
        button = (Button) findViewById(R.id.bmoyun);
        textView1 = (TextView) findViewById(R.id.tvoyunres);

        Random random = new Random();
        int randomNum1 = random.nextInt(10)+1;
        int randomNum2 = random.nextInt(10)+1;
        final Handler handler = new Handler();


        textView.setText(randomNum1 +" * "+randomNum2 + " = "+ "?");
        int res= randomNum1*randomNum2;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number= editText.getText().toString();
                int n = Integer.parseInt(number);
                if(n==res){
                    textView1.setText(R.string.true_str);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            finish();
                            startActivity(getIntent());

                        }
                    }, 1000);


                }
                else {
                    textView1.setText(R.string.false_try_again);

                }
            }
        });

    }
}