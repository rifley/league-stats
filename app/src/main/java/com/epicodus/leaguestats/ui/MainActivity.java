package com.epicodus.leaguestats.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.epicodus.leaguestats.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.userButton) Button mUserButton;
    @Bind(R.id.leagueTextView) TextView mLeagueTextView;
    @Bind(R.id.backpackButton) ImageButton mBackpackButton;
    @Bind(R.id.userNameEditText)
    EditText mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface leagueFont = Typeface.createFromAsset(getAssets(), "fonts/league.ttf");

        ButterKnife.bind(this);

        mUserButton.setOnClickListener(this);
        mBackpackButton.setOnClickListener(this);
        mLeagueTextView.setTypeface(leagueFont);
    }

    @Override
    public void onClick(View v) {
        if(v == mUserButton) {
            String userName = mUserName.getText().toString();
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            intent.putExtra("name", userName);
            startActivity(intent);
        }
        if(v == mBackpackButton) {
            Intent intent = new Intent(MainActivity.this, BackpackActivity.class);
            startActivity(intent);
        }
    }
}
