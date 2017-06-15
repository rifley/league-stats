package com.epicodus.leaguestats.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.models.Champion;
import com.epicodus.leaguestats.ui.ChampionDetailActivity;
import com.epicodus.leaguestats.util.ItemTouchHelperViewHolder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by riffee on 6/13/2017.
 */

public class FirebaseChampionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ItemTouchHelperViewHolder {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;
    public ImageView mChampionImageView;

    View mView;
    Context mContext;

    public FirebaseChampionViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindChampion(Champion champion) {
        mChampionImageView = (ImageView) mView.findViewById(R.id.championImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.championNameTextView);
        TextView titleTextView = (TextView) mView.findViewById(R.id.championTitleTextView);
        TextView viewStatsTextView = (TextView) mView.findViewById(R.id.viewStatsTextView);

        Picasso.with(mContext)
                .load(champion.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mChampionImageView);



        nameTextView.setText(champion.getName());
        titleTextView.setText(champion.getTitle());
    }

    public void onClick(View view) {
        final ArrayList<Champion> champions = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("champions");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    champions.add(snapshot.getValue(Champion.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, ChampionDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("champions", Parcels.wrap(champions));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void onItemSelected() {
        itemView.animate()
                .alpha(0.7f)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(500);
    }

    @Override
    public void onItemClear() {
        itemView.animate()
                .alpha(0.7f)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(500);
    }
}