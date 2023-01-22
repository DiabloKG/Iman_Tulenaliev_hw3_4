package com.example.iman_tulenaliev_hw3_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ActivityInfo extends AppCompatActivity {

    ImageView imageView;
    TextView title;
    TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        findViews();
        getData();
    }

    private void findViews() {
        imageView = findViewById(R.id.imageView_info);
        title = findViewById(R.id.text_view_title_info);
        price = findViewById(R.id.text_view_price);
    }

    private void getData() {
        if (getIntent().getSerializableExtra("hotel") != null) {
            Hotel hotel = (Hotel) getIntent().getSerializableExtra("hotel");
            Glide.with(this).load(hotel.getImage()).into(imageView);
            title.setText(hotel.getTitle());
            price.setText(hotel.getPrice());
        }
    }
}