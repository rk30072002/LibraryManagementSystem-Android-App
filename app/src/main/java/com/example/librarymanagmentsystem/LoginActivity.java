package com.example.librarymanagmentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
private FirebaseAuth mAuth;
private EditText emailTxt,passwordTxt;
private Button loginBtn;
private RadioGroup userTypeGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        emailTxt = findViewById(R.id.emailTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        userTypeGroup = findViewById(R.id.userTypeGroup);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(V -> loginUser());

    }
    private void loginUser(){
        String email = emailTxt.getText().toString();
        String password = passwordTxt.getText().toString();
        int selectUserType = userTypeGroup.getCheckedRadioButtonId();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(LoginActivity.this, "you can not leave Empty any Text", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        if(selectUserType == R.id.adminRadioBtn){
                            startActivity(new Intent(LoginActivity.this, AdminActivity.class ));
                        }else{
                            startActivity(new Intent(LoginActivity.this, UserActivity.class));
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "login Fail", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}