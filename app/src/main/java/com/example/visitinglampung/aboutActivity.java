package com.example.visitinglampung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class aboutActivity extends AppCompatActivity {

    TextView txtToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        txtToHome = findViewById(R.id.txt_about_to_home);

        txtToHome.setOnClickListener(v->{
            Intent goHome = new Intent(aboutActivity.this, MainActivity.class);
            startActivity(goHome);
        });
    }
}