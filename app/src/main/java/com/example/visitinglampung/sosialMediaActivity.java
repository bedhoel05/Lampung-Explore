package com.example.visitinglampung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class sosialMediaActivity extends AppCompatActivity {

    TextView txtToHome;
    CardView cardIg, cardYt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sosial_media);

        txtToHome = findViewById(R.id.txt_about_to_home);
        cardIg = findViewById(R.id.card_socmed1);
        cardYt = findViewById(R.id.card_socmed2);

        txtToHome.setOnClickListener(v->{
            Intent goHome = new Intent(sosialMediaActivity.this, MainActivity.class);
            startActivity(goHome);
        });

        cardIg.setOnClickListener(v->{
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                // Jika aplikasi Instagram tidak terinstall, berikan pesan kepada pengguna
                Toast.makeText(getApplicationContext(), "Aplikasi Instagram tidak terinstall", Toast.LENGTH_SHORT).show();
            }
        });

        cardYt.setOnClickListener(v->{
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                // Jika aplikasi YouTube tidak terinstall, berikan pesan kepada pengguna
                Toast.makeText(getApplicationContext(), "Aplikasi YouTube tidak terinstall", Toast.LENGTH_SHORT).show();
            }
        });

    }
}