package com.example.test3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.test3.R;

public class MultiplicationActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    String result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multiplication);
        editText = (EditText) findViewById(R.id.et1);
        button = (Button) findViewById(R.id.bt1);
        textView = (TextView) findViewById(R.id.tv_output );


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String number= editText.getText().toString();
                 int n = Integer.parseInt(number);
                  result = "";
                  for (int i =1; i<=10; i++){
                      result += n + " "+ "*"+ i + " "+ "=" + " "+ n*i + "\n";
                      textView.setText(result );
                  }
            }
        });



    }
}