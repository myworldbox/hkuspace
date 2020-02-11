package mad.m1hiworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int clickNo = 0; // a field, for the number of clicking
    String type;
    public void btnClick(View view){ // a method to handle button click, defined in xml file
        if (clickNo % 2 == 0){
            type = "odd";
        } else {
            type = "even";
        }
        ((Button)findViewById(R.id.button)).setText("MAD BUTTON CLICKED: " + ++clickNo + "\nType: "+type);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
