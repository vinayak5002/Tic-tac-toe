package com.tic_tac_toe.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class GamePage extends AppCompatActivity {
    int count = 0;
    public void press(Button view) {
        count ++;
        if(count %2 == 0){
            view.setText("X");
        }
        else{
            view.setText("O");
        }

        view.setEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_page);
    }
}