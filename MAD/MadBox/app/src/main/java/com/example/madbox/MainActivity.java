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

        //Hide the navigation bar
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

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

        switch (view.getId()) {

            case R.id.button1:

                //Move to next page
                text = "Intro";
                Intent mySuperIntent = new Intent(MainActivity.this, Website1Activity.class);
                startActivity(mySuperIntent);

                break;
            case R.id.button2:
                text = "Game1";
                break;
            case R.id.button3:
                text = "Game2";
                break;
            case R.id.button4:
                text = "Game3";
                break;
            case R.id.button5:
                text = "Setting";
                break;

        }

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }
}
