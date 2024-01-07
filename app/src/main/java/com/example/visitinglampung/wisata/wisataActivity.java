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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        String jsonData =
                "[{'nama':'Pantai Pahawang','jam_buka':'07:00','jam_tutup':'17:00','rating':'4.5','tiket':'Rp. 10.000'}," +
                        "{'nama':'Pantai Marina','jam_buka':'07:00','jam_tutup':'17:00','rating':'4.5','tiket':'Rp. 10.000'}," +
                        "{'nama':'Pantai Sari Ringgung','jam_buka':'07:00','jam_tutup':'17:00','rating':'4.5','tiket':'Rp. 10.000'}," +
                        "{'nama':'Pantai Kedu Warna','jam_buka':'07:00','jam_tutup':'17:00','rating':'4.5','tiket':'Rp. 10.000'}," +
                        "{'nama':'Pantai Mutun','jam_buka':'07:00','jam_tutup':'17:00','rating':'4.5','tiket':'Rp. 10.000'}]";

        setData(jsonData);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerWisata);
        adapter = new wisataAdapter(wisataArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(wisataActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

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
                                jsonObject.getString("tiket"));

                wisataArrayList.add(wisata);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}