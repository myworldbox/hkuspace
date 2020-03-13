package com.example.m8finalsys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toSetOne(View view){
        startActivity(new Intent(this, SetOneActivity.class));//start Activity via intent
    }

    public void toSetTwo(View view){
        startActivity(new Intent(this, SetTwoActivity.class));//start Activity via intent
    }
}
