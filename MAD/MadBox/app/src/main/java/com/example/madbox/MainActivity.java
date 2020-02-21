package com.example.madbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;
    Boolean Music;
    String text = "";
    String website = "";
    String music = "";

    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

        //restore preferences
        SharedPreferences settings = this.getSharedPreferences(PREFS_NAME, 0);
        Music = settings.getBoolean("key3", true);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Hide the navigation bar
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        MusicOn();
    }

    protected void MusicOn() {

        if (Music) {
            //Play music
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music2);
            mediaPlayer.start();
        }
    }

    protected void MusicOff() {

        //Stop music when activity is paused
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    protected void onPause() {
        super.onPause();

        MusicOff();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button1:

                //Move to next page
                text = "About";
                website = "https://myworldbox.github.io";
                music = "music3";

                break;

            case R.id.button2:

                text = "Game1";
                website = "https://myworldbox.github.io/pong";
                music = "music4";

                break;

            case R.id.button3:

                text = "Game2";
                website = "https://myworldbox.github.io/snake";
                music = "music5";

                break;

            case R.id.button4:

                text = "Game5";
                website = "https://myworldbox.github.io/test";
                music = "music6";

                break;

            case R.id.button5:

                text = "Music: on";
                //website = "file:///android_asset/test/controller";

                if (Music) {

                    Music = false;
                    MusicOff();

                } else {

                    Music = true;
                    MusicOn();
                }


                //change button text
                Button button = findViewById(R.id.button5);
                button.setText(text);

                //save music setup to system
                SharedPreferences settings = this.getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("key3", Music);
                editor.apply();

                break;
        }

        if (view.getId() != R.id.button5) {

            //Prompts
            Toast toast = Toast.makeText(this, text, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

            Intent intent = new Intent(this, WebsiteActivity.class);
            //Pass values to other activity
            intent.putExtra("key1", website);
            intent.putExtra("key2", music);
            startActivity(intent);
        }
    }
}
