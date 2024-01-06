package com.example.visitinglampung.wisata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.visitinglampung.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class wisataAdapter extends RecyclerView.Adapter<wisataAdapter.wisataViewHolder> {

    private ArrayList<dataWisata> dataList;
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
    public void onBindViewHolder(@NonNull wisataAdapter.wisataViewHolder wisataViewHolder, int position) {
        wisataViewHolder.nama.setText(dataList.get(position).getNama());
        wisataViewHolder.jam_buka.setText(dataList.get(position).getJam_buka());
        wisataViewHolder.jam_tutup.setText(dataList.get(position).getJam_tutup());
        wisataViewHolder.rating.setText(dataList.get(position).getRating());
        wisataViewHolder.tiket.setText(dataList.get(position).getTiket());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size():0;
    }


    public class wisataViewHolder extends RecyclerView.ViewHolder {
        private TextView nama, jam_buka, jam_tutup, rating, tiket;

        public wisataViewHolder (@NonNull View itemView){
            super(itemView);

            nama = itemView.findViewById(R.id.txt_list_wisata_nama);
            jam_buka = itemView.findViewById(R.id.txt_list_wisata_jamBuka);
            jam_tutup = itemView.findViewById(R.id.txt_list_wisata_jamTutup);
            rating = itemView.findViewById(R.id.txt_list_wisata_rating);
            tiket = itemView.findViewById(R.id.txt_list_wisata_tikcet);

        }
    }
}
