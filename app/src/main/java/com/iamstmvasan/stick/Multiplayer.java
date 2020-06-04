package com.iamstmvasan.stick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Multiplayer extends AppCompatActivity {
    Toolbar toolbar4;
    TextView msg_m , winMsg_m , instruct_m;
    Button remainingBall_m , one_m , two_m , three_m , four_m ,startAgain_m ;
    ImageView player1_turn_m , player2_turn_m , winImg_m ;
    TextView p1Name , p2Name , error_m;

    private int ball_m = 21;
    private int player1_Choice_m , player2_Choice_m;
    private boolean firstPlayer = true , secondPlayer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        toolbar4 = findViewById(R.id.toolbar4);

        setSupportActionBar(toolbar4);
        getSupportActionBar().setTitle("Last Ball");
        toolbar4.setTitleTextColor(Color.parseColor("#34495E"));

        remainingBall_m = findViewById(R.id.remainingBall_m);
        msg_m = findViewById(R.id.msg_m);
        one_m = findViewById(R.id.one_m);
        two_m = findViewById(R.id.two_m);
        three_m = findViewById(R.id.three_m);
        four_m = findViewById(R.id.four_m);
        startAgain_m = findViewById(R.id.startAgain_m);

        player1_turn_m = findViewById(R.id.player1_turn_m);
        player2_turn_m = findViewById(R.id.player2_turn_m);
        winImg_m = findViewById(R.id.winimg_m);
        winMsg_m = findViewById(R.id.winmsg_m);
        instruct_m = findViewById(R.id.instruct_m);

        p1Name = findViewById(R.id.p1);
        p2Name = findViewById(R.id.p2);
        error_m = findViewById(R.id.error_m);

        p1Name.setText(Selection.player1Name_str);
        p2Name.setText(Selection.player2Name_str);
        msg_m.setText(Selection.player1Name_str+" turn");

        one_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error_m.setVisibility(View.INVISIBLE);
                if(firstPlayer){
                    firstPlayer = false;
                    secondPlayer = true;
                    player1_Choice_m = 1;
                    msg_m.setText(Selection.player1Name_str+" take 1 ball");
                    ball_m -= 1;
                    remainingBall_m.setText(String.valueOf(ball_m));
                    if(ball_m == 1){
                        winning_m(Selection.player1Name_str+" Win the Match");
                    }
                    player1_turn_m.setVisibility(View.INVISIBLE);
                    player2_turn_m.setVisibility(View.VISIBLE);
                }
                else if(secondPlayer){
                    secondPlayer = false;
                    firstPlayer = true;
                    player2_Choice_m = 1;
                    msg_m.setText(Selection.player2Name_str+" take 1 ball");
                    ball_m -= 1;
                    remainingBall_m.setText(String.valueOf(ball_m));
                    if(ball_m == 1){
                        winning_m(Selection.player2Name_str+" Win the Match");
                    }
                    player1_turn_m.setVisibility(View.VISIBLE);
                    player2_turn_m.setVisibility(View.INVISIBLE);
                }
            }
        });
        two_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error_m.setVisibility(View.INVISIBLE);
                if(firstPlayer){
                    firstPlayer = false;
                    secondPlayer = true;
                    player1_Choice_m = 2;
                    msg_m.setText(Selection.player1Name_str+" take 2 ball");
                    ball_m -= 2;
                    remainingBall_m.setText(String.valueOf(ball_m));
                    if(ball_m == 1){
                        winning_m(Selection.player1Name_str+" Win the Match");
                    }
                    else if(ball_m == 0){
                        winning_m(Selection.player2Name_str+" Win the Match");
                    }
                    player1_turn_m.setVisibility(View.INVISIBLE);
                    player2_turn_m.setVisibility(View.VISIBLE);
                }
                else if(secondPlayer){
                    secondPlayer = false;
                    firstPlayer = true;
                    player2_Choice_m = 2;
                    msg_m.setText(Selection.player2Name_str+" take 2 ball");
                    ball_m -= 2;
                    remainingBall_m.setText(String.valueOf(ball_m));
                    if(ball_m == 1){
                        winning_m(Selection.player2Name_str+" Win the Match");
                    }
                    else if(ball_m == 0){
                        winning_m(Selection.player1Name_str+" Win the Match");
                    }
                    player1_turn_m.setVisibility(View.VISIBLE);
                    player2_turn_m.setVisibility(View.INVISIBLE);
                }
            }
        });
        three_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error_m.setVisibility(View.INVISIBLE);
                if(firstPlayer){
                    player1_Choice_m = 3;
                    if(player1_Choice_m > ball_m){
                        error_m.setVisibility(View.VISIBLE);
                        error_m.setTextColor(Color.RED);
                        error_m.setText(Selection.player1Name_str+" your choice is greater than remaining ball\n\t\t\t\t\t\tChoose again");
                    }
                    else {
                        error_m.setVisibility(View.INVISIBLE);
                        firstPlayer = false;
                        secondPlayer = true;

                        msg_m.setText(Selection.player1Name_str + " take 3 ball");
                        ball_m -= 3;
                        remainingBall_m.setText(String.valueOf(ball_m));
                        if (ball_m == 1) {
                            winning_m(Selection.player1Name_str + " Win the Match");
                        } else if (ball_m == 0) {
                            winning_m(Selection.player2Name_str + " Win the Match");
                        }
                        player1_turn_m.setVisibility(View.INVISIBLE);
                        player2_turn_m.setVisibility(View.VISIBLE);
                    }

                }
                else if(secondPlayer){
                    player2_Choice_m = 3;
                    if(player2_Choice_m > ball_m){
                        error_m.setVisibility(View.VISIBLE);
                        error_m.setTextColor(Color.RED);
                        error_m.setText(Selection.player2Name_str+" your choice is greater than remaining ball\n\t\t\t\t\t\tChoose again");
                    }
                    else {
                        secondPlayer = false;
                        firstPlayer = true;
                        msg_m.setText(Selection.player2Name_str + " take 3 ball");
                        ball_m -= 3;
                        remainingBall_m.setText(String.valueOf(ball_m));
                        if (ball_m == 1) {
                            winning_m(Selection.player2Name_str + " Win the Match");
                        }
                        else if(ball_m == 0){
                            winning_m(Selection.player1Name_str + " Win the Match");
                        }
                        player1_turn_m.setVisibility(View.VISIBLE);
                        player2_turn_m.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });
        four_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error_m.setVisibility(View.INVISIBLE);
                if(firstPlayer){
                    player1_Choice_m = 4;
                    if(player1_Choice_m > ball_m){
                        error_m.setVisibility(View.VISIBLE);
                        error_m.setTextColor(Color.RED);
                        error_m.setText(Selection.player1Name_str+" your choice is greater than remaining ball\n\t\t\t\t\t\tChoose again");
                    }
                    else {
                        error_m.setVisibility(View.INVISIBLE);
                        firstPlayer = false;
                        secondPlayer = true;

                        msg_m.setText(Selection.player1Name_str + " take 4 ball");
                        ball_m -= 4;
                        remainingBall_m.setText(String.valueOf(ball_m));
                        if (ball_m == 1) {
                            winning_m(Selection.player1Name_str + " Win the Match");
                        } else if (ball_m == 0) {
                            winning_m(Selection.player2Name_str + " Win the Match");
                        }
                        player1_turn_m.setVisibility(View.INVISIBLE);
                        player2_turn_m.setVisibility(View.VISIBLE);
                    }

                }
                else if(secondPlayer){
                    player2_Choice_m = 4;
                    if(player2_Choice_m > ball_m){
                        error_m.setVisibility(View.VISIBLE);
                        error_m.setTextColor(Color.RED);
                        error_m.setText(Selection.player2Name_str+" your choice is greater than remaining ball\n\t\t\t\t\t\tChoose again");
                    }
                    else {
                        secondPlayer = false;
                        firstPlayer = true;
                        msg_m.setText(Selection.player2Name_str + " take 4 ball");
                        ball_m -= 4;
                        remainingBall_m.setText(String.valueOf(ball_m));
                        if (ball_m == 1) {
                            winning_m(Selection.player2Name_str + " Win the Match");
                        }
                        else if(ball_m == 0){
                            winning_m(Selection.player1Name_str + " Win the Match");
                        }
                        player1_turn_m.setVisibility(View.VISIBLE);
                        player2_turn_m.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });
        startAgain_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAgain_m.setVisibility(View.INVISIBLE);
                winImg_m.setVisibility(View.INVISIBLE);
                winMsg_m.setVisibility(View.INVISIBLE);
                one_m.setVisibility(View.VISIBLE);
                two_m.setVisibility(View.VISIBLE);
                three_m.setVisibility(View.VISIBLE);
                four_m.setVisibility(View.VISIBLE);
                ball_m = 21;
                remainingBall_m.setText(String.valueOf(ball_m));
                player1_turn_m.setVisibility(View.INVISIBLE);
                player2_turn_m.setVisibility(View.VISIBLE);
                msg_m.setText(Selection.player2Name_str+" turn");
                secondPlayer = true;
                firstPlayer = false;

            }
        });

    }

    private void winning_m(String s) {
        one_m.setVisibility(View.INVISIBLE);
        two_m.setVisibility(View.INVISIBLE);
        three_m.setVisibility(View.INVISIBLE);
        four_m.setVisibility(View.INVISIBLE);

        winImg_m.setVisibility(View.VISIBLE);
        winMsg_m.setVisibility(View.VISIBLE);
        winMsg_m.setText(s);
        startAgain_m.setVisibility(View.VISIBLE);

    }
}
