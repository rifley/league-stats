package com.epicodus.leaguestats.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.adapters.ChampionPagerAdapter;
import com.epicodus.leaguestats.models.Champion;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChampionDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private ChampionPagerAdapter adapterViewPager;
    ArrayList<Champion> mChampions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_detail);
        ButterKnife.bind(this);

        mChampions = Parcels.unwrap(getIntent().getParcelableExtra("champions"));
        try {
            Integer startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
            adapterViewPager = new ChampionPagerAdapter(getSupportFragmentManager(), mChampions);
            mViewPager.setAdapter(adapterViewPager);
            mViewPager.setCurrentItem(startingPosition);
        }
        catch (NumberFormatException e){
            adapterViewPager = new ChampionPagerAdapter(getSupportFragmentManager(), mChampions);
            mViewPager.setAdapter(adapterViewPager);
        }

    }
}
