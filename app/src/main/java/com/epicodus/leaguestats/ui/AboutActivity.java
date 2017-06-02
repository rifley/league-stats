package com.epicodus.leaguestats.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.epicodus.leaguestats.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity {
    @Bind(R.id.userNameTextView)
    TextView mUserNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");
        mUserNameTextView.setText(userName);
    }
}
