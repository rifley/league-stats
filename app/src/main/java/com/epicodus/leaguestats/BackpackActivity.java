package com.epicodus.leaguestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;

public class BackpackActivity extends AppCompatActivity {
    private ListView mChampionArray;

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
