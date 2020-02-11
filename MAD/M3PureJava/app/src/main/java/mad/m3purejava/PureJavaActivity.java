package mad.m3purejava;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PureJavaActivity extends AppCompatActivity {// a Java class

    final String DEF_STR = "CLICK HERE"; // a constant field, for a default string
    int clickCount = 0; // a field, primitive data type, for counting clicks
    RelativeLayout aRLayout = null; // field for UI layout, like a layout XML
    Button aBut; // a Button field, a UI component
    ImageView imgV; // an image view, for showing the icon image

    SensorManager aSensorM; // a sensor manager
    Sensor aAccSensor; // the accelerometer sensor object
    SensorEventListener myListener = new SensorEventListener() { // Anonymous Class
        float accFactor = 6.0f; // the accelerometer factor for object movement
        Rect imgVRect = new Rect(), aButRect = new Rect();

        @Override // for interface: SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        // method to be called with sensor changed //
        @Override // for interface: SensorEventListener
        public final void onSensorChanged(SensorEvent event) {
///////////////// Section of responding sensor data updated //////////////////////
            if (imgV != null) {
                float newX = imgV.getX() - accFactor * event.values[0];
                float newY = imgV.getY() + accFactor * event.values[1];
                if (newX < 0) newX = 0;
                else if (newX > aRLayout.getWidth() - imgV.getWidth())
                    newX = aRLayout.getWidth() - imgV.getWidth();
                if (newY < 0) newY = 0;
                else if (newY > aRLayout.getHeight() - imgV.getHeight())
                    newY = aRLayout.getHeight() - imgV.getHeight();
                imgV.setX(newX); // update the x position
                imgV.setY(newY); // update the y position
// When image hits the button, the button updates its text and repositions randomly.
                if (aBut != null) {
                    imgV.getHitRect(imgVRect); // get Rect of imgV
                    aBut.getHitRect(aButRect); // get Rect of aBut
                    if (imgVRect.intersect(aButRect)) { //check if intersect / collide
                        aBut.callOnClick();
                        aBut.setX((int) (
                                Math.random() * (aRLayout.getWidth() - aBut.getWidth())));
                        aBut.setY((int) (Math.random() * (aRLayout.getHeight() - aBut.getHeight())));
                    }
                }
            }
        }
    };

    @Override // annotation, for overriding superclass’s method
    protected void onCreate(Bundle savedInstanceState) { // app starts with onCreate() method

        super.onCreate(savedInstanceState); // always call superclass
        aBut = new Button(this); // new Button to be added to layout
        aBut.setText(DEF_STR); // set Text of Button for the 1st time
// set an OnClickListener object of an anonymous class as button's listener to handle event

        aBut.setOnClickListener(new View.OnClickListener() { // Anonymous Class

            @SuppressLint("SetTextI18n")
            @Override // for interface: View.OnClickListener
            public void onClick(View v) { // method called when source view (Button) is clicked
// change button text, and randomly move the button in the onClick method
                aBut.setText((++clickCount) + "... Click"); // change text
                aBut.setX((int) (Math.random() * (aRLayout.getWidth() - aBut.getWidth()))); // move
            }
        });

        imgV = new ImageView(this); // create a new ImageView for the field
        imgV.setImageResource(R.mipmap.ic_launcher); // set the launcher image
        aRLayout = new RelativeLayout(this);
        aRLayout.setBackgroundColor(Color.YELLOW);
        aRLayout.addView(aBut);
        aRLayout.addView(imgV); // add the ImageView to Layout
        imgV.setX(300); // set the initial x position of the image
        imgV.setY(300); // set the initial y position of the image
        setContentView(aRLayout); // set the layout to be the activity window (content view)

        aSensorM = (SensorManager) getSystemService(Context.SENSOR_SERVICE);//get sensor
        assert aSensorM != null;
        if (aSensorM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) { // Success!
            aAccSensor = aSensorM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        } else aSensorM = null; // Failure! No ACCELEROMETER.
    }

    @Override // overriding superclass, register to obtain data when app resumes interacting
    protected void onResume() {
        super.onResume(); // always call superclass
        aSensorM.registerListener(myListener, aAccSensor, SensorManager.SENSOR_DELAY_GAME);
    }
    @Override // overriding superclass, unregister(disable) to obtain data when app pauses
    protected void onPause() {
            super.onPause(); // always call superclass
            aSensorM.unregisterListener(myListener);
        }
}
