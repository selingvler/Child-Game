package com.example.test3;

import static java.lang.Boolean.TRUE;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class CreateAccount extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button regbtn;
    ProgressBar progressBar;
    EditText mailedt, usernameedtt, passedt;


    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(CreateAccount.this, CategoriesActivity.class);
            startActivity(intent);
            finish();        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_account);
         regbtn = (Button) findViewById(R.id.regbutton);
        mAuth = FirebaseAuth.getInstance();
         mailedt = (EditText) findViewById(R.id.emailedt);
         usernameedtt = (EditText) findViewById(R.id.usernameedt);
         passedt = (EditText) findViewById(R.id.passwordedt);



        regbtn.setOnClickListener(v -> {

            String username = String.valueOf(usernameedtt.getText());
            String email = String.valueOf(mailedt.getText());
            String password = String.valueOf(passedt.getText());

            if (TextUtils.isEmpty(username)){
                Toast.makeText(CreateAccount.this,"Enter username" ,Toast.LENGTH_SHORT ).show();
                return;
            }

            if (TextUtils.isEmpty(email)){
                Toast.makeText(CreateAccount.this,"Enter email" ,Toast.LENGTH_SHORT ).show();
                return;
            }

            if (TextUtils.isEmpty(password)){
                Toast.makeText(CreateAccount.this,"Enter password" ,Toast.LENGTH_SHORT ).show();
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //FirebaseUser user = mAuth.getCurrentUser(); doing only reg part

                            Toast.makeText(CreateAccount.this, "Account Created.",
                                    Toast.LENGTH_SHORT).show();
                            Intent account = new Intent(getApplicationContext(),logorreg.class );
                            //account.putExtra("situation","newaccount");
                            startActivity(account);
                            finish();


                        }
                        else {
                            String errorMessage = Objects.requireNonNull(task.getException()).getMessage();
                            Toast.makeText(CreateAccount.this, "Authentication failed: " + errorMessage, Toast.LENGTH_LONG).show();
                            Log.e("FirebaseAuth", "Error: " + errorMessage);
                            // If sign in fails, display a message to the user.
                            Toast.makeText(CreateAccount.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

        });
    }
}