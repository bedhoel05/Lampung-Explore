package com.example.visitinglampung.wisata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.visitinglampung.MainActivity;
import com.example.visitinglampung.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class wisataActivity extends AppCompatActivity {

    private DatabaseReference reference;
    ArrayList<dataWisata> list;
    adapterWisata adapter;

    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

//    CardView cardWisata
    CardView cardToDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        mRecycler = findViewById(R.id.recyclerWisata);
        mRecycler.setHasFixedSize(true);

        mManager = new LinearLayoutManager(this);
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        reference = FirebaseDatabase.getInstance().getReference().child("wisata");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    dataWisata wisata = dataSnapshot1.getValue(dataWisata.class);
                    list.add(wisata);
                }
                adapter = new adapterWisata(getApplicationContext(), list);
                mRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Terjadi Kesalahan: " + error.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("FirebaseError", "Firebase error: " + error.getMessage());
            }
        });


//        Code Intent
//        cardWisata = findViewById(R.id.card_Wisata);
        cardToDashboard = findViewById(R.id.card_wisata_back_to_main);

//        cardWisata.setOnClickListener(v->{
//            Intent goWisata = new Intent(wisataActivity.this, detailWisataActivity.class);
//            startActivity(goWisata);
//        });

        cardToDashboard.setOnClickListener(v->{
            Intent goDashboard = new Intent(wisataActivity.this, MainActivity.class);
            startActivity(goDashboard);
        });
    }
}