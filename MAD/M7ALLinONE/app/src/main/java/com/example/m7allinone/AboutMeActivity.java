package com.example.m7allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

import java.util.List;

public class AboutMeActivity extends AppCompatActivity {

    String strAboutMe = "\nAbout ME:\n\n" + "My Name\n" + " Enjoy MAD\n" + " Good in Sleeping\n"
            + " and sense ME with HW:\n\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        // setup sensor manager
        SensorManager mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
// get sensor list information
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
// show sensor list information
        Object[] sensorArr = sensorList.toArray();
        for (int i = 0; i < sensorArr.length; i++)
            strAboutMe = strAboutMe + sensorArr[i].toString() + "\n\n";
        ((EditText) findViewById(R.id.editTextAboutMe)).setText(strAboutMe);
    }
}
