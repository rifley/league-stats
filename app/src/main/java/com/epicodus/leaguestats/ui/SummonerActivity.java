package com.epicodus.leaguestats.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.models.Champion;
import com.epicodus.leaguestats.models.Summoner;
import com.epicodus.leaguestats.services.RiotService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SummonerActivity extends AppCompatActivity {
    @Bind(R.id.summonerNameTextView)
    TextView mSummonerName;
    public ArrayList<Summoner> mSummoner = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summoner);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String summonerName = intent.getStringExtra("name");
        mSummonerName.setText(summonerName);

        getSummoner(summonerName);
    }

    private void getSummoner(String name) {
        final RiotService riotService = new RiotService();
        riotService.findSummoner(name, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) {
                mSummoner = riotService.processSummoner(response);
                Long summonerId = mSummoner.get(0).getId();

                Log.d("summoner id", summonerId.toString());


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
