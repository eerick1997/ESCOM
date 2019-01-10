package com.example.erick.adooproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import Adapters.AdapterStations;
import Objects.Station;
import UIElements.ChangeStyle;

public class ActivityStations extends AppCompatActivity {

    //Constants
    private static final String TAG = "ActivityStations.java";

    //Variables
    private ArrayList<Station> stations;
    private Toolbar toolbar;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        setContentView(R.layout.activity_stations);
        ChangeStyle style = new ChangeStyle(ActivityStations.this);

        //Getting toolbar element
        toolbar = findViewById(R.id.activity_stations_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //Setting color in the status bar
        window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#303f9f"));

        //Getting extra information
        Intent intent = getIntent();

        stations = intent.getParcelableArrayListExtra("Stations");

        RecyclerView recyclerView = findViewById(R.id.activity_stations_recycler_view);
        AdapterStations adapterStations = new AdapterStations(stations, ActivityStations.this);
        recyclerView.setAdapter(adapterStations);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, DividerItemDecoration.VERTICAL, false));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, UIElements.DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        String color = intent.getStringExtra("color");
        //Log.i(TAG, "onCreate: color: " + color);
        style.setColorWindow(color, getWindow());
        style.setColorToolbar(color, toolbar);
    }
}
