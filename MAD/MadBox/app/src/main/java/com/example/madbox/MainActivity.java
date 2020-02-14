package com.example.madbox;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("SetJavaScriptEnabled")
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
                music = "music1";

                break;

            case R.id.button2:

                text = "Game1";
                website = "file:///android_asset/test/controller.html";
                music = "music2";

                break;

            case R.id.button3:

                text = "Game2";
                website = "file:///android_asset/test/pong.html";
                music = "music3";

                break;

            case R.id.button4:

                text = "Game3";
                website = "file:///android_asset/test/snack.html";
                music = "music4";

                break;

            case R.id.button5:

                text = "Setting";
                website = "file:///android_asset/myworldbox.github.io/index.html";
                music = "music5";

                break;
        }

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        mySuperIntent.putExtra("key1",website);
        mySuperIntent.putExtra("key2",music);
        startActivity(mySuperIntent);
    }
}
