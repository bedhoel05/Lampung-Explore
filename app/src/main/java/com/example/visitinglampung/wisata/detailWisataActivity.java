package com.example.visitinglampung.wisata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.visitinglampung.R;


public class detailWisataActivity extends AppCompatActivity {

    CardView cardToWisata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        cardToWisata = findViewById(R.id.card_back_to_wisata);

        cardToWisata.setOnClickListener(v-> {
            Intent goWisata = new Intent(detailWisataActivity.this, wisataActivity.class);
            startActivity(goWisata);
        });
    }


}