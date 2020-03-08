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

//this class handles all activities related to menu
public class MainActivity extends BaseActivity {

    Button[] button = new Button[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //restore preferences
        SharedPreferences settings0 = this.getSharedPreferences(PREFS_NAME, 0);
        musicOn = settings0.getString("key0", "Music: on");

        SharedPreferences settings1 = this.getSharedPreferences(PREFS_NAME, 1);
        website = settings1.getString("key1", "");

        RandMusic();

        //set content of buttons into arrays
        for (int i = 0; i < 5; i++) {

            String buttonID = "button" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            button[i] = findViewById(resourceID);
            button[i].setOnClickListener(this);
        }

        //change button text according to user's preference on music
        TextView button = findViewById(R.id.Music);
        button.setText(musicOn);

        @SuppressLint("CutPasteId") Switch sound = findViewById(R.id.Music);
        sound.setChecked(true); // set the switch as Checked (ON) initially
        sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //adjust music setting
                if (musicOn.equals("Music: on")) {

                    musicOn = "Music: off";
                    MusicOff();

                } else {

                    musicOn = "Music: on";
                    MusicOn();
                }

                text = musicOn;

                //change button text depending on button clicked
                TextView button = findViewById(R.id.Music);
                button.setText(musicOn);

                //save music setup to system
                SharedPreferences setting0 = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor0 = setting0.edit();
                editor0.putString("key0", musicOn);
                editor0.apply();
            }
        }
        );
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
            SharedPreferences setting1 = getSharedPreferences(PREFS_NAME, 1);
            SharedPreferences.Editor editor1 = setting1.edit();
            editor1.putString("key1", website);
            editor1.apply();
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
