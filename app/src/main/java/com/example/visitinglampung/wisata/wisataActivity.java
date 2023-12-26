package com.example.visitinglampung.wisata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.visitinglampung.MainActivity;
import com.example.visitinglampung.R;

public class wisataActivity extends AppCompatActivity {

    CardView cardWisata, cardToDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        cardWisata = findViewById(R.id.card_Wisata);
        cardToDashboard = findViewById(R.id.card_wisata_back_to_main);

        cardWisata.setOnClickListener(v->{
            Intent goWisata = new Intent(wisataActivity.this, detailWisataActivity.class);
            startActivity(goWisata);
        });

        cardToDashboard.setOnClickListener(v->{
            Intent goDashboard = new Intent(wisataActivity.this, MainActivity.class);
            startActivity(goDashboard);
        });
    }
}