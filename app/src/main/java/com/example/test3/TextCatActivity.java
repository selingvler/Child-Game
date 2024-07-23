package com.example.test3;

import android.location.GnssAntennaInfo;
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
import java.util.SplittableRandom;

public class TextCatActivity extends AppCompatActivity {
    Button buttonspl, btnTr;
    ImageButton btnvoice;
    EditText edtspl;
    TextToSpeech textToSpeech;
    TextView txtspell, txtcorr;
    String[] quotesEn = {"apple", "dress", "skirt", "watermelon", "red", "pink", "blue", "yellow", "read", "write", "coffee", "tea", "biscuit", "numbers", "cake", "muffin", "trousers", "shirt", "spring", "summer", "winter", "fall"};
    String[] quotesTr = {"elma", "elbise", "etek", "karpuz", "kırmızı", "pembe", "mavi", "sarı", "okumak", "yazmak", "kahve", "çay", "bisküvi", "sayılar", "pasta", "kek", "pantolon", "gömlek", "ilkbahar", "yaz", "kış", "sonbahar"};
    boolean isTurkish = false; // Dil durumu bayrağı

    String[] quotes = quotesEn; // Başlangıçta İngilizce
    String randomQuote = quotes[(int) (Math.random() * quotes.length)];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_text_cat);
        buttonspl = findViewById(R.id.buttonspel);
        btnvoice = findViewById(R.id.btnvoice);
        btnTr = findViewById(R.id.languageDays); // Türkçe butonu

        edtspl = findViewById(R.id.editTextspel);
        txtspell = findViewById(R.id.textViewspel);
        txtcorr = findViewById(R.id.textViewcorr);
        final Handler handler = new Handler();

        txtspell.setText(randomQuote);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int language = textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        btnvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = txtspell.getText().toString();
                int speech = textToSpeech.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        buttonspl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spellcont = edtspl.getText().toString();

                if (spellcont.equalsIgnoreCase(txtspell.getText().toString())) {
                    txtcorr.setText(isTurkish ? "DOĞRU" : "CORRECT");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                            startActivity(getIntent());
                        }
                    }, 3000);
                } else {
                    txtcorr.setText(isTurkish ? "YANLIŞ, TEKRAR DENE" : "FALSE, TRY AGAIN");
                }
            }
        });

        btnTr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTurkish = !isTurkish;
                quotes = isTurkish ? quotesTr : quotesEn;
                randomQuote = quotes[(int) (Math.random() * quotes.length)];
                txtspell.setText(randomQuote);

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
