package com.example.test3;

import static androidx.core.view.ViewCompat.animate;

import android.content.ClipData;
import android.os.Bundle;
import android.os.Handler;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DirGameActivity extends AppCompatActivity {
    TextView txt1, txt2, txt3, txt4, txt5, txt6, target, txtcheck;
    Integer[] images = {R.drawable.goahead, R.drawable.gopast, R.drawable.stop, R.drawable.turnleft,
            R.drawable.turnright, R.drawable.up};
    ImageView imageView;
    List<String> stringlist = Arrays.asList("go ahead", "go past", "stop", "turn left", "turn right", "go straight on");
    List<String> turkishStringList = Arrays.asList("ilerle", "geç", "dur", "sola dön", "sağa dön", "düz git");

    Random r;
    String truerep;
    boolean isTurkish = false; // Dil durumu bayrağı
    final Handler handler = new Handler();

    void checker(TextView txt, String truerep, View view) {
        if (txt.getText().toString().equalsIgnoreCase(truerep)) {
            target.setText(txt.getText());
            view.animate()
                    .x(target.getX())
                    .y(target.getY())
                    .setDuration(700)
                    .start();
            txt.setVisibility(View.INVISIBLE);
            txtcheck.setText(isTurkish ? "DOĞRU" : "CORRECT");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                    startActivity(getIntent());
                }
            }, 3000);
        } else {
            txtcheck.setText(isTurkish ? "YANLIŞ, DOĞRU CEVAP: " : "FALSE, TRUE RESPONSE WAS: ");
            target.setText(truerep);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                    startActivity(getIntent());
                }
            }, 3000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dir_game);
        txt1 = findViewById(R.id.textView2);
        txt2 = findViewById(R.id.textView3);
        txt3 = findViewById(R.id.textView4);
        txt5 = findViewById(R.id.textView5);
        txt6 = findViewById(R.id.textView7);
        txt4 = findViewById(R.id.textView6);
        txtcheck = findViewById(R.id.txtviewcheck);
        target = findViewById(R.id.target);
        imageView = findViewById(R.id.imageView);
        Button languageButton = findViewById(R.id.languageButton);

        txt1.setOnLongClickListener(longclicklistener);
        txt2.setOnLongClickListener(longclicklistener);
        txt3.setOnLongClickListener(longclicklistener);
        txt4.setOnLongClickListener(longclicklistener);
        txt5.setOnLongClickListener(longclicklistener);
        txt6.setOnLongClickListener(longclicklistener);

        target.setOnDragListener(dragListener);
        r = new Random();
        int randomIndex = r.nextInt(images.length);
        imageView.setImageResource(images[randomIndex]);
        updateTextViews();

        switch (randomIndex) {
            case 0:
                truerep = isTurkish ? "ilerle" : "go ahead";
                break;
            case 1:
                truerep = isTurkish ? "geç" : "go past";
                break;
            case 2:
                truerep = isTurkish ? "dur" : "stop";
                break;
            case 3:
                truerep = isTurkish ? "sola dön" : "turn left";
                break;
            case 4:
                truerep = isTurkish ? "sağa dön" : "turn right";
                break;
            case 5:
                truerep = isTurkish ? "düz git" : "go straight on";
                break;
        }

        languageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTurkish = !isTurkish;
                updateTextViews();
                truerep = getTrueRep(randomIndex); // Doğru cevabı güncelle
            }
        });
    }

    private void updateTextViews() {
        if (isTurkish) {
            txt1.setText(turkishStringList.get(0));
            txt2.setText(turkishStringList.get(1));
            txt3.setText(turkishStringList.get(2));
            txt4.setText(turkishStringList.get(3));
            txt5.setText(turkishStringList.get(4));
            txt6.setText(turkishStringList.get(5));
        } else {
            txt1.setText(stringlist.get(0));
            txt2.setText(stringlist.get(1));
            txt3.setText(stringlist.get(2));
            txt4.setText(stringlist.get(3));
            txt5.setText(stringlist.get(4));
            txt6.setText(stringlist.get(5));
        }
    }

    private String getTrueRep(int index) {
        if (isTurkish) {
            return turkishStringList.get(index);
        } else {
            return stringlist.get(index);
        }
    }

    View.OnLongClickListener longclicklistener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myshadowbuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myshadowbuilder, v, 0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragevent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragevent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.textView2) {
                        checker(txt1, truerep, view);
                    }
                    if (view.getId() == R.id.textView3) {
                        checker(txt2, truerep, view);
                    }
                    if (view.getId() == R.id.textView4) {
                        checker(txt3, truerep, view);
                    }
                    if (view.getId() == R.id.textView5) {
                        checker(txt5, truerep, view);
                    }
                    if (view.getId() == R.id.textView6) {
                        checker(txt4, truerep, view);
                    }
                    if (view.getId() == R.id.textView7) {
                        checker(txt6, truerep, view);
                    }
                    break;
            }
            return true;
        }
    };
}




