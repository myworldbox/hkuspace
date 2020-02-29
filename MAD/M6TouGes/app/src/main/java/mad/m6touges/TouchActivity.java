package mad.m6touges;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class TouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        final TextView tV = (TextView) findViewById(R.id.tView_touch);
        ConstraintLayout cLayout = (ConstraintLayout) findViewById(R.id.activity_touch);
        cLayout.setOnTouchListener( // set touch
                new ConstraintLayout.OnTouchListener() {// anonymous class: Listener interface
                    @Override
                    public boolean onTouch(View v, MotionEvent m) { // do this onTouch
                        float mX = m.getX(), mY = m.getY(); // get Location of touch
                        tV.setText("X:" + mX + "\n Y:" + mY); // show Location of touch
                        tV.setX(mX); // move object to the Location of touch
                        tV.setY(mY);
                        return true;
                    }
                }
        );
    }
}

