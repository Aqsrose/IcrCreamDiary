package com.example.icrcreamdiary;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignInActivity extends AppCompatActivity {
    Button btnSignUp;
    Button btnSignIn;
    EditText etUsername;
    EditText etPassword;
    FirebaseAuth auth;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    //made a separate function because it's being used twice
    private void moveToMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //to ensure a fresh main activity (prevent any previous saved state from being loaded)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); //because we don't want to return here after login
    }

    private boolean validate() {
        AwesomeValidation validator = new AwesomeValidation(BASIC); //for displaying error msg under the input field

        validator.addValidation(etUsername, RegexTemplate.NOT_EMPTY, "This field is required");
        validator.addValidation(etUsername, Patterns.EMAIL_ADDRESS, "Please enter a valid email");

        validator.addValidation(etPassword, RegexTemplate.NOT_EMPTY, "This field is required");

        return validator.validate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        auth = FirebaseAuth.getInstance();
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
        etUsername = findViewById(R.id.etUsernameSignin);
        etPassword = findViewById(R.id.etPasswordSignin);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                if (!validate()) {
                    return;
                }
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    moveToMainActivity();
                                    FirebaseUser user = auth.getCurrentUser();

                                } else{
                                    Snackbar.make(btnSignUp, "Log in Failed", Snackbar.LENGTH_LONG).show();
                                }
                            }
                        });


                // Perform sign-in logic here

                moveToMainActivity();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
