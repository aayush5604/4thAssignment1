package com.example.a4thassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class SIgnUpActivity extends AppCompatActivity {

    EditText PhoneNo, SMS;
    Button btnNext, btnSend;
    TextView tvLogin;
    int min = 1;
    int max = 100000;

    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.btnNext=findViewById(R.id.btnNext);
        PhoneNo=findViewById(R.id.etPhonenumvber);
        SMS= findViewById(R.id.etSmsCode);
        tvLogin=findViewById(R.id.tvLogin);
        btnSend=findViewById(R.id.btnsend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(PhoneNo.getText().toString()))
                {
                    PhoneNo.setError("Mandatory Field");
                    return;
                }
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(1000);
                            int I1 = r.nextInt(max - min + 1) + min;
                            SMS.setText(Integer.toString(I1));
                        }   catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(PhoneNo.getText().toString()))
                {
                    PhoneNo.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(SMS.getText().toString())){
                    SMS.setError("Mandatory Field");
                    return;
                }
                Intent intent = new Intent(SIgnUpActivity.this, RegisterActivity.class);
                String No = PhoneNo.getText().toString();
                String sms = SMS.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("PhoneNo", No);
                bundle.putString("SMS", sms);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SIgnUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        }
}
