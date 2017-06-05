package com.epicodus.leaguestats.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.models.Champion;
import com.epicodus.leaguestats.models.Summoner;
import com.epicodus.leaguestats.services.RiotService;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SummonerActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.summonerNameTextView)
    TextView mSummonerName;
    @Bind(R.id.championDetailButton)
    Button mChampionDetails;
    @Bind(R.id.backpackImageButton)
    ImageButton mBackpack;
    public ArrayList<Summoner> mSummoner = new ArrayList<>();
    public ArrayList<Champion> mChamps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summoner);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String summonerName = intent.getStringExtra("name");
        mSummonerName.setText(summonerName);

        mChampionDetails.setOnClickListener(this);
        mBackpack.setOnClickListener(this);


        getSummoner(summonerName);
        getChampion("2");
    }


    @Override
    public void onClick(View v) {

        if(v == mChampionDetails ) {
          Intent intent = new Intent(SummonerActivity.this, ChampionDetailActivity.class);
            intent.putExtra("champions", Parcels.wrap(mChamps));
            startActivity(intent);
        }
        else if(v == mBackpack ) {
            Intent intent = new Intent(SummonerActivity.this, BackpackActivity.class);
            startActivity(intent);
        }
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

            }
        });
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

            }
        });
    }
}
