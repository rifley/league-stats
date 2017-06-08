package com.epicodus.leaguestats.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.epicodus.leaguestats.Constants;
import com.epicodus.leaguestats.adapters.BackpackArrayAdapter;
import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.models.Champion;
import com.epicodus.leaguestats.services.RiotService;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class BackpackActivity extends AppCompatActivity {
    private ListView mChampionArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backpack);

        mChampionArray = (ListView) findViewById(R.id.championArray);

        BackpackArrayAdapter adapter = new BackpackArrayAdapter(this, android.R.layout.simple_list_item_1, Constants.Champions, Constants.ChampionId);
        mChampionArray.setAdapter(adapter);

    }


}

