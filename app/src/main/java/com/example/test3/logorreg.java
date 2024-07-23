package com.example.test3;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class logorreg extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText editTextEmail,editTextPassword;
    Button cr,login,changelang;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent receivedIntent= getIntent();


            Intent intent = new Intent(logorreg.this, CategoriesActivity.class);
            startActivity(intent);
            finish();


        }
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.logorreg);

        ActionBar actionBar = getActionBar();
        //actionBar.setTitle(getResources(),getString(R.string.app_name));

        mAuth = FirebaseAuth.getInstance();
        // ImageButton en = findViewById(R.id.btn_en);
        //ImageButton tr = findViewById(R.id.btn_tr);
         login = (Button) findViewById(R.id.btn_login);
        cr = (Button) findViewById(R.id.createbtn);
        changelang = (Button) findViewById(R.id.buttonlang);

         editTextEmail = (EditText) findViewById(R.id.email);
         editTextPassword = (EditText) findViewById(R.id.password);
        changelang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLanguageDialog();
            }
        });



        cr.setOnClickListener(view ->
        {
            Intent intent= new Intent(logorreg.this,CreateAccount.class );
            startActivity(intent);
        });



        findViewById(R.id.btn_login).setOnClickListener(view ->
        {

            String email = String.valueOf(editTextEmail.getText());
            String password = String.valueOf(editTextPassword.getText());

            if (TextUtils.isEmpty(email)){
                Toast.makeText(logorreg.this,"Enter email" ,Toast.LENGTH_SHORT ).show();
                return;
            }

            if (TextUtils.isEmpty(password)){
                Toast.makeText(logorreg.this,"Enter password" ,Toast.LENGTH_SHORT ).show();
                return;
            }
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(logorreg.this, CategoriesActivity.class);
                                startActivity(intent);
                                finish();

                            } else {

                                Toast.makeText(logorreg.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



        });






    }

    private void showChangeLanguageDialog() {
        final String[] listitems = {"English","Türkçe"};
        AlertDialog.Builder mbuilder = new AlertDialog.Builder(logorreg.this);
        mbuilder.setTitle("Choose Language...");
        mbuilder.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i==0){
                    setLocale("en");
                    recreate();
                }
                else if(i==1){
                    setLocale("tr");
                    recreate();
                }
                dialog.dismiss();
            }

        });
        AlertDialog mDialog = mbuilder.create();
        //show alert dialog
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        //save data to shared preferences
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_lang", lang);
        editor.apply();

    }
    public void loadLocale(){
        SharedPreferences pref = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = pref.getString("My_lang","");
        setLocale(language);
    }
}

