package com.epicodus.leaguestats;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by riffee on 5/29/2017.
 */

public class BackpackArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mChampions;
    private String[] mRole;

    public BackpackArrayAdapter(Context mContext, int resource, String[] mChampions, String[] mRole) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mChampions = mChampions;
        this.mRole= mRole;
    }

    @Override
    public Object getItem(int position) {
        String champion = mChampions[position];
        String role = mRole[position];
        return String.format("-  %s  - \n   %s ", champion, role);
    }

    @Override
    public int getCount() {
        return mChampions.length;
    }
}
