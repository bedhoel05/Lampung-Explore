package com.example.visitinglampung.akomodasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.visitinglampung.R;
import com.example.visitinglampung.wisata.detailWisataActivity;
import com.example.visitinglampung.wisata.wisataActivity;
import com.squareup.picasso.Picasso;

public class detailAkomodasiActivity extends AppCompatActivity {

    TextView nama, rating, deskripsi, telepon, website, instagram, alamat, text_maps;
    ImageView image;
    CardView cardToWisata, cardMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_akomodasi);

        //        Deklarasi textview
        nama = findViewById(R.id.txt_detil_akomodasi_nama);
        rating = findViewById(R.id.txt_detil_akomodasi_rating);
        deskripsi = findViewById(R.id.txt_detil_akomodasi_deksripsi);
        alamat = findViewById(R.id.txt_detil_akomodasi_alamat);
        telepon = findViewById(R.id.txt_detil_akomodasi_telepon);
        image = findViewById(R.id.img_detil_akomodasi);
        website = findViewById(R.id.txt_detil_akomodasi_website);
        instagram = findViewById(R.id.txt_detil_akomodasi_instagram);
        cardMaps = findViewById(R.id.card_maps_detil_akomodasi);
        text_maps = findViewById(R.id.btn_txt_to_maps);

        //        Get data intent
        Intent detilAkomodasi = getIntent();
        String namaIntent = detilAkomodasi.getStringExtra("nama_akomodasi");
        String ratingIntent = detilAkomodasi.getStringExtra("rating");
        String deskripsiIntent = detilAkomodasi.getStringExtra("deskripsi");
        String teleponIntent = detilAkomodasi.getStringExtra("telepon");
        String websiteIntent = detilAkomodasi.getStringExtra("website");
        String instagramIntent = detilAkomodasi.getStringExtra("instagram");
        String alamatIntent = detilAkomodasi.getStringExtra("alamat");
        String imageIntent = detilAkomodasi.getStringExtra("image");
        String mapsIntent = detilAkomodasi.getStringExtra("maps");


        nama.setText(String.valueOf(namaIntent));
        rating.setText(String.valueOf(ratingIntent));
        deskripsi.setText(String.valueOf(deskripsiIntent));
        alamat.setText(String.valueOf(alamatIntent));
        telepon.setText(String.valueOf(teleponIntent));
        website.setText(String.valueOf(websiteIntent));
        instagram.setText(String.valueOf(instagramIntent));
        text_maps.setText("Arahkan saya ke "+String.valueOf(namaIntent));

        Picasso.get().load(imageIntent).into(image);

        cardMaps.setOnClickListener(v->{
            Intent to_maps = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(mapsIntent));
            to_maps.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            startActivity(to_maps);
        });

        cardToWisata = findViewById(R.id.card_back_to_wisata);
        cardToWisata.setOnClickListener(v-> {
            Intent goWisata = new Intent(detailAkomodasiActivity.this, wisataActivity.class);
            startActivity(goWisata);
        });
    }
}