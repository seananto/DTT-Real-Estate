package com.example.dtt_real_estate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class SplashScreenActivity extends AppCompatActivity {
    // views
    ImageView splashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        splashScreen = findViewById(R.id.iv_splash_screen);
        // add an onClicklistener to handle the click event when user clicks on splash screen
        splashScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // call the switchActivity method so when clicked
                // user will be taken to next Activity
                switchActivity();
            }
        });

        // switch from this activity to the main activity
        // need to set the intent
        // need to make the view clickable so that
        // need to reference the resources at the top of the class
        // need to initialize the variables at the top of the class
        // assign the initialized variables a value when referencing in a method


    }
    // method that takes you from the splashScreen activity to the main activity
    private void switchActivity(){
        Intent switchActivityIntent = new Intent(this, OverviewActivity.class);
        startActivity(switchActivityIntent);
        finish();

    }
}