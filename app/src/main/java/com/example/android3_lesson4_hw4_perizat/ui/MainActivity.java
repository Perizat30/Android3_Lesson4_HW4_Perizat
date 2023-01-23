package com.example.android3_lesson4_hw4_perizat.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.android3_lesson4_hw4_perizat.R;
import com.example.android3_lesson4_hw4_perizat.city.City;
import com.example.android3_lesson4_hw4_perizat.ui.adapter.CityAdapter;
import com.example.android3_lesson4_hw4_perizat.ui.adapter.OnItemClick;
import com.example.android3_lesson4_hw4_perizat.ui.details.DetailInfoActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClick {
    RecyclerView recyclerView;
    private ArrayList<City> cityArrayList;
    private CityAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        fillList();
        setAdapter();
    }

    private void findViews() {
        recyclerView=findViewById(R.id.recycler_view);

    }

    private void fillList() {
        cityArrayList =new ArrayList<>();
        cityArrayList.add(new City(getString(R.string.paris),
                getString(R.string.paris_image),
                getString(R.string.paris_description)));
        cityArrayList.add(new City(getString(R.string.peru),
                getString(R.string.peru_image),
                getString(R.string.peru_description)));
        cityArrayList.add(new City(getString(R.string.rome),
                getString(R.string.rome_image),
                getString(R.string.rome_description)));
        cityArrayList.add(new City(getString(R.string.london),
                getString(R.string.london_image),
                getString(R.string.london_description)));
        cityArrayList.add(new City(getString(R.string.pamukkale),
                getString(R.string.pamukkale_image),
                getString(R.string.pamukkale_description)));
        cityArrayList.add(new City(getString(R.string.phuket),
                getString(R.string.phuket_image),
                getString(R.string.phuket_description)));
        cityArrayList.add(new City(getString(R.string.new_york),
                getString(R.string.new_york_image),
                getString(R.string.new_york_description)));
        cityArrayList.add(new City(getString(R.string.barcelona),
                getString(R.string.barcelona_image),
                getString(R.string.barcelona_description)));
    }
    public void setAdapter(){
        adapter=new CityAdapter(cityArrayList,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(City city) {
        Intent intent=new Intent(MainActivity.this, DetailInfoActivity.class);
        intent.putExtra("city",city);
        startActivity(intent);
    }
}