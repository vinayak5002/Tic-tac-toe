package com.tic_tac_toe.app;

import android.content.Intent;
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
import java.util.Random;


public class GamePage extends AppCompatActivity {

    DetermineWinner determine;
    int[][] board = { {-1,-1,-1}, {-1,-1,-1}, {-1,-1,-1} };
    HashMap<Integer , PositionOfBoard> positions = new HashMap<Integer, PositionOfBoard>();

    int count = (new Random().nextInt())%2;
    int a[][] = new int[3][3];

    TextView title;
    Button rematch;
    int buttons[] = { R.id._00, R.id._01, R.id._02, R.id._10, R.id._11, R.id._12, R.id._20, R.id._21, R.id._22 };

    public void press(View view) {
        count ++;
        ImageButton button = (ImageButton) findViewById(view.getId());
        ImageButton disableButton;
        // Use this id to update in array a and call the getWinner method to find the winner
        int i = positions.get(view.getId()).getI();
        int j = positions.get(view.getId()).getJ();


        int winner;

        if(count %2 == 0){
            button.setBackgroundResource(R.drawable.x);
            title.setText("O's turn");
            board[i][j] = 1;
            winner = determine.getWinner(board);
        }
        else{
            button.setBackgroundResource(R.drawable.o);
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
            rematch.setVisibility(View.VISIBLE);
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
        if(count%2 == 0){
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
        Intent launch = new Intent(GamePage.this, GamePage.class);
        startActivity(launch);
    }
}