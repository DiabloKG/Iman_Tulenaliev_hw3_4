package com.example.iman_tulenaliev_hw3_4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelViewHolder> {
    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HotelViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hotel, parent, false));
    }

    public ArrayList<Hotel> arrayList;
    private OnItemClick onItemClick;

    public HotelAdapter(ArrayList<Hotel> arrayList, OnItemClick onItemClick) {
        this.arrayList = arrayList;
        this.onItemClick = onItemClick;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        holder.onBind(arrayList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick(arrayList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}

class HotelViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView title;

    public HotelViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    void onBind(Hotel hotel) {
        imageView = itemView.findViewById(R.id.imageView_icon);
        title = itemView.findViewById(R.id.text_view_title);
        Glide.with(imageView).load(hotel.getImage()).into(imageView);
        title.setText(hotel.getTitle());

    }
}