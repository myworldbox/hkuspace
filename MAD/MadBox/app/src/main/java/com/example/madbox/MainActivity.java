package com.example.madbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;

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

        //Play music
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music2);
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onClick(View view) {

        String text = "";
        String website = "";
        String music = "";
        Intent mySuperIntent = new Intent(this, WebsiteActivity.class);

        switch (view.getId()) {

            case R.id.button1:

                //Move to next page
                text = "Intro";
                website = "https://myworldbox.github.io";
                music = "music3";

                break;

            case R.id.button2:

                text = "Game1";
                website = "file:///android_asset/test/controller.html";
                music = "music4";

                break;

            case R.id.button3:

                text = "Game2";
                website = "https://myworldbox.github.io/pong";
                music = "music5";

                break;

            case R.id.button4:

                text = "Game5";
                website = "file:///android_asset/test/snack.html";
                music = "music6";

                break;

            case R.id.button5:

                text = "Setting";
                website = "https://myworldbox.weebly.com";
                music = "music7";

                break;
        }

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        mySuperIntent.putExtra("key1",website);
        mySuperIntent.putExtra("key2",music);
        startActivity(mySuperIntent);
    }
}
