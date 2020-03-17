package com.example.madbox;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

//this class contains game logic of Lucky Arrow
public class LuckyArrowActivity extends MainActivity {

    //declare variables that used in more than two classes
    ImageView arrow;
    int oldPlace;
    boolean spinning;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_arrow);

        arrow = findViewById(R.id.arrow);
    }

    public void SpinArrow(View v) {

        //avoid clicking when arrow is spinning
        if (!spinning) {

            random = (int) (Math.random() * 7000 + 1000);

            //define pivots for spinning
            int pivotX = arrow.getWidth() / 2;
            int pivotY = arrow.getHeight() / 2;

            Animation rotate = new RotateAnimation(oldPlace, random, pivotX, pivotY);
            rotate.setDuration(random);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {

                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    spinning = false;
                    text = "It is you!";

                    Toast();
                    MusicOff();
                    RandMusic();
                    MusicOn();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });

            oldPlace = random;
            arrow.startAnimation(rotate);
        }
    }
}