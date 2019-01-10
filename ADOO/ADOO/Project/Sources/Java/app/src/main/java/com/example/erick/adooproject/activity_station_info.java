package com.example.erick.adooproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;
import java.util.ArrayList;

import Adapters.AdapterStationsInfo;
import MapUtilities.MLatLng;
import Objects.Station;
import UIElements.ChangeStyle;

/**This class contains the view to show information about
 * each station, we use animations to give a better user experience
 * Also we use the object station to get information and obviously
 * we go to display it**/
public class activity_station_info extends AppCompatActivity implements OnMapReadyCallback, Serializable {

    //Constants
    private static final String TAG = "activity_station_info.java";
    //Variables to make the coordinator layout
    private FloatingActionButton fab_button;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private MapView mapView;
    private Station station;
    private GoogleMap googleMap;
    //We go to change the color of the toolbar so
    private RecyclerView recyclerView;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_info);

        ChangeStyle style = new ChangeStyle(activity_station_info.this);

        //Getting intent
        Intent intent = getIntent();
        this.station = intent.getParcelableExtra("station");

        Log.i(TAG, "onCreate: " + station);
        Log.i(TAG, "onCreate: " + station.getServices());
        Log.i(TAG, "onCreate: " + station.getExits());
        //Getting a google map
        mapView = findViewById(R.id.google_map_station_info);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        mapView.onResume();

        //App bar
        Toolbar toolbar = findViewById(R.id.station_info_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(station.getName());

        recyclerView = findViewById(R.id.station_info_recycler_view);
        station.getElelments();
        AdapterStationsInfo adapterStationsInfo = new AdapterStationsInfo(station.getElelments());
        recyclerView.setAdapter(adapterStationsInfo);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, DividerItemDecoration.VERTICAL, false));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, UIElements.DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        fab_button = findViewById(R.id.station_info_fab);
        fab_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (googleMap.getMapType() != GoogleMap.MAP_TYPE_SATELLITE)
                    googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                else googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        //CollapsingToolbarLayout
        collapsingToolbarLayout = findViewById(R.id.station_info_collapsing_layout);
        collapsingToolbarLayout.setTitle(station.getName());

        //Changing the color
        style.setColorCollapsingToolbar(station.getLine().toLowerCase(), collapsingToolbarLayout);
        style.setColorWindow(station.getLine().toLowerCase(), getWindow());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        this.googleMap.addMarker(new MarkerOptions()
                .position(station.getLatLng())).setTitle(station.getName());
        this.googleMap.setMaxZoomPreference(19);
        this.googleMap.setIndoorEnabled(true);
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(station.getLatLng(), 18));
        ArrayList<LatLng> points = this.station.getNeighborhoodLatLng();
        for(int i = 0; i < points.size(); i++){
            googleMap.addMarker(new MarkerOptions().position(points.get(i)));
        }
    }

}
