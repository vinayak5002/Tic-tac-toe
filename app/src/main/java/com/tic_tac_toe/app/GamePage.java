package com.tic_tac_toe.app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;


public class GamePage extends AppCompatActivity {

    DetermineWinner determine;
    int[][] board = { {-1,-1,-1}, {-1,-1,-1}, {-1,-1,-1} };
    HashMap<Integer , PositionOfBoard> positions = new HashMap<Integer, PositionOfBoard>();

    int turn = (new Random().nextInt())%2;
    int count = 0;
    int a[][] = new int[3][3];
    int xWin = 0, oWin = 0;

    TextView title;
    TextView scores;
    Button rematch;
    Button button;
    Button cell1, cell2, cell3;
    int buttons[] = { R.id._00, R.id._01, R.id._02, R.id._10, R.id._11, R.id._12, R.id._20, R.id._21, R.id._22 };

    public void press(View view) {
        count ++;
        button = findViewById(view.getId());
        Button disableButton;
        // Use this id to update in array a and call the getWinner method to find the winner
        int i = positions.get(view.getId()).getI();
        int j = positions.get(view.getId()).getJ();


        int winner;

        if(count %2 == 0){
            button.setText("X");
            button.setTextColor(Color.parseColor("#1803ff"));
            title.setText("O's turn");
            board[i][j] = 1;
            winner = determine.getWinner(board);
        }
        else{
            button.setText("O");
            button.setTextColor(Color.parseColor("#ff0303"));
            title.setText("X's turn");
            board[i][j] = 0;
            winner = determine.getWinner(board);
        }
        button.setEnabled(false);
        Log.i("winner:", String.valueOf(winner));
        if(winner == 1 || winner == 0) {
            if (winner == 1) {
                title.setText("Winner is X");
                xWin++;
            } else {
                title.setText("Winner is O");
                oWin++;
            }
            for (i = 0; i < 9; i++) {
                disableButton = findViewById(buttons[i]);
                disableButton.setEnabled(false);
            }
            rematch.setVisibility(View.VISIBLE);
            scores = findViewById(R.id.scores);
            scores.setText("O - " + oWin + " | X - " + xWin);
        }
        else if(count == 9){
            title.setText("Its a draw");
            rematch.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_page);
        title = findViewById(R.id.gamePage);
        rematch = findViewById(R.id.rematch);
        if(turn%2 == 0){
            title.setText("O's turn");
        }
        else{
            title.setText("X's turn");
        }
        positions.put(R.id._00, new PositionOfBoard(0, 0));
        positions.put(R.id._01, new PositionOfBoard(0, 1));
        positions.put(R.id._02, new PositionOfBoard(0, 2));
        positions.put(R.id._10, new PositionOfBoard(1, 0));
        positions.put(R.id._11, new PositionOfBoard(1, 1));
        positions.put(R.id._12, new PositionOfBoard(1, 2));
        positions.put(R.id._20, new PositionOfBoard(2, 0));
        positions.put(R.id._21, new PositionOfBoard(2, 1));
        positions.put(R.id._22, new PositionOfBoard(2, 2));
    }

    public void rematch(View view) {
        board = new int[][]{{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
        int count = (new Random().nextInt())%2;
        if(count%2 == 0){
            title.setText("O's turn");
        }
        else{
            title.setText("X's turn");
        }
        for(int i=0; i<9; i++){
            button = findViewById(buttons[i]);
            button.setEnabled(true);
            button.setText(" ");

            rematch.setVisibility(View.INVISIBLE);
        }
    }
}