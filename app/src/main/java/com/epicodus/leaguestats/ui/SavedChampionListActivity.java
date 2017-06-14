package com.epicodus.leaguestats.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.adapters.FirebaseChampionListAdapter;
import com.epicodus.leaguestats.adapters.FirebaseChampionViewHolder;
import com.epicodus.leaguestats.models.Champion;
import com.epicodus.leaguestats.util.OnStartDragListener;
import com.epicodus.leaguestats.util.SimpleItemTouchHelperCallback;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedChampionListActivity extends AppCompatActivity implements OnStartDragListener{
    private DatabaseReference mChampionReference;
    private FirebaseChampionListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_backpack);
        ButterKnife.bind(this);

        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {

        mChampionReference = FirebaseDatabase
                .getInstance()
                .getReference("champions");


        mFirebaseAdapter = new FirebaseChampionListAdapter(Champion.class,
                R.layout.champion_list_item_drag, FirebaseChampionViewHolder.class,
                mChampionReference, this, this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
