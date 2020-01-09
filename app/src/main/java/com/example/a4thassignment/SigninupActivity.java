package com.example.a4thassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SigninupActivity extends AppCompatActivity {
    Button btnSignIn,btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinup);
        btnSignIn=findViewById(R.id.btnSignin);
        btnCreateAccount=findViewById(R.id.btnCreateAccount);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SigninupActivity.this,SignInActivity.class));
            }
        });

        this.btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SigninupActivity.this,SIgnUpActivity.class));
            }
        });


    }
}
