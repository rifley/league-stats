package com.epicodus.leaguestats.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.leaguestats.R;
import com.epicodus.leaguestats.models.Champion;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ChampionDetailFragment extends Fragment implements View.OnClickListener {
    private ImageView mChampionImage;
    private TextView mChampionName;
    private TextView mChampionTitle;
    private TextView mBaseArmor;
    private TextView mBaseHealth;
    private TextView mBaseMagicResist;
    private TextView mAttackDamage;
    private TextView mHealthLvl;
    private TextView mArmorLvl;
    private TextView mResistLvl;
    private TextView mSpeed;
    @Bind(R.id.saveChampionButton) Button mSaveChampionButton;

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
        mChampionImage = (ImageView) view.findViewById(R.id.championImageView);
        mChampionName = (TextView) view.findViewById(R.id.championNameTextView);
        mChampionTitle = (TextView) view.findViewById(R.id.championTitleTextView);
        mBaseArmor = (TextView) view.findViewById(R.id.baseArmorTextView);
        mBaseHealth = (TextView) view.findViewById(R.id.baseHealthTextView);
        mBaseMagicResist = (TextView) view.findViewById(R.id.baseMagicResistTextView);
        mAttackDamage = (TextView) view.findViewById(R.id.attackDamageTextView);
        mHealthLvl = (TextView) view.findViewById(R.id.healthLvlTextView);
        mArmorLvl = (TextView) view.findViewById(R.id.armorLvlTextView);
        mResistLvl = (TextView) view.findViewById(R.id.magicResistLvlTextView);
        mSpeed = (TextView) view.findViewById(R.id.moveSpeedTextView);


        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mChampion.getImageUrl()).into(mChampionImage);

        mChampionName.setText(mChampion.getName());
        mChampionTitle.setText(mChampion.getTitle());
        mBaseArmor.setText("Base Armor: " + mChampion.getBaseArmor().toString());
        mBaseHealth.setText("Base Health: " + mChampion.getBaseHealthPoints());
        mBaseMagicResist.setText("Base Magic Resist: " + mChampion.getBaseMagicResist());
        mAttackDamage.setText("Attack Damage: " + mChampion.getBaseAttackDamage());
        mHealthLvl.setText("Health Per Lvl: " + mChampion.getHpPerLevel());
        mArmorLvl.setText("Armor Per Lvl: " + mChampion.getArmorPerLevel());
        mResistLvl.setText("Resist Per Lvl: " + mChampion.getMagicResistPerLevel());
        mSpeed.setText("Move Speed: " + mChampion.getMoveSpeed());

        mSaveChampionButton.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mSaveChampionButton) {
            DatabaseReference championRef = FirebaseDatabase
                    .getInstance()
                    .getReference("champions");
            championRef.push().setValue(mChampion);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
