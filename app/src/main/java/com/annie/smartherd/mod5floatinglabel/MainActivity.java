package com.annie.smartherd.mod5floatinglabel;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText fullNameEditText, emailEditText, passwordEditText;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword, inputTest;

    private Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeWidgets();

        initializeListeners();
    }

    private void initializeWidgets() {

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        inputLayoutName = (TextInputLayout) findViewById(R.id.inputLayoutFullName);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.inputLayoutEmail);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.inputLayoutPassword);

        fullNameEditText = (EditText) findViewById(R.id.fullnameField);
        emailEditText = (EditText) findViewById(R.id.emailField);
        passwordEditText = (EditText) findViewById(R.id.passwordField);

        signupBtn = (Button) findViewById(R.id.signUpBtn);
    }

    private void initializeListeners() {

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {

        boolean isValid = true;

        if (fullNameEditText.getText().toString().isEmpty()) {
            inputLayoutName.setError("Your name is mandatory");
            isValid = false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        if (emailEditText.getText().toString().isEmpty()) {
            inputLayoutEmail.setError("Email is mandatory");
            isValid = false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        if (passwordEditText.getText().toString().trim().length() < 8 ) {
            inputLayoutPassword.setError(getString(R.string.pwd_validation_msg));
            isValid = false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        if (isValid) {
            Toast.makeText(MainActivity.this, R.string.signup_success, Toast.LENGTH_SHORT).show();
        }
    }
}
