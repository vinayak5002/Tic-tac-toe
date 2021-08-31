package com.tic_tac_toe.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class GamePage extends AppCompatActivity {
    int count = 0;
    int a[][] = new int[3][3];

    public void press(View view) {
        count ++;
        Button button = (Button) findViewById(view.getId());
        String id = Integer.toString(button.getId());
        // Use this id to update in array a and call the getWinner method to find the winner
        if(count %2 == 0){
            button.setText("X");
        }
        else{
            button.setText("O");
        }
        button.setEnabled(false);
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