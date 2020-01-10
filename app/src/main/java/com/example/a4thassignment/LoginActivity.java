package com.example.a4thassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4thassignment.bll.LoginBll;
import com.example.a4thassignment.strictmode.StrictModeClass;

public class LoginActivity extends AppCompatActivity {
    private EditText Email,Password;
    private TextView tvCR;
    private Button btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        tvCR = findViewById(R.id.tvCreateAccount);
        Email = findViewById(R.id.etMobileNumberOrEmail);
        Password = findViewById(R.id.etPassword1);
        btnLog = findViewById(R.id.btnLogin);

        tvCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SIgnUpActivity.class);
                startActivity(intent);
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    private void login(){
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        LoginBll loginBLL = new LoginBll();

        StrictModeClass.StrictMode();
        if (loginBLL.checkUser(email, password)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            Email.requestFocus();
        }

    }


    }

