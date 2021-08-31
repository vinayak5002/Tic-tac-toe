package com.tic_tac_toe.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void userNameSubmit(View view){
        Log.i("Submit button", "userNameSubmit: ");
    }

    String warningMessage = " ";
    String userName;

    Button submitButton;
    EditText userNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.UserNameSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchGame = new Intent(MainActivity.this, GamePage.class);

                userNameField = (EditText) findViewById(R.id.UserName);
                userName = userNameField.getText().toString();

                if(!userName.equals("")){
                    Log.i("user name", "onClick: user name not null");
                    Log.i("user name", userName);
                    startActivity(launchGame);
                }
            }
        });

    }
}