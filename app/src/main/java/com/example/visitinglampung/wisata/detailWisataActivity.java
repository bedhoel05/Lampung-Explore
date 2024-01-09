package com.example.visitinglampung.wisata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.visitinglampung.R;
import com.squareup.picasso.Picasso;


public class detailWisataActivity extends AppCompatActivity {

    CardView cardToWisata;

    TextView nama, rating, buka, tutup, tiket;
    ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

//        Deklarasi textview
        nama = findViewById(R.id.txt_detil_nama_wisata);
        rating = findViewById(R.id.txt_rating_detil_wisata);
        buka = findViewById(R.id.buka_detil_wisata);
        tutup = findViewById(R.id.tutup_detil_wisata);
        tiket = findViewById(R.id.tiket_dewasa_detil_wisata);
        gambar = findViewById(R.id.img_detil_wisata);


//        Get data intent
        Intent detilWisata = getIntent();
        String namaIntent = detilWisata.getStringExtra("nama_wisata");
        String jamIntent = detilWisata.getStringExtra("jam_buka");
        String tutupIntent = detilWisata.getStringExtra("jam_tutup");
        String ratingIntent = detilWisata.getStringExtra("rating");
        String tiketIntent = detilWisata.getStringExtra("tiket");
        String imageIntent = detilWisata.getStringExtra("image");



//        Menampilkan nilai intent
        nama.setText(String.valueOf(namaIntent));
        buka.setText(String.valueOf(jamIntent));
        tutup.setText(String.valueOf(tutupIntent));
        rating.setText(String.valueOf(ratingIntent));
        tiket.setText(String.valueOf(tiketIntent));
        Picasso.get().load(imageIntent).into(gambar);

        cardToWisata = findViewById(R.id.card_back_to_wisata);
        cardToWisata.setOnClickListener(v-> {
            Intent goWisata = new Intent(detailWisataActivity.this, wisataActivity.class);
            startActivity(goWisata);
        });
    }


}