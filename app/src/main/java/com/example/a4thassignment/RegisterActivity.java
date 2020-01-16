package com.example.a4thassignment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4thassignment.Url.Url;
import com.example.a4thassignment.api.UserApi;
import com.example.a4thassignment.model.User;
import com.example.a4thassignment.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText FullName, Email, Password;
    Button btnSignup;
    CheckBox chkb;
    boolean ischecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        FullName = findViewById(R.id.etName);
        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        btnSignup = findViewById(R.id.btnSubmit);
        chkb = findViewById(R.id.checkbox);
        final Bundle bundle = getIntent().getExtras();

        chkb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ischecked = true;
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(FullName.getText().toString()))
                {
                    FullName.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(Password.getText().toString())){
                    Password.setError("Mandatory Field");
                    return;
                }
                else if (TextUtils.isEmpty(Email.getText().toString())){
                    Email.setError("Mandatory Field");
                    return;
                }
                else if (ischecked = false){
                    chkb.setError("Mandatory Field");
                    return;
                }

                String Phoneno = bundle.getString("PhoneNo");
                String SMS = bundle.getString("SMS");
                String Name = FullName.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                User users = new User(Name,email,Phoneno,password,SMS);

                UserApi usersAPI = Url.getInstance().create(UserApi.class);
                Call<SignUpResponse> signUpCall = usersAPI.registerUser(users);

                signUpCall.enqueue(new Callback<SignUpResponse>() {
                    @Override
                    public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<SignUpResponse> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });            }
        });
    }

}