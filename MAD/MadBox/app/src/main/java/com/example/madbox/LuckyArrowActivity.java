package com.example.madbox;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

//this class contains game logic of Lucky Arrow
public class LuckyArrowActivity extends MainActivity {

    //declare variables that used in more than two classes
    ImageView imageView;
    ImageView arrow;
    int oldPlace;
    boolean spinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_arrow);

        arrow = findViewById(R.id.arrow);
    }

    @Override
    protected void onResume() {
        super.onResume();

        RotateImage();
    }

    public void RotateImage() {

        //animate rotation of background image
        RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setDuration(60000);

        //simple scaling the background image view
        imageView = findViewById(R.id.imageView);
        imageView.setScaleX(3);
        imageView.setScaleY(3);

        //start animating (rotating) the background image view
        imageView.startAnimation(rotateAnimation);
    }

    public void SpinArrow(View v) {

        //avoid clicking when arrow is spinning
        if (!spinning) {

            random = (int)(Math.random() * 7000 + 1000);

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

                    MusicOff();
                    RandMusic();
                    MusicOn();
                }

                @Override
                public void onAnimationRepeat(Animation animation) { }
            });

            oldPlace = random;
            arrow.startAnimation(rotate);
        }
    }
}