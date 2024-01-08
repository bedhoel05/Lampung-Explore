package com.example.visitinglampung.wisata;

import static android.content.ContentValues.TAG;

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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class wisataActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private wisataAdapter adapter;
    private ArrayList<dataWisata> wisataArrayList;

//    CardView cardWisata
    CardView cardToDashboard;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);



        String jsonData =
                "[{'nama':'Pantai Pahawang','jam_buka':'07:00','jam_tutup':'17:00','rating':'4.5','tiket':'10.000','gambar':'https://img.inews.co.id/media/1200/files/inews_new/2022/07/06/Pantai_Marina_Kalianda.jpg'}," +
                        "{'nama':'Pantai Marina','jam_buka':'07:00','jam_tutup':'17:00','rating':'4.5','tiket':'10.000','gambar':'https://img.inews.co.id/media/1200/files/inews_new/2022/07/06/Pantai_Marina_Kalianda.jpg'}," +
                        "{'nama':'Pantai Sari Ringgung','jam_buka':'07:00','jam_tutup':'17:00','rating':'4.5','tiket':'10.000','gambar':'https://img.inews.co.id/media/1200/files/inews_new/2022/07/06/Pantai_Marina_Kalianda.jpg'}," +
                        "{'nama':'Pantai Kedu Warna','jam_buka':'07:00','jam_tutup':'17:00','rating':'4.5','tiket':'10.000','gambar':'https://img.inews.co.id/media/1200/files/inews_new/2022/07/06/Pantai_Marina_Kalianda.jpg'}," +
                        "{'nama':'Pantai Mutun','jam_buka':'07:00','jam_tutup':'17:00','rating':'4.5','tiket':'10.000','gambar':'https://img.inews.co.id/media/1200/files/inews_new/2022/07/06/Pantai_Marina_Kalianda.jpg'}]";

        setData(jsonData);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerWisata);
        adapter = new wisataAdapter(wisataArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(wisataActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

//        Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference().child("wisata"); // Ganti dengan nama node Anda di database

        // Mengambil data dari Realtime Database
//        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    String nama = snapshot.child("nama").getValue(String.class);
//                    String jamBuka = snapshot.child("jam_buka").getValue(String.class);
//                    String jamTutup = snapshot.child("jam_tutup").getValue(String.class);
//                    String rating = snapshot.child("rating").getValue(String.class);
//                    String tiket = snapshot.child("tiket").getValue(String.class);
//
//                    // Membuat objek dataWisata dari data Realtime Database
//                    dataWisata wisata = new dataWisata(nama, jamBuka, jamTutup, rating, tiket);
//                    wisataArrayList.add(wisata);
//                }
//
//                // Memberitahu adapter bahwa data telah berubah
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Log.d(TAG, "Error: " + databaseError.getMessage());
//            }
//        });

//        Code Intent
        cardToDashboard = findViewById(R.id.card_wisata_back_to_main);
        cardToDashboard.setOnClickListener(v->{
            Intent goDashboard = new Intent(wisataActivity.this, MainActivity.class);
            startActivity(goDashboard);
        });
    }



    void setData(String jsonString) {
        try {
            JSONArray jsonArray= new JSONArray(jsonString);
            wisataArrayList = new ArrayList<>();
            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                dataWisata wisata = new dataWisata
                        (jsonObject.getString("nama"),
                                jsonObject.getString("jam_buka"),
                                jsonObject.getString("jam_tutup"),
                                jsonObject.getString("rating"),
                                jsonObject.getString("tiket"),
                                jsonObject.getString("image"));

                wisataArrayList.add(wisata);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}