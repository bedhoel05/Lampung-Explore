package com.example.visitinglampung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class registerActivity extends AppCompatActivity {

    Button btn_register;
    TextView txt_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register = findViewById(R.id.btn_register);
        txt_login = findViewById(R.id.txt_login);


        btn_register.setOnClickListener(v-> {
            Intent goRegister = new Intent(registerActivity.this, successActivity.class);
            goRegister.putExtra("namaActiity", "Register");
            startActivity(goRegister);
        });

        txt_login.setOnClickListener(v-> {
            Intent goLogin = new Intent(registerActivity.this, loginActivity.class);
            goLogin.putExtra("namaActiity", "Halaman Login");
            startActivity(goLogin);
        });
    }
}