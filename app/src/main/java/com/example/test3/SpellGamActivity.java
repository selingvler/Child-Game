package com.example.test3;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class SpellGamActivity extends AppCompatActivity {
    Button buttonspl, btnTr;
    ImageButton btnvoice;
    EditText edtspl;
    TextToSpeech textToSpeech;
    final Handler handler = new Handler();

    boolean isTurkish = false; // Dil durumu bayrağı

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spell_gam);

        buttonspl = findViewById(R.id.buttonspel);
        btnvoice = findViewById(R.id.btnvoice);
        btnTr = findViewById(R.id.languageDays); // Türkçe butonu
        edtspl = findViewById(R.id.editTextspel);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        btnvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edtspl.getText().toString();
                textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        buttonspl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        startActivity(getIntent());
                    }
                }, 3000);
            }
        });

        btnTr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTurkish = !isTurkish;

                if (isTurkish) {
                    textToSpeech.setLanguage(new Locale("tr_TR"));
                } else {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });
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
