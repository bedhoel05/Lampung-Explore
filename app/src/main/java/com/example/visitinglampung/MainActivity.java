package com.example.visitinglampung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.visitinglampung.wisata.wisataActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    CardView cardAbout, cardWisata, logout, socmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardAbout = findViewById(R.id.card_About_Team);
        cardWisata = findViewById(R.id.card_Wisata);
        socmed = findViewById(R.id.card_to_socmed);
        logout = findViewById(R.id.card_logout);

        cardAbout.setOnClickListener(v->{
            Intent goAbout = new Intent(MainActivity.this, aboutActivity.class);
            startActivity(goAbout);
        });

        logout.setOnClickListener(v->{
            FirebaseAuth.getInstance().signOut();
        });

        cardWisata.setOnClickListener(v->{
            Intent goWisata = new Intent(MainActivity.this, wisataActivity.class);
            startActivity(goWisata);
        });

        socmed.setOnClickListener(v->{
            Intent goWisata = new Intent(MainActivity.this, sosialMediaActivity.class);
            startActivity(goWisata);
        });
    }
}