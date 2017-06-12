package com.epicodus.leaguestats.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.leaguestats.Constants;
import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.models.Champion;
import com.epicodus.leaguestats.models.Summoner;
import com.epicodus.leaguestats.services.RiotService;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SummonerActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.summonerNameTextView) TextView mSummonerName;
    @Bind(R.id.championDetailButton) Button mChampionDetails;
    @Bind(R.id.backpackImageButton) ImageButton mBackpack;
    @Bind(R.id.championCompleteTextView) AutoCompleteTextView mChampionSearch;

    private SharedPreferences mSharedPreferences;
    private String mUserName;
    public ArrayList<Summoner> mSummoner = new ArrayList<>();
    public ArrayList<Champion> mChamps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summoner);

        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mUserName = mSharedPreferences.getString("userName", null);
        mSummonerName.setText(mUserName);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, Constants.Champions);
        mChampionSearch.setAdapter(adapter);

        mChampionDetails.setOnClickListener(this);
        mBackpack.setOnClickListener(this);


        getSummoner(mUserName);
    }


    @Override
    public void onClick(View v) {

        if(v == mChampionDetails ) {
            String championName = mChampionSearch.getText().toString();
            if(!Arrays.asList(Constants.Champions).contains(championName)) {
                mChampionSearch.setError("Champion not found. Please retry");
            }
            else{

                int position = Arrays.asList(Constants.Champions).indexOf(championName);
                String championPosition = Arrays.asList(Constants.ChampionId).get(position);
                Intent intent = new Intent(SummonerActivity.this, LoadingActivity.class);
                intent.putExtra("champId", championPosition);
                startActivity(intent);

            }
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
