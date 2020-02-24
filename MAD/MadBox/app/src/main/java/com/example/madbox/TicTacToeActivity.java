package com.example.madbox;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivity extends BaseActivity {

    Button[][] buttons = new Button[3][3];
    String[][] field = new String[3][3];
    boolean circleTurn = true;
    int maxRound;
    int circleScore;
    int crossScore;
    TextView circleTextView;
    TextView crossTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        circleTextView = findViewById(R.id.textView);
        crossTextView = findViewById(R.id.textView2);
        Button buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(this);

        //set content of buttons into arrays
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button" + i + j;
                int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resourceID);
                buttons[i][j].setOnClickListener(this);
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onResume() {
        super.onResume();

        HideNav();
        RandMusic();
        MusicOn();
    }

    @Override
    protected void onPause() {
        super.onPause();

        MusicOff();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        //reset players' scores
        if (v.getId() == R.id.buttonReset) {

            text = "Reset";
            circleScore = crossScore = 0 ;

            Toast();
            circleTextView.setText("Circle: " + circleScore);
            crossTextView.setText("Cross: " + circleScore);
            circleScore = crossScore = 0 ;
        }

        if (!((Button) v).getText().toString().equals("")) {

            return;
        }

        //change button content on click
        if (circleTurn) {

            ((Button) v).setText("O");

        } else {

            ((Button) v).setText("X");
        }

        if (CheckWinner()) {

            if (circleTurn) {

                CircleWin();

            } else {

                CrossWin();
            }

        } else if (maxRound == 9) {

            text = "Draw!";
            Toast();
            ResetBoard();

        } else {

            //swap turn for players
            circleTurn = !circleTurn;
        }

        maxRound++;
    }

    protected boolean CheckWinner() {

        //set content of buttons into arrays
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        //check for columns
        for (int i = 0; i < 3; i++) {

            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals("")) {

                return true;
            }
        }

        //check for rows
        for (int i = 0; i < 3; i++) {

            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals("")) {

                return true;
            }
        }

        //check position from top left to bottom right
        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals("")) {

            return true;
        }

        //check position from top right to bottom left
        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")) {

            return true;
        }

        return false;
    }

    @SuppressLint("SetTextI18n")
    protected void CircleWin() {

        circleScore++;
        text = "Circle wins";
        Toast();
        circleTextView.setText("Circle: " + circleScore);
        ResetBoard();
    }

    @SuppressLint("SetTextI18n")
    protected void CrossWin() {

        crossScore++;
        text = "Circle wins";
        Toast();
        crossTextView.setText("Cross: " + crossScore);
        ResetBoard();
    }

    protected void ResetBoard() {

        maxRound = 0;
        circleTurn = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                buttons[i][j].setText("");
            }
        }
    }
}