package mad.m6touges;

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

    ///////////// START - Button Click to Diff. Activity Screens ////////////////
    public void toTouchScreen(View view){
        startActivity(new Intent(this,TouchActivity.class));//start Activity via intent
    }
    public void toMultiTouchScreen(View view){
        startActivity(new Intent(this,MultiTouchActivity.class));// start Activity
    }

    public void toGestureScreen(View view){
        startActivity(new Intent(this,GestureActivity.class)); // start Activity
    }
///////////// END - Button Click to Diff. Activity Screens ////////////////
}
