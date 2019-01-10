package com.example.erick.adooproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

import Adapters.AdapterLines;
import Objects.Line;
import UIElements.ChangeStyle;
import UIElements.DividerItemDecoration;

public class LinesActivity extends AppCompatActivity {

    //Constants
    private static final String TAG = "LinesActivity.java";

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lines);
        //Getting toolbar element
        Toolbar toolbar = findViewById(R.id.activity_lines_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        ChangeStyle style = new ChangeStyle(LinesActivity.this);

        style.setColorWindow("colorPrimaryDark", getWindow());
        style.setColorToolbar("colorPrimary", toolbar);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        ArrayList<Line> lines = intent.getParcelableArrayListExtra("Lines");
        toolbar.setTitle("Líneas del " + title);
        setSupportActionBar(toolbar);
        for (int i = 0; i < lines.size(); i++)
            Log.i(TAG, "onCreate: lines.getWhichLine " + lines.get(i).getWhichLine());

        RecyclerView recyclerView = findViewById(R.id.activity_lines_recycler_view);

        AdapterLines adapterLines = new AdapterLines(lines, LinesActivity.this, title);
        recyclerView.setAdapter(adapterLines);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, android.support.v7.widget.DividerItemDecoration.VERTICAL, false));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}
