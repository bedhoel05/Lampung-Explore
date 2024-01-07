package com.example.visitinglampung.wisata;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.visitinglampung.R;
import java.util.ArrayList;

public class wisataAdapter extends RecyclerView.Adapter<wisataAdapter.wisataViewHolder> {

    private final ArrayList<dataWisata> dataList;
    public wisataAdapter(ArrayList<dataWisata> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public wisataAdapter.wisataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_wisata, viewGroup, false);
        return new wisataViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull wisataAdapter.wisataViewHolder wisataViewHolder, @SuppressLint("RecyclerView") int position) {
        wisataViewHolder.nama.setText(dataList.get(position).getNama());
        wisataViewHolder.jam_buka.setText(dataList.get(position).getJam_buka());
        wisataViewHolder.jam_tutup.setText(dataList.get(position).getJam_tutup());
        wisataViewHolder.rating.setText(dataList.get(position).getRating());
        wisataViewHolder.tiket.setText(dataList.get(position).getTiket());


//        Intent untuk ke detail wisata
        wisataViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), detailWisataActivity.class);

                intent.putExtra("nama_wisata", dataList.get(position).getNama());
                intent.putExtra("jam_buka", dataList.get(position).getJam_buka());

                v.getContext().startActivity(intent);

            }
        });
//        Akhir intent ke detail wisata
        

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size():0;
    }


    public static class wisataViewHolder extends RecyclerView.ViewHolder {
        private final TextView nama, jam_buka, jam_tutup, rating, tiket;
        private final CardView parentLayout;

        public wisataViewHolder (@NonNull View itemView){
            super(itemView);

            nama = itemView.findViewById(R.id.txt_list_wisata_nama);
            jam_buka = itemView.findViewById(R.id.txt_list_wisata_jamBuka);
            jam_tutup = itemView.findViewById(R.id.txt_list_wisata_jamTutup);
            rating = itemView.findViewById(R.id.txt_list_wisata_rating);
            tiket = itemView.findViewById(R.id.txt_list_wisata_tikcet);

//            Deklarasi cardview untuk intent
            parentLayout = itemView.findViewById(R.id.card_Wisata);

        }
    }
}
