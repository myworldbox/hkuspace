package com.example.madbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//this class handles all activities related to menu
public class MainActivity extends BaseActivity {

    Button[] button = new Button[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetKey();

        //set content of buttons into arrays
        for (int i = 0; i < 5; i++) {

            String buttonID = "button" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            button[i] = findViewById(resourceID);
            button[i].setOnClickListener(this);
        }

        //change button text according to user's preference on music
        Button button = findViewById(R.id.button4);
        button.setText(musicOn);
    }

    @Override
    protected void onResume() {
        super.onResume();

        HideNav();
        RandMusic();
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

                text = "About";
                website = "file:///android_asset/myworldbox.github.io/index.html";

                break;

            case R.id.button1:

                text = "Pong";
                website = "https://myworldbox.github.io/pong";

                break;

            case R.id.button2:

                text = "Snake";
                website = "https://myworldbox.github.io/snake";

                break;

            case R.id.button3:

                text = "Tic Tac Toe";

                //move to non webView activity
                Intent intent = new Intent(this, TicTacToeActivity.class);
                startActivity(intent);

                break;

            case R.id.button4:

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
                Button button = findViewById(R.id.button4);
                button.setText(musicOn);

                //save music setup to system
                SharedPreferences settings = this.getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("key3", musicOn);
                editor.apply();

                break;
        }

        Toast();

        //start webView related activity depending on button clicked
        if (v.getId() != R.id.button3 && v.getId() != R.id.button4) {

            RandMusic();

            //pass values to other activity
            Intent intent = new Intent(this, WebsiteActivity.class);
            intent.putExtra("key1", website);
            intent.putExtra("key2", music);
            startActivity(intent);
        }
    }
}
