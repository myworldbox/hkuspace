package com.example.m7allinone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ///////////// START - Button Click to Diff. Activity Screens ////////////////
    public void butClicked(View view) {
        startActivity(new Intent(this, MyStoryActivity.class)); //start new Activity
    }

    public void but2Clicked(View view) {
        startActivity(new Intent(this, AboutMeActivity.class)); //start new Activity }
///////////// END - Button Click to Diff. Activity Screens ////////////////
    }
        @Override
        public void onBackPressed () { // Called when user's press of BACK key detected
/////////////////// Alert User to leave (Yes or No)
            new AlertDialog.Builder(this) // show a separate alert dialog
                    .setTitle("Terminating...")
                    .setMessage("Confirm to Exit?")
                    .setPositiveButton(android.R.string.yes,
                            new DialogInterface.OnClickListener() { // CONFIRM
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getBaseContext(), "M7 Exit Confirmed!", Toast.LENGTH_SHORT).show();
                                    finish(); // destroy this activity by program code
                                }
                            })

                    .setNegativeButton(getString(android.R.string.no), new DialogInterface.OnClickListener() { // CANCEL
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getBaseContext(), "Cancel Exit!\nKeep Running!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert).show();
        }
    }