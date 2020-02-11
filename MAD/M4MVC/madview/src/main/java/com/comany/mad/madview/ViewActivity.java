package com.comany.mad.madview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {
    TextView tV = null;
    int[] m6 = null;
    String dispM6Str=null;

    protected void onResume(){
        super.onResume();  				// always call superclass
        // handle the customized action, as a view for M6
        tV = ((TextView) findViewById(R.id.m6View));
        tV.setText("Coming numbers ...");
        if (m6!=null) {  // check if there are m6 numbers
//            int[] m6 = getIntent().getIntArrayExtra("GetRichIntA"); // get M6 numbers
            new Thread(new Runnable() {        // create a new thread to animate, and then start it.
                @Override
                public void run() {
                    dispM6Str = "";
                    for (int i = 0; i < m6.length; i++) {
                        dispM6Str += "\n > " + m6[i];
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ie) {
                        }
                        tV.post(new Runnable() {
                            public void run() {
                                tV.setText(dispM6Str);
                            }
                        });
                    }
                }
            }).start();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        if (getIntent()!=null)  // check if invoked from an intent; if yes, get numbers
            m6 = getIntent().getIntArrayExtra("GetRichIntA"); // get M6 numbers
    }
}
