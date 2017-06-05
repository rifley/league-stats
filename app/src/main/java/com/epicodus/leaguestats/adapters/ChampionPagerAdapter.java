package com.epicodus.leaguestats.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.leaguestats.models.Champion;
import com.epicodus.leaguestats.ui.ChampionDetailFragment;

import java.util.ArrayList;

/**
 * Created by riffee on 6/4/2017.
 */

public class ChampionPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Champion> mChampions;

    public ChampionPagerAdapter(FragmentManager fm, ArrayList<Champion> champions) {
        super(fm);
        mChampions = champions;
    }

    @Override
    public Fragment getItem(int position) {
        return ChampionDetailFragment.newInstance(mChampions.get(position));
    }

    @Override
    public int getCount() {
        return mChampions.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mChampions.get(position).getName();
    }
}
