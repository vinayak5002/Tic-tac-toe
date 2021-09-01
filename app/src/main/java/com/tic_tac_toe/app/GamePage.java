package com.tic_tac_toe.app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GamePage extends AppCompatActivity {

    DetermineWinner determine;
    int[][] board = { {-1,-1,-1}, {-1,-1,-1}, {-1,-1,-1} };

    int count = 0;
    int a[][] = new int[3][3];

    TextView title;
    int buttons[] = { R.id._00, R.id._01, R.id._02, R.id._10, R.id._11, R.id._12, R.id._20, R.id._21, R.id._22 };

    public void press(View view) {
        title = findViewById(R.id.gamePage);
        count ++;
        Button button = (Button) findViewById(view.getId());
        Button disableButton;
        String id = view.getResources().getResourceName(view.getId());
        // Use this id to update in array a and call the getWinner method to find the winner
        int i = Character.getNumericValue( id.charAt(24) );
        int j = Character.getNumericValue( id.charAt(25) );

        int winner;

        if(count %2 == 0){
            button.setText("X");
            board[i][j] = 1;   //this is where the app is crashing again
            winner = determine.getWinner(board);
            button.setBackgroundColor(Color.BLUE);
        }
        else{
            button.setText("O");
            board[i][j] = 0;  //and here too
            winner = determine.getWinner(board);
            button.setBackgroundColor(Color.RED);
        }
        button.setEnabled(false);
        Log.i("winner:", String.valueOf(winner));
        if(winner == 1 || winner == 0){
            title.setText(String.valueOf(winner));
            for(i=0; i<9; i++){
                disableButton = findViewById(buttons[i]);
                disableButton.setEnabled(false);
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                a[i][j]=-1;
            }
        }
        setContentView(R.layout.game_page);
    }

}