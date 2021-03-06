package com.epicodus.leaguestats.adapters;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.epicodus.leaguestats.models.Champion;
import com.epicodus.leaguestats.ui.ChampionDetailFragment;
import com.epicodus.leaguestats.util.ItemTouchHelperAdapter;
import com.epicodus.leaguestats.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;

/**
 * Created by Guest on 6/14/17.
 */

public class FirebaseChampionListAdapter extends FirebaseRecyclerAdapter<Champion, FirebaseChampionViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private ArrayList<Champion> mChampions = new ArrayList<>();

    public FirebaseChampionListAdapter(Class<Champion> modelClass, int modelLayout, Class<FirebaseChampionViewHolder> viewHolderClass, Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        getRef(position).removeValue();
    }

    @Override
    protected void populateViewHolder(final FirebaseChampionViewHolder viewHolder, Champion model, int position) {
        viewHolder.bindChampion(model);
        viewHolder.mChampionImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(viewHolder);
                }
                return false;
            }
        });

//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent.(mContext, ChampionDetailActivity.class);
//                intent.putExtra("position", viewHolder.getAdapterPosition());
//                intent.putExtra("champions", Parcels.wrap(mCh))
//            }
//        })
    }
}
