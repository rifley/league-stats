package com.epicodus.leaguestats.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.models.Champion;
import com.epicodus.leaguestats.ui.ChampionDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by riffee on 6/13/2017.
 */

public class ChampionListAdapter extends RecyclerView.Adapter<ChampionListAdapter.ChampionViewHolder>{
    private ArrayList<Champion> mChampions = new ArrayList<>();
    private Context mContext;

    public ChampionListAdapter(Context context, ArrayList<Champion> champions) {
        mContext = context;
        mChampions = champions;
    }

    @Override
    public ChampionListAdapter.ChampionViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.champion_list_item, parent, false);
        ChampionViewHolder viewHolder = new ChampionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChampionListAdapter.ChampionViewHolder holder, int position) {
        holder.bindChampion(mChampions.get(position));
    }

    @Override
    public int getItemCount() {
        return mChampions.size();
    }

    public class ChampionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.championNameTextView) TextView mChampionNameTextView;
        @Bind(R.id.championTitleTextView) TextView mChampionTitleTextView;
        @Bind(R.id.viewStatsTextView) TextView mViewStatsTextView;
        @Bind(R.id.championImageView) ImageView mChampionImageView;

        private Context mContext;

        public ChampionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, ChampionDetailActivity.class);
            intent.putExtra("position", itemPosition + "0");
            intent.putExtra("cameFrom", "adapter");
            intent.putExtra("champions", Parcels.wrap(mChampions));
            mContext.startActivity(intent);
        }

        public void bindChampion(Champion champion) {
            mChampionNameTextView.setText(champion.getName());
            mChampionTitleTextView.setText(champion.getTitle());

        }

    }
}
