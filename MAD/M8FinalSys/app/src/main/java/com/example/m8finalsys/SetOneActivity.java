package com.example.m8finalsys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class SetOneActivity extends AppCompatActivity {
    int clickNo = 0; // a field, for the number of clicking
    @SuppressLint("SetTextI18n")
    public void btnClick(View view){ // a method to handle button click, defined in xml file
        ((Button)view).setText("MAD BUTTON CLICKED:\n" + ++clickNo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_set_one);
    }
}
