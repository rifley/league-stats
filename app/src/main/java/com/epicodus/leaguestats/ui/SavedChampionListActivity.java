package com.epicodus.leaguestats.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.adapters.FirebaseChampionViewHolder;
import com.epicodus.leaguestats.models.Champion;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedChampionListActivity extends AppCompatActivity {
    private DatabaseReference mChampionReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_backpack);
        ButterKnife.bind(this);

        mChampionReference = FirebaseDatabase.getInstance().getReference("champions");
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Champion, FirebaseChampionViewHolder>
                (Champion.class, R.layout.champion_list_item, FirebaseChampionViewHolder.class,
                        mChampionReference) {

            @Override
            protected void populateViewHolder(FirebaseChampionViewHolder viewHolder,
                                              Champion model, int position) {
                viewHolder.bindChampion(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
        }
