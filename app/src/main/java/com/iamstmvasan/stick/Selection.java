package com.iamstmvasan.stick;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Selection extends AppCompatActivity {
    Toolbar toolbar3;
    ImageView singlePlayer_img , multiPlayer_img , finalPlayer_img , userStart_img ,computerStart_img , finalStart_img;
    TextView singlePlayer_txt ,multiPlayer_txt , finalPlayer_txt , userStart_txt ,computerStart_txt , finalStart_txt , gameStartMsg_txt ;
    EditText player1Name , player2Name;
    Button startAgainButton;
    TextView error;

    public static String singleOrMulti_player , userOrComputer_start , player1Name_str , player2Name_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        error = findViewById(R.id.error);

        toolbar3 = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar3);
        getSupportActionBar().setTitle("Last Ball");
        toolbar3.setTitleTextColor(Color.parseColor("#34495E"));

        singlePlayer_img = findViewById(R.id.imageView_single);
        multiPlayer_img = findViewById(R.id.imageView_multi);
        finalPlayer_img = findViewById(R.id.imageView_final);
        userStart_img = findViewById(R.id.user_start);
        computerStart_img = findViewById(R.id.computer_start);
        finalStart_img = findViewById(R.id.final_start);

        singlePlayer_txt = findViewById(R.id.textView_single);
        multiPlayer_txt = findViewById(R.id.textView_multi);
        finalPlayer_txt = findViewById(R.id.textView_final);
        userStart_txt = findViewById(R.id.textView10);
        computerStart_txt = findViewById(R.id.textView11);
        finalStart_txt = findViewById(R.id.textView_finalStart);
        gameStartMsg_txt = findViewById(R.id.textView_gamestart_msg);


        player1Name = findViewById(R.id.editText_player1);
        player2Name = findViewById(R.id.editText_player2);

        startAgainButton = findViewById(R.id.startAgainButton);
        singlePlayer_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singlePlayer_img.setVisibility(View.INVISIBLE);
                singlePlayer_txt.setVisibility(View.INVISIBLE);
                multiPlayer_img.setVisibility(View.INVISIBLE);
                multiPlayer_txt.setVisibility(View.INVISIBLE);
                finalPlayer_img.setVisibility(View.VISIBLE);
                finalPlayer_txt.setVisibility(View.VISIBLE);
                finalPlayer_txt.setText("Single Player");
                finalPlayer_img.setImageResource(R.drawable.singleuser);
                singleOrMulti_player = "single";

                gameStartMsg_txt.setVisibility(View.VISIBLE);
                userStart_img.setVisibility(View.VISIBLE);
                computerStart_img.setVisibility(View.VISIBLE);
                userStart_txt.setVisibility(View.VISIBLE);
                computerStart_txt.setVisibility(View.VISIBLE);
                finalStart_img.setVisibility(View.INVISIBLE);
                finalStart_txt.setVisibility(View.INVISIBLE);

                player1Name.setVisibility(View.INVISIBLE);
                player2Name.setVisibility(View.INVISIBLE);

                error.setVisibility(View.INVISIBLE);

            }
        });
        multiPlayer_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error.setVisibility(View.INVISIBLE);
                singlePlayer_img.setVisibility(View.INVISIBLE);
                singlePlayer_txt.setVisibility(View.INVISIBLE);
                multiPlayer_img.setVisibility(View.INVISIBLE);
                multiPlayer_txt.setVisibility(View.INVISIBLE);
                finalPlayer_img.setVisibility(View.VISIBLE);
                finalPlayer_txt.setVisibility(View.VISIBLE);
                finalPlayer_txt.setText("Multiplayer");
                finalPlayer_img.setImageResource(R.drawable.multiuser);
                singleOrMulti_player = "multi";

                gameStartMsg_txt.setVisibility(View.INVISIBLE);
                userStart_img.setVisibility(View.INVISIBLE);
                computerStart_img.setVisibility(View.INVISIBLE);
                userStart_txt.setVisibility(View.INVISIBLE);
                computerStart_txt.setVisibility(View.INVISIBLE);

                finalStart_img.setVisibility(View.INVISIBLE);
                finalStart_txt.setVisibility(View.INVISIBLE);
                player1Name.setVisibility(View.VISIBLE);
                player2Name.setVisibility(View.VISIBLE);


                startAgainButton.setVisibility(View.VISIBLE);
            }
        });
        finalPlayer_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error.setVisibility(View.INVISIBLE);
                singlePlayer_img.setVisibility(View.VISIBLE);
                singlePlayer_txt.setVisibility(View.VISIBLE);
                multiPlayer_img.setVisibility(View.VISIBLE);
                multiPlayer_txt.setVisibility(View.VISIBLE);
                finalPlayer_img.setVisibility(View.INVISIBLE);
                finalPlayer_txt.setVisibility(View.INVISIBLE);

                gameStartMsg_txt.setVisibility(View.INVISIBLE);
                userStart_img.setVisibility(View.INVISIBLE);
                computerStart_img.setVisibility(View.INVISIBLE);
                userStart_txt.setVisibility(View.INVISIBLE);
                computerStart_txt.setVisibility(View.INVISIBLE);

                finalStart_img.setVisibility(View.INVISIBLE);
                finalStart_txt.setVisibility(View.INVISIBLE);
                player1Name.setVisibility(View.INVISIBLE);
                player2Name.setVisibility(View.INVISIBLE);


                startAgainButton.setVisibility(View.INVISIBLE);
            }
        });
        userStart_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalStart_img.setImageResource(R.drawable.user);
                userStart_img.setImageResource(R.drawable.user);
                userStart_img.setVisibility(View.INVISIBLE);
                userStart_txt.setVisibility(View.INVISIBLE);
                computerStart_txt.setVisibility(View.INVISIBLE);
                computerStart_img.setVisibility(View.INVISIBLE);
                gameStartMsg_txt.setVisibility(View.INVISIBLE);
                finalStart_txt.setVisibility(View.VISIBLE);
                finalStart_img.setVisibility(View.VISIBLE);
                finalStart_txt.setText("You start the game");
                userOrComputer_start = "user";


                startAgainButton.setVisibility(View.VISIBLE);

            }
        });
        computerStart_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalStart_img.setImageResource(R.drawable.computer);
                userStart_img.setVisibility(View.INVISIBLE);
                userStart_txt.setVisibility(View.INVISIBLE);
                computerStart_txt.setVisibility(View.INVISIBLE);
                computerStart_img.setVisibility(View.INVISIBLE);
                gameStartMsg_txt.setVisibility(View.INVISIBLE);
                finalStart_txt.setVisibility(View.VISIBLE);
                finalStart_img.setVisibility(View.VISIBLE);
                finalStart_txt.setText("Computer start the game");
                userOrComputer_start = "computer";
                computerStart_img.setImageResource(R.drawable.computer);

                startAgainButton.setVisibility(View.VISIBLE);
            }
        });
        finalStart_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userStart_img.setVisibility(View.VISIBLE);
                userStart_txt.setVisibility(View.VISIBLE);
                computerStart_txt.setVisibility(View.VISIBLE);
                computerStart_img.setVisibility(View.VISIBLE);
                gameStartMsg_txt.setVisibility(View.VISIBLE);
                finalStart_txt.setVisibility(View.INVISIBLE);
                finalStart_img.setVisibility(View.INVISIBLE);

                startAgainButton.setVisibility(View.INVISIBLE);
            }
        });
        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(singleOrMulti_player.equalsIgnoreCase("single")){
                    if(userOrComputer_start.equalsIgnoreCase("user"))
                        startActivity(new Intent(Selection.this , Singleplayer.class));
                    else
                        startActivity(new Intent(Selection.this , Main2Activity.class));
                }
                else if(singleOrMulti_player.equalsIgnoreCase("multi")){
                    player1Name_str = player1Name.getText().toString();
                    player2Name_str = player2Name.getText().toString();
                    if( (player1Name_str.trim().length() > 0 && player2Name_str.trim().length() > 0 )){

                        startActivity(new Intent(Selection.this , Multiplayer.class));
                    }
                    else {
                        error.setText("Kindly fill the Player's name");
                        error.setTextColor(Color.RED);
                        error.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
}
