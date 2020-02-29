package mad.m6touges;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class GestureActivity extends AppCompatActivity implements GestureDetector.OnGestureListener { // implement Gesture interface TextView tVGest = null; // a field: Button to show Gesture Data

    TextView tVGest = null; // a field: Button to show Gesture Data
    private GestureDetectorCompat gDetector; // a field: For Gesture Detection

    ///////////// START - For Gesture Detection ////////////////
    @Override // used for passing data to the GestureDetectorCompat instance
    public boolean onTouchEvent(MotionEvent event) {

        this.gDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {

        tVGest.setText("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

        tVGest.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        tVGest.setText("onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float dX, float dY) {
        tVGest.setText("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        tVGest.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) { // Fling Gesture shows detailed info
        Toast.makeText(this, "Fling Gesture Detected.", Toast.LENGTH_SHORT).show();
        tVGest.setText("onFling - \n START X: " + e1.getX() + ", Y: " + e1.getY() + " \n END X: " + e2.getX() + ", Y: " + e2.getY() + " \n Velocity X: " + velocityX + ", Y: " + velocityY);
        return false;
    }

    ///////////// END - For Gesture Detection ////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // always call superclass
        setContentView(R.layout.activity_gesture);

        tVGest = (TextView) findViewById(R.id.tView_gesture);
        this.gDetector = new GestureDetectorCompat(this, this);//create Detector
    }
}
