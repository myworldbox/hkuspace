package com.example.m8finalsys;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SetTwoActivity extends AppCompatActivity {
	
	public void setAnimation(){
		// Set the background (of view, image) with the AnimationDrawable object, and start
		((ImageView) findViewById(R.id.imageView)).setBackgroundResource(R.drawable.fganim);
		((AnimationDrawable) ((ImageView) findViewById(R.id.imageView)).getBackground()).start();
		// Set the background (of view, layout) with the AnimationDrawable object, and start
		((ConstraintLayout) findViewById(R.id.cLayout)).setBackgroundResource(R.drawable.bganim);
		((AnimationDrawable) ((ConstraintLayout) findViewById(R.id.cLayout)).getBackground()).start();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_set_two);
		setAnimation();
	}
	
}