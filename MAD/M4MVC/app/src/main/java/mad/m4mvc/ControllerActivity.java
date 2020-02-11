package mad.m4mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class ControllerActivity extends AppCompatActivity {

    String lifeCycleInfo = "Activity Life Cycle:\n"; // a field, show text info

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.textView)).setText(lifeCycleInfo = lifeCycleInfo + "\n > onCreate");
    }

    @SuppressLint("SetTextI18n")
    protected void onStart() {
        super.onStart(); // always call superclass
        ((TextView) findViewById(R.id.textView)).setText(lifeCycleInfo = lifeCycleInfo + "\n > onStart");
    }

    @SuppressLint("SetTextI18n")
    protected void onRestart() {
        super.onRestart(); // always call superclass
        ((TextView) findViewById(R.id.textView)).setText(lifeCycleInfo = lifeCycleInfo + "\n > onRestart");
    }

    @SuppressLint("SetTextI18n")
    protected void onResume() {
        super.onResume(); // always call superclass
        ((TextView) findViewById(R.id.textView)).setText(lifeCycleInfo = lifeCycleInfo + "\n > onResume");
    }

    @SuppressLint("SetTextI18n")
    protected void onPause() {
        super.onPause(); // always call superclass
        ((TextView) findViewById(R.id.textView)).setText(lifeCycleInfo = lifeCycleInfo + "\n > onPause");
    }

    @SuppressLint("SetTextI18n")
    protected void onStop() {
        super.onStop(); // always call superclass
        ((TextView) findViewById(R.id.textView)).setText(lifeCycleInfo = lifeCycleInfo + "\n > onStop");
    }

    @SuppressLint("SetTextI18n")
    protected void onDestroy() {
        super.onDestroy(); // always call superclass
        ((TextView) findViewById(R.id.textView)).setText(lifeCycleInfo = lifeCycleInfo + "\n > onDestroy");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();//Toast info
    }

    @SuppressLint("SetTextI18n")
    public void getRich(View view) {
        int[] gM6 = per.m6.MADModelM6_SE.getM6(6, 1, 49);
        ((Button) findViewById(R.id.button)).setText("NEW Data:\n" + Arrays.toString(gM6));
        Toast.makeText(this, "NEW Data:\n" + Arrays.toString(gM6), Toast.LENGTH_SHORT).show();

        final Intent intent2View = new Intent("mad.MAD_ACTION");
        intent2View.putExtra ("GetRichIntA", gM6);
// Create an intent to show chooser dialog, to choose if more than one app can handle
        String title = "Choose a desired one";
        Intent chooser = Intent.createChooser(intent2View, title);
        startActivity(chooser);

// Get a Handle to a SharedPreferences
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
// Read data from a SharedPreferences, and display it
        String strData = sharedPref.getString("KEY_SPrefData", "NO DATA STORED");
        Toast.makeText(this, "Stored Data:\n" + strData, Toast.LENGTH_SHORT).show();
// Write to a SharedPreferences
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("KEY_SPrefData", Arrays.toString(gM6));
        editor.apply();
    }
    
}
