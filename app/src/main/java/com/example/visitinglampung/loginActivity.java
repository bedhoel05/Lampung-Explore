package com.example.visitinglampung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class loginActivity extends AppCompatActivity {

    Button btn_login;
    TextView txt_to_register, txt_forgot_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        txt_forgot_pass = findViewById(R.id.txt_forgotPassword);
        txt_to_register = findViewById(R.id.txt_to_register);

        btn_login.setOnClickListener(v-> {
            Intent goLogin = new Intent(loginActivity.this, successActivity.class);
            goLogin.putExtra("namaActiity", "Login");
            startActivity(goLogin);
        });

        txt_to_register.setOnClickListener(v-> {
            Intent goRegister = new Intent(loginActivity.this, registerActivity.class);
            goRegister.putExtra("namaActiity", "Register");
            startActivity(goRegister);
        });

        txt_forgot_pass.setOnClickListener(v-> {
            Intent goForgot = new Intent(loginActivity.this, registerActivity.class);
            goForgot.putExtra("namaActiity", "Silahkan Forgot Password");
            startActivity(goForgot);
        });

    }
}