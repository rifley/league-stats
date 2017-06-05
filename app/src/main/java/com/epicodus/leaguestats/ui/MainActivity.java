package com.epicodus.leaguestats.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.epicodus.leaguestats.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.getStartedButton) Button mUserButton;
    @Bind(R.id.leagueTextView) TextView mLeagueTextView;

    @Bind(R.id.summonerNameEditText)
    AutoCompleteTextView mSummonerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface leagueFont = Typeface.createFromAsset(getAssets(), "fonts/league.ttf");

        ButterKnife.bind(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, CHAMPIONS);
        mSummonerName.setAdapter(adapter);

        mUserButton.setOnClickListener(this);
        mLeagueTextView.setTypeface(leagueFont);
    }

    private static final String[] CHAMPIONS = new String[] {
            "Gragas", "Graves", "Brand", "Olaf"
    };

    @Override
    public void onClick(View v) {
        if(v == mUserButton) {
            String userName = mSummonerName.getText().toString();
            if(userName.length() == 0 ) {
                mSummonerName.setError( "Summoner Name Required!");
            }
            else {
                Intent intent = new Intent(MainActivity.this, SummonerActivity.class);
                intent.putExtra("name", userName);
                startActivity(intent);
            }
        }
//        if(v ==  ) {
//            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
//            startActivity(intent);
//        }
    }
}
