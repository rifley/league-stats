package com.epicodus.leaguestats.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.epicodus.leaguestats.R;

import org.apache.http.protocol.HTTP;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.emailTextViewLink) TextView mEmailTextViewLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ButterKnife.bind(this);
        mEmailTextViewLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mEmailTextViewLink) {
            Uri webpage = Uri.parse("https://www.linkedin.com/in/rileywhat");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);
        }
    }
}
