package com.example.madbox;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class SpinTheArrowActivity extends BaseActivity {

    ImageView arrow;
    Random random = new Random();
    int lastDir;
    boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin_the_arrow);

        arrow = findViewById(R.id.arrow);
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

    public void spinBottle(View v) {

        if (!spinning) {

            int newDir = random.nextInt(1800);
            float pivotX = arrow.getWidth() / 2;
            float pivotY = arrow.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            rotate.setDuration(7000);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) { }
            });

            lastDir = newDir;
            arrow.startAnimation(rotate);
        }
    }
}