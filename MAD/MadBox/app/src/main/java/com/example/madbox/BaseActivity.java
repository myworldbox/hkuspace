package com.example.madbox;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

//this class holds all reusable functions
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    //declare variables that used in more than two classes
    MediaPlayer mediaPlayer;
    Boolean darkMode = true;
    Boolean musicOn = true;
    String website = "";
    String PREFS_NAME = "";
    String text = "";
    String activity;
    String music = "";
    int random;
    Intent intent;

    @Override
    public void onClick(View v) {

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
        random = (int) (Math.random() * 9 + 1);
        music = "music" + random;
    }

    protected void MusicOn() {

            Resources resources = getResources();
            int sound = resources.getIdentifier(music, "raw", getPackageName());

            //play music in loop
            mediaPlayer = MediaPlayer.create(getApplicationContext(), sound);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
    }

    protected void MusicOff() {

        if (mediaPlayer != null) {

            //stop music when activity is paused
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    protected void Toast() {

        //prompt reminds for up-coming activity
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_style));

        TextView toastText = layout.findViewById(R.id.toast_text);
        toastText.setText(text);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}