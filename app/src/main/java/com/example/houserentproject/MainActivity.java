package com.example.houserentproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    RecyclerView mRecyclerView;
    List<HomePageData> myHomePageDataList;
    HomePageData mhomePageData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Home Page");

        drawerLayout = findViewById(R.id.drawerId);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerViewId);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        myHomePageDataList = new ArrayList<>();

        mhomePageData = new HomePageData("10000 BDT", "Maijdee",R.drawable.image1);
        myHomePageDataList.add(mhomePageData);

        mhomePageData = new HomePageData("11000 BDT", "Sonapur",R.drawable.image2);
        myHomePageDataList.add(mhomePageData);

        mhomePageData = new HomePageData("9000 BDT", "Banglabazar",R.drawable.image3);
        myHomePageDataList.add(mhomePageData);

        mhomePageData = new HomePageData("9500 BDT", "Maijdee Bazar",R.drawable.image4);
        myHomePageDataList.add(mhomePageData);

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, myHomePageDataList);
        mRecyclerView.setAdapter(myAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}