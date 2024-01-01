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

public class adapterWisata extends RecyclerView.Adapter<adapterWisata.MyViewHolder> {

    private Context context;
    private ArrayList<dataWisata> dataWisatas;

    public adapterWisata(Context cont, ArrayList<dataWisata> data){
        context = cont;
        dataWisatas = data;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_wisata, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.txt_nama.setText(dataWisatas.get(position).getNama());
        holder.jam.setText(dataWisatas.get(position).getJam());
        holder.ticket.setText(Float.toString(dataWisatas.get(position).getTiket()));
        holder.rating.setText(Float.toString(dataWisatas.get(position).getRating()));

    }

    @Override
    public int getItemCount() {
        return dataWisatas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_nama, alamat, jam, image, ticket, rating;
        public MyViewHolder (@NonNull View itemView){
            super(itemView);

            txt_nama = itemView.findViewById(R.id.txt_list_wisata_nama);
            jam= itemView.findViewById(R.id.txt_list_wisata_jam);
            ticket = itemView.findViewById(R.id.txt_list_wisata_tikcet);
            rating = itemView.findViewById(R.id.txt_list_wisata_rating);
        }

    }
}
