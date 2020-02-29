package mad.m6touges;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MultiTouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_touch);
        getSupportActionBar().hide();

        final ImageView imgV = (ImageView) findViewById(R.id.imgView_multitouch);
        final TextView tView = (TextView) findViewById(R.id.tView_multitouch);
        ConstraintLayout cLayout = (ConstraintLayout) findViewById(R.id.activity_multi_touch);

        cLayout.setOnTouchListener( // set touch listener
                new ConstraintLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent m) {
                        int ptrCount = m.getPointerCount(); // get number of multi-touches
                        tView.setText(String.valueOf(ptrCount));
                        float mX = m.getX(), mY = m.getY();// get Location of touch
                        imgV.setX(mX); // move object to the Location of touch
                        imgV.setY(mY);
                        imgV.setScaleX(ptrCount);// scale object based on number of touches
                        imgV.setScaleY(ptrCount);
                        return true;
                    }
                }
        );

        Button butHome = (Button) findViewById(R.id.butHome); // Button, for back home
        butHome.setOnClickListener( // set button click action
                new View.OnClickListener() {
                    public void onClick(View v) {
                        finish(); // finish (terminate) this activity
                    }
                }
        );
    }
}