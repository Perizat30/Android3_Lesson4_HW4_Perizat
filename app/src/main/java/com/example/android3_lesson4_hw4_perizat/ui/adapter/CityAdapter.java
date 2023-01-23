package com.example.android3_lesson4_hw4_perizat.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.android3_lesson4_hw4_perizat.R;
import com.example.android3_lesson4_hw4_perizat.city.City;
import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityViewHolder>{
    public ArrayList<City> arrayListCities;
    private final OnItemClick onItemClick;

    public CityAdapter(ArrayList<City> arrayListCities, OnItemClick  onItemClick) {
        this.arrayListCities = arrayListCities;
        this.onItemClick=onItemClick;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CityViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.onBind(arrayListCities.get(position));
        holder.itemView.setOnClickListener(v -> onItemClick.onClick(arrayListCities.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return arrayListCities.size();
    }
}
class CityViewHolder extends RecyclerView.ViewHolder{
    TextView textView;
    ImageView imageView;
    public CityViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    void onBind(City city){
        imageView=itemView.findViewById(R.id.image_view_icon);
        textView=itemView.findViewById((R.id.text_view_title));

        textView.setText(city.getName());
        Glide.with(imageView).load(city.getImage()).into(imageView);
    }
}
