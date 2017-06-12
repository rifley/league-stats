package com.epicodus.leaguestats.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.models.Champion;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ChampionDetailFragment extends Fragment {
    @Bind(R.id.championImageView) ImageView mChampionImage;
    @Bind(R.id.championNameTextView) TextView mChampionName;
    @Bind(R.id.championTitleTextView) TextView mChampionTitle;
    @Bind(R.id.baseArmorTextView) TextView mBaseArmor;
    @Bind(R.id.baseHealthTextView) TextView mBaseHealth;
    @Bind(R.id.baseMagicResistTextView) TextView mBaseMagicResist;
    @Bind(R.id.attackDamageTextView) TextView mAttackDamage;
    @Bind(R.id.healthLvlTextView) TextView mHealthLvl;
    @Bind(R.id.armorLvlTextView) TextView mArmorLvl;
    @Bind(R.id.magicResistLvlTextView) TextView mResistLvl;
    @Bind(R.id.moveSpeedTextView) TextView mSpeed;

    private Champion mChampion;

    public static ChampionDetailFragment newInstance(Champion champion) {
        ChampionDetailFragment championDetailFragment = new ChampionDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("champion", Parcels.wrap(champion));
        championDetailFragment.setArguments(args);
        return championDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mChampion = Parcels.unwrap(getArguments().getParcelable("champion"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_champion_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mChampion.getImageUrl()).into(mChampionImage);

        mChampionName.setText(mChampion.getName());
        mChampionTitle.setText(mChampion.getTitle());
        mBaseArmor.setText("Base Armor: " + mChampion.getArmor());
        mBaseHealth.setText("Base Health: " + mChampion.getHealthPoints());
        mBaseMagicResist.setText("Base Magic Resist: " + mChampion.getMagicResist());
        mAttackDamage.setText("Attack Damage: " + mChampion.getAttack());
        mHealthLvl.setText("Health Per Lvl: " + mChampion.getHealthLvl());
        mArmorLvl.setText("Armor Per Lvl: " + mChampion.getArmorLvl());
        mResistLvl.setText("Resist Per Lvl: " + mChampion.getMagicResistLvl());
        mSpeed.setText("Move Speed: " + mChampion.getMoveSpeed());



        return view;
    }

}
