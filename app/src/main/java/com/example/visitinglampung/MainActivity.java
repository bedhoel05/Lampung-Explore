package com.example.visitinglampung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.visitinglampung.wisata.wisataActivity;

public class MainActivity extends AppCompatActivity {
    CardView cardAbout, cardWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardAbout = findViewById(R.id.card_About_Team);
        cardWisata = findViewById(R.id.card_Wisata);

        cardAbout.setOnClickListener(v->{
            Intent goAbout = new Intent(MainActivity.this, aboutActivity.class);
            startActivity(goAbout);
        });

        cardWisata.setOnClickListener(v->{
            Intent goWisata = new Intent(MainActivity.this, wisataActivity.class);
            startActivity(goWisata);
        });
    }
}