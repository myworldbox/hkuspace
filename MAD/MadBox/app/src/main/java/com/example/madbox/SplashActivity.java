package com.example.madbox;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

//this class contains the logic of splash screen
public class SplashActivity extends MainActivity {

    int splashTime = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        HideNav();

        //start timer and take action after timer ends
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //move to next activity
                intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, splashTime);
    }

    @Override
    protected void onResume() {
        super.onResume();

        MusicOff();
    }
}
