package com.tic_tac_toe.app;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;


public class GamePage extends AppCompatActivity {

    DetermineWinner determine;
    int[][] board = { {-1,-1,-1}, {-1,-1,-1}, {-1,-1,-1} };
    HashMap<Integer , PositionOfBoard> positions = new HashMap<Integer, PositionOfBoard>();

    int count = 0;
    int a[][] = new int[3][3];

    TextView title;
    int buttons[] = { R.id._00, R.id._01, R.id._02, R.id._10, R.id._11, R.id._12, R.id._20, R.id._21, R.id._22 };

    public void press(View view) {
        title = findViewById(R.id.gamePage);
        count ++;
        ImageButton button = (ImageButton) findViewById(view.getId());
        ImageButton disableButton;
        // Use this id to update in array a and call the getWinner method to find the winner
        int i = positions.get(view.getId()).getI();
        int j = positions.get(view.getId()).getJ();
        Drawable cross = getResources().getDrawable(R.drawable.x);
        Drawable circle = getResources().getDrawable(R.drawable.o);


        int winner;

        if(count %2 == 0){
            button.setImageDrawable(cross);
            title.setText("O's turn");
            board[i][j] = 1;
            winner = determine.getWinner(board);
        }
        else{
            button.setImageDrawable(circle);
            title.setText("X's turn");
            board[i][j] = 0;
            winner = determine.getWinner(board);
        }
        button.setEnabled(false);
        Log.i("winner:", String.valueOf(winner));
        if(winner == 1 || winner == 0){
            if (winner == 1) {
                title.setText("Winner is X");
            } else {
                title.setText("Winner is O");
            }
            for(i=0; i<9; i++){
                disableButton = findViewById(buttons[i]);
                disableButton.setEnabled(false);
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_page);
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

}