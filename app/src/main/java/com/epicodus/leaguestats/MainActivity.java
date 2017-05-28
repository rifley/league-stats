package com.epicodus.leaguestats;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.excitedButton) Button mExcitedButton;
    @Bind(R.id.leagueTextView) TextView mLeagueTextView;
    @Bind(R.id.backpackButton) ImageButton mBackpackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface leagueFont = Typeface.createFromAsset(getAssets(), "fonts/league.ttf");

        ButterKnife.bind(this);

        mExcitedButton.setOnClickListener(this);
        mBackpackButton.setOnClickListener(this);
        mLeagueTextView.setTypeface(leagueFont);
    }

    @Override
    public void onClick(View v) {
        if(v == mExcitedButton) {
          Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        if(v == mBackpackButton) {
            Intent intent = new Intent(MainActivity.this, BackpackActivity.class);
            startActivity(intent);
        }
    }
}
