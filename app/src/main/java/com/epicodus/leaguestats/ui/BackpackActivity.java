//package com.epicodus.leaguestats.ui;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.RecyclerView;
//import android.widget.ListView;
//
//import com.epicodus.leaguestats.Constants;
//import com.epicodus.leaguestats.adapters.BackpackArrayAdapter;
//import com.epicodus.leaguestats.R;
//import com.epicodus.leaguestats.adapters.ChampionListAdapter;
//import com.epicodus.leaguestats.models.Champion;
//import com.epicodus.leaguestats.services.RiotService;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.Response;
//
//public class BackpackActivity extends AppCompatActivity {
//    private ListView mChampionArray;
//
//    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
//    private ChampionListAdapter mAdapter;
//
//    public ArrayList<Champion> mChampion = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_backpack);
//        ButterKnife.bind(this);



//        mChampionArray = (ListView) findViewById(R.id.championArray);
//
//        BackpackArrayAdapter adapter = new BackpackArrayAdapter(this, android.R.layout.simple_list_item_1, Constants.Champions, Constants.ChampionId);
//        mChampionArray.setAdapter(adapter);






