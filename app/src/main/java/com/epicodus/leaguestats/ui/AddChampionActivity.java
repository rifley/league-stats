package com.epicodus.leaguestats.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.models.Champion;
import com.epicodus.leaguestats.services.RiotService;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AddChampionActivity extends AppCompatActivity {
    public ArrayList<Champion> mChamps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_champion);

        getChampion("2");
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

//                BackpackActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                });
            }
        });
    }
}
