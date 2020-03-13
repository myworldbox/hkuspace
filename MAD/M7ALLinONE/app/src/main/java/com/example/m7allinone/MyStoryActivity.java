package com.example.m7allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MyStoryActivity extends AppCompatActivity {

    VideoView vView; // to refer the videoview, for showing our story video

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_story);

        vView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(vView);
        vView.setMediaController(mediaController);
        vView.setKeepScreenOn(true);
        vView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mystoryv);
        vView.start();
    }
}
