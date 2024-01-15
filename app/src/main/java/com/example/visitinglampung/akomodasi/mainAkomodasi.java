package com.example.visitinglampung.akomodasi;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.visitinglampung.R;
import com.example.visitinglampung.wisata.wisataActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class mainAkomodasi extends AppCompatActivity {

    private RecyclerView recyclerView;
    private akomodasiAdapter adapter;
    private ArrayList<dataAkomodasi> akomodasiArrayList;

    //    CardView cardWisata
    CardView cardToDashboard;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_akomodasi);

        db.collection("akomodasi")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            akomodasiArrayList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // Ambil data dari setiap dokumen Firestore dan tambahkan ke ArrayList
                                dataAkomodasi akomodasi = new dataAkomodasi(
                                        document.getString("nama"),
                                        document.getString("rating"),
                                        document.getString("deskripsi"),
                                        document.getString("telepon"),
                                        document.getString("website"),
                                        document.getString("instagram"),
                                        document.getString("alamat"),
                                        document.getString("image"),
                                        document.getString("maps_link")
                                );
                                akomodasiArrayList.add(akomodasi); // Tambahkan ke ArrayList
                            }
                            // Setelah selesai mengambil data, set adapter untuk RecyclerView
                            adapter = new akomodasiAdapter(akomodasiArrayList);
                            recyclerView.setAdapter(adapter);
                        } else {
                            Toast.makeText(mainAkomodasi.this, "Eror geting dokument", Toast.LENGTH_SHORT).show();
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
        recyclerView = (RecyclerView) findViewById(R.id.recyclerAkomodasi);
        adapter = new akomodasiAdapter(akomodasiArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mainAkomodasi.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}