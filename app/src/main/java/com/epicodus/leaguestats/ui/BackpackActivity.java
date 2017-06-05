package com.epicodus.leaguestats.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
    public ArrayList<Champion> mChampions = new ArrayList<>();



    private String[] champions = new String[] {"Annie", "Gangplank", "Kha'zix", "Brand", "Ashe", "Tryndamere", "Bard", "Gragas", "Graves", "Lucian", "Blitzcrank", "Thresh", "Ekko", "Maokai", "Gnar"};

    private String[] roles = new String[] {"Mage", "Fighter", "Assassin", "Mage", "Carry", "Carry", "Support", "Fighter", "Fighter", "Carry", "Support", "Support", "Assassin", "Tank", "Tank"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backpack);

        mChampionArray = (ListView) findViewById(R.id.championArray);

        BackpackArrayAdapter adapter = new BackpackArrayAdapter(this, android.R.layout.simple_list_item_1, champions, roles);
        mChampionArray.setAdapter(adapter);

    }


}

