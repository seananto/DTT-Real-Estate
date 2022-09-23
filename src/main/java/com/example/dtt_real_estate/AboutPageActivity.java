package com.example.dtt_real_estate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutPageActivity extends AppCompatActivity {
    // declare variables
    ImageView toolbar;
    ImageView homeButton;
    ImageView infoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        // design the about page
        // initialize variables
        toolbar = findViewById(R.id.iv_toolbar);
        homeButton = findViewById(R.id.iv_home_button);
        infoButton = findViewById(R.id.iv_info_button);

        // set onClickListener to handle click events with buttons
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // when user clicks on home button in toolbar, call the method here below
                SwitchToOverviewActivity();
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // when user clicks on info button in toolbar, call the method here below
                SwitchToAboutPageActivity();
            }
        });
    }
    private void SwitchToOverviewActivity(){
        Intent switchActivityIntent = new Intent(this, OverviewActivity.class);
        startActivity(switchActivityIntent);
        finish();
    }

    private void SwitchToAboutPageActivity(){
        Intent switchActivityIntent = new Intent(this, AboutPageActivity.class);
        startActivity(switchActivityIntent);
        finish();
    }
}

