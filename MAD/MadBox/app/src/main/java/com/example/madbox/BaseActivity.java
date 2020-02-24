package com.example.madbox;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//This class holds all reusable function
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    //declare variables that used in more than two classes
    MediaPlayer mediaPlayer;
    String text = "";
    String website = "";
    String music = "";
    Boolean musicOn = true;

    public static final String PREFS_NAME = "0";

    @Override
    public void onClick(View v) {

    }

    protected void GetKey() {

        //get values from other activity
        Intent intent = getIntent();
        website = intent.getStringExtra("key1");
        music = intent.getStringExtra("key2");

        //restore preferences
        SharedPreferences settings = this.getSharedPreferences(PREFS_NAME, 0);
        musicOn = settings.getBoolean("key3", true);
    }

    protected void HideNav() {

        //hide the navigation bar
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    protected void RandMusic() {

        //choose music to play randomly
        int random = (int)(Math.random() * 8 + 1);
        music = "music"+ random;
    }

    protected void MusicOn() {

        if (musicOn) {

            Resources resources = getResources();
            int sound = resources.getIdentifier(music, "raw", getPackageName());

            //play music in loop
            mediaPlayer = MediaPlayer.create(getApplicationContext(), sound);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }

    protected void MusicOff() {

        //stop music when activity is paused
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    protected void Toast() {

        //prompt reminds for up-coming activity
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
