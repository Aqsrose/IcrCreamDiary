package com.example.icrcreamdiary;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class SignUpActivity extends AppCompatActivity {
     EditText etUsername, etEmail, etPassword, etConfirmPassword;
     Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword= findViewById(R.id.etConfirmPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String ConfirmPassword = etConfirmPassword.getText().toString().trim();
//                private boolean validate() {
//                    //String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
//
//                    AwesomeValidation validator = new AwesomeValidation(BASIC); //for displaying error msg under the input field
//
//                    validator.addValidation(etUsername, RegexTemplate.NOT_EMPTY, "This field is required");
//                    validator.addValidation(etUsername, Patterns.EMAIL_ADDRESS, "Please enter a valid email");
//
//                    validator.addValidation(etPassword, RegexTemplate.NOT_EMPTY, "This field is required");
//
//                    return validator.validate();

            }

            });
    }
}