package com.example.visitinglampung.akomodasi;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.visitinglampung.R;
import com.example.visitinglampung.wisata.detailWisataActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class akomodasiAdapter extends RecyclerView.Adapter<akomodasiAdapter.akomodasiViewHolder>{
    private final ArrayList<dataAkomodasi> dataList;
    public akomodasiAdapter(ArrayList<dataAkomodasi> dataList){

        this.dataList = dataList;
    }
    @NonNull
    @Override
    public akomodasiAdapter.akomodasiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_akomodasi, viewGroup, false);
        return new akomodasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull akomodasiAdapter.akomodasiViewHolder akomo, @SuppressLint("Recyclerview") int position) {
        akomo.nama.setText(dataList.get(position).getNama());
        akomo.rating.setText(dataList.get(position).getRating());
        String imageUrl = dataList.get(position).getImage();
        Picasso.get().load(imageUrl).into(akomo.image);

        akomo.parentLayout.setOnClickListener(v->{
            Intent intent = new Intent(v.getContext(), detailWisataActivity.class);

            intent.putExtra("nama_akomodasi", dataList.get(position).getNama());
            intent.putExtra("rating", dataList.get(position).getRating());
            intent.putExtra("deskripsi", dataList.get(position).getDeskripsi());
            intent.putExtra("telepon", dataList.get(position).getTelepon());
            intent.putExtra("website", dataList.get(position).getWebsite());
            intent.putExtra("instagram", dataList.get(position).getInstagram());
            intent.putExtra("alamat", dataList.get(position).getAlamat());
            intent.putExtra("image", dataList.get(position).getImage());
            intent.putExtra("maps", dataList.get(position).getMaps_link());

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class akomodasiViewHolder extends RecyclerView.ViewHolder {
        private final TextView nama, rating;
        private final ImageView image;

        private final CardView parentLayout;
        public akomodasiViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.txt_list_akomodasi_nama_hotel);
            rating = itemView.findViewById(R.id.txt_list_akomodasi_rating_hotel);
            image = itemView.findViewById(R.id.img_detil_akomodasi);
            parentLayout = itemView.findViewById(R.id.card_list_akomodasi);
        }
    }
}
