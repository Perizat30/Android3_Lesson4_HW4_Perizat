package com.example.android3_lesson4_hw4_perizat.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.android3_lesson4_hw4_perizat.R;
import com.example.android3_lesson4_hw4_perizat.city.City;

public class DetailInfoActivity extends AppCompatActivity {
    ImageView imageView;
    TextView name;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);
        findViews();
        getData();
    }

    private void findViews() {
        imageView=findViewById(R.id.image_view_icon);
        name=findViewById(R.id.text_view_title);
        description=findViewById(R.id.text_view_description);
    }

    private void getData() {
        if (getIntent().getSerializableExtra("city")!=null){
            City city=(City)getIntent().getSerializableExtra("city");
            Glide.with(this).load(city.getImage()).into(imageView);
            name.setText(city.getName());
            description.setText(city.getDescription());
        }
    }
}