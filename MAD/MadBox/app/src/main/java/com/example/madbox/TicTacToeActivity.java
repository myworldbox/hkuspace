package com.example.madbox;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//this class contains game logic of Tic Tac Toe
public class TicTacToeActivity extends MainActivity {

    Button[][] button = new Button[3][3];
    String[][] string = new String[3][3];
    TextView scoreBoard;
    boolean circleTurn = true;
    int maxRound;
    int circleScore;
    int crossScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        scoreBoard = findViewById(R.id.textView);
        Button buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(this);

        //set content of buttons into arrays
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                String buttonID = "button" + i + j;
                int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
                button[i][j] = findViewById(resourceID);
                button[i][j].setOnClickListener(this);
            }
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        //reset players' scores when buttonReset is clicked
        if (v.getId() == R.id.buttonReset) {

            text = "Reset";
            circleScore = crossScore = 0 ;

            ResetBoard();
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

                text = "Circle wins";
                circleScore++;

            } else {

                text = "Cross wins";
                crossScore++;
            }

            ResetBoard();

        } else if (maxRound == 9) {

            text = "Draw!";

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

                string[i][j] = button[i][j].getText().toString();
            }

            //check for columns and rows
            if (string[i][0].equals(string[i][1]) && string[i][0].equals(string[i][2]) && !string[i][0].equals("") || string[0][i].equals(string[1][i]) && string[0][i].equals(string[2][i]) && !string[0][i].equals("")) {

                return true;
            }
        }

        //check position from top left to bottom right and from top right to bottom left
        return string[0][0].equals(string[1][1]) && string[0][0].equals(string[2][2]) && !string[0][0].equals("") || string[0][2].equals(string[1][1]) && string[0][2].equals(string[2][0]) && !string[0][2].equals("");
    }

    @SuppressLint("SetTextI18n")
    protected void ResetBoard() {

        maxRound = 0;
        circleTurn = !circleTurn;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                button[i][j].setText("");
            }
        }

        Toast();
        scoreBoard.setText("Circle: " + circleScore + "\nCross: " + crossScore);
    }
}