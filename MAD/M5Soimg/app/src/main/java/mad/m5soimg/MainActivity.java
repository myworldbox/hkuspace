package mad.m5soimg;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    // Init image with rotation animation
    public void initRotateBgImg() {
        // animate rotation of background image
        RotateAnimation animR = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animR.setInterpolator(new LinearInterpolator());
        animR.setRepeatCount(Animation.INFINITE);
        animR.setDuration(60000);
// Simple scaling the background image view
        ImageView imgV = ((ImageView) findViewById(R.id.bg_imgView));
        imgV.setScaleX(2);
        imgV.setScaleY(2);
// Start animating (rotating) the background image view
        imgV.startAnimation(animR);
    }

    MediaPlayer myMus = null; // a field of MediaPlayer

    @Override
    protected void onResume() { // callback method, when interacting with user
        super.onResume(); // always call superclass
        if (myMus != null) myMus.start(); // start playing
    }

    @Override
    protected void onPause() { // callback method, inactive: when no interacting
        super.onPause(); // always call superclass
        if (myMus != null) myMus.pause(); // pause playing
    }

    void makeMoveThread() { // for making a thread to continuously move the image object
        final int DEF_SLEEP_GAP = 1000; // mini-sec
        final int DEF_MAX = 200; // max movement factor
        final int DEF_BASE = -DEF_MAX / 2; // base movement factor
        new Thread(new Runnable() { // create a new thread to animate, and then start it.
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(DEF_SLEEP_GAP); // interval in ms
// move (change location of) the image
                        final ImageButton imgB = (ImageButton) findViewById(R.id.fg_imgButton);
                        if (imgB == null) break;
                        imgB.post(new Runnable() { // for handling UI with thread in Android
                            public void run() {
                                // animate motion
                                int diffX = (DEF_BASE + (int) (Math.random() * DEF_MAX));
                                int diffY = (DEF_BASE + (int) (Math.random() * DEF_MAX));
                                imgB.setX(imgB.getX() + diffX);
                                imgB.setY(imgB.getY() + diffY);
                                // animate changing transparency
                                imgB.setImageAlpha(128 + (int) (Math.random() * 128));
                            }
                        });
                    } catch (InterruptedException ie) {
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initRotateBgImg(); // call to init rotating bg image
        myMus = MediaPlayer.create(this, R.raw.bs);//sound file “bs” in raw folder
        myMus.setLooping(true); // set loop-playing mode
        makeMoveThread();

        Switch soundSw = (Switch) findViewById(R.id.swSound);
        soundSw.setChecked(true); // set the switch as Checked (ON) initially
        soundSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { // is enabled
                    if (myMus != null) myMus.start(); // start playing
                } else { // is disabled
                    if (myMus != null) myMus.pause(); // pause playing
                }
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Show Our FG Object Back", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                ImageButton imgB = (ImageButton) findViewById(R.id.fg_imgButton);
                imgB.setX(300);
                imgB.setY(300);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_portrait) { // action, when selected
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            return true;
        }
        if (id == R.id.action_autorate) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
