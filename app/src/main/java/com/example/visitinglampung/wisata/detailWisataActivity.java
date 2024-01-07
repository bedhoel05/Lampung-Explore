package com.example.visitinglampung.wisata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.visitinglampung.R;


public class detailWisataActivity extends AppCompatActivity {

    CardView cardToWisata;

    TextView txt_detil_nama_wisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

//        Deklarasi textview
        txt_detil_nama_wisata = findViewById(R.id.txt_detil_nama_wisata);

//        Get data intent
        Intent detilWisata = getIntent();
        String nilaiIntent = detilWisata.getStringExtra("nama_wisata");

//        Menampilkan nilai intent
        txt_detil_nama_wisata.setText(String.valueOf(nilaiIntent));

        cardToWisata = findViewById(R.id.card_back_to_wisata);
        cardToWisata.setOnClickListener(v-> {
            Intent goWisata = new Intent(detailWisataActivity.this, wisataActivity.class);
            startActivity(goWisata);
        });
    }


}