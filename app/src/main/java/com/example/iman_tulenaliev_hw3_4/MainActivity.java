package com.example.iman_tulenaliev_hw3_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClick {

    RecyclerView recyclerView;
    private ArrayList<Hotel> arrayList;
    private HotelAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        fillList();
        setAdapter();
    }

    private void findViews() {
        recyclerView = findViewById(R.id.recycler_view);
    }

    private void fillList() {
        arrayList = new ArrayList<>();
        arrayList.add(new Hotel(getString(R.string.link_sahara_star),
                "Hotel Sahara Star", "Price: 799,99$"));
        arrayList.add(new Hotel(getString(R.string.Hygienic),
                "Hygienic Hotel Liberty Plaza", "Price: 559$"));
        arrayList.add(new Hotel(getString(R.string.Aster_Hotel),
                "Aster Hotel", "Price: 690$"));
        arrayList.add(new Hotel(getString(R.string.Kinkum_Hotel),
                "Hotel Kumkum", "Price: 767$"));
        arrayList.add(new Hotel(getString(R.string.Hotel_Flora),
                "Hotel Flora Suites", "Price: 994$"));
        arrayList.add(new Hotel(getString(R.string.Hotel_Balwas),
                "Hotel Balwas", "Price: 966$"));
    }

    private void setAdapter() {
        adapter = new HotelAdapter(arrayList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(Hotel hotel) {
        Intent intent = new Intent(MainActivity.this, ActivityInfo.class);
        intent.putExtra("hotel", hotel);
        startActivity(intent);
    }
}
