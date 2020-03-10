package com.example.madbox;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

//this class handles all activities related to menu
public class MainActivity extends BaseActivity {

    Button[] button = new Button[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //restore preferences
        SharedPreferences settings0 = this.getSharedPreferences(PREFS_NAME, 0);
        darkMode = settings0.getBoolean("key0", true);

        SharedPreferences settings1 = this.getSharedPreferences(PREFS_NAME, 1);
        musicOn = settings1.getBoolean("key1", true);

        SharedPreferences settings2 = this.getSharedPreferences(PREFS_NAME, 2);
        website = settings2.getString("key2", "");

        //retrieve selected mode
        if (darkMode) {

            //dark mode
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        } else {

            //light mode
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        RandMusic();

        //set content of buttons into arrays
        for (int i = 0; i < 5; i++) {

            String buttonID = "button" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            button[i] = findViewById(resourceID);
            button[i].setOnClickListener(this);
        }

        Switch switch0 = findViewById(R.id.Switch0);
        switch0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    text = "Mode: light";

                    //light mode
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                } else {

                    text = "Mode: dark";

                    //dark mode
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

                Toast();

                darkMode = !darkMode;

                //save music preferences
                SharedPreferences setting0 = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor0 = setting0.edit();
                editor0.putBoolean("key0", darkMode);
                editor0.apply();
            }
        });

        Switch switch1 = findViewById(R.id.Switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    text = "Music: off";

                    MusicOff();

                } else {

                    text = "Music: on";

                    MusicOn();
                }

                Toast();

                musicOn = !musicOn;

                //save music preferences
                SharedPreferences setting1 = getSharedPreferences(PREFS_NAME, 1);
                SharedPreferences.Editor editor1 = setting1.edit();
                editor1.putBoolean("key1", musicOn);
                editor1.apply();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        HideNav();
        MusicOn();
    }

    @Override
    protected void onPause() {
        super.onPause();

        MusicOff();
    }

    @Override
    public void onClick(View v) {

        //move to next activity depending on button clicked
        switch (v.getId()) {

            case R.id.button0:

                text = "About me";
                website = "file:///android_asset/myworldbox.github.io/index.html";
                activity = "com.example.madbox.WebsiteActivity";

                break;

            case R.id.button1:

                text = "Guidelines";
                website = "file:///android_asset/myworldbox.github.io/index.html";
                activity = "com.example.madbox.WebsiteActivity";

                break;

            case R.id.button2:

                text = "Pong";
                website = "https://myworldbox.github.io/pong";
                activity = "com.example.madbox.WebsiteActivity";

                break;

            case R.id.button3:

                text = "Lucky Arrow";
                activity = "com.example.madbox.LuckyArrowActivity";

                break;

            case R.id.button4:

                text = "Tic Tac Toe";
                activity = "com.example.madbox.TicTacToeActivity";

                break;
        }

        if (v.getId() == R.id.button0 || v.getId() == R.id.button1 || v.getId() == R.id.button2) {

            //save music setup to system
            SharedPreferences setting2 = getSharedPreferences(PREFS_NAME, 2);
            SharedPreferences.Editor editor2 = setting2.edit();
            editor2.putString("key2", website);
            editor2.apply();
        }

        Toast();

        try {

            //start webView related activity depending on button clicked
            intent = new Intent(this, Class.forName(activity));
            startActivity(intent);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }
}
