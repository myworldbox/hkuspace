package avicii.m2myworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoClicked(View view) { // method defined in layout xml file
        // show typed text to text view when goto button clicked
        EditText eText = (EditText) findViewById(R.id.edit_message);
        TextView tV = (TextView) findViewById(R.id.textView);
        String tStr = String.valueOf(eText.getText());
        tV.setText(tStr);
        ////// Launching a new Web View Activity, via Intent
        Intent intent2Web = new Intent(this, WebActivity.class);//intent for a web activity
        intent2Web.putExtra ("KEY_URL", tStr); //message (string tStr) to be passed with
        startActivity(intent2Web); // start and pass to the intended activity
    }
}