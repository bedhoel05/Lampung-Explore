package com.example.visitinglampung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

public class successActivity extends AppCompatActivity {

    TextView namaActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

//        Declare var txtview
        namaActivity = findViewById(R.id.txt_success_activity);

//        Get nilai intent
        Intent goshopee = getIntent();
        String nilaiintent = goshopee.getStringExtra("namaActiity");
        namaActivity.setText(String.valueOf(nilaiintent));

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 200L);

    }
}