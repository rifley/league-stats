package com.epicodus.leaguestats.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.models.Champion;
import com.epicodus.leaguestats.services.RiotService;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoadingActivity extends AppCompatActivity {
    public ArrayList<Champion> mChamps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Intent intent = getIntent();
        String championId = intent.getStringExtra("champId");

        getChampion(championId);
        finish();
    }

    private void getChampion(String id) {
        final RiotService riotService = new RiotService();
        riotService.findChampion(id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) {
                mChamps = riotService.processStats(response);
                Intent intent = new Intent(LoadingActivity.this, ChampionDetailActivity.class);
                intent.putExtra("champions", Parcels.wrap(mChamps));
                startActivity(intent);
            }
        });
    }
}
