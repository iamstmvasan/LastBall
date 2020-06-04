package com.iamstmvasan.stick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Singleplayer extends AppCompatActivity {
    Toolbar toolbar1;
    TextView msg , winMsg , instruct;
    Button remainingBall , one , two , three , four ,startAgain ;
    ImageView userTurn , computerTurn , winImg ;

    private int ball = 21;
    private int userChoice , computerChoice;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

       toolbar1 = findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar1);
        getSupportActionBar().setTitle("Last Ball");
        toolbar1.setTitleTextColor(Color.parseColor("#34495E"));

        remainingBall = findViewById(R.id.remainingBall);
        msg = findViewById(R.id.msg);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        startAgain = findViewById(R.id.startAgain);

        userTurn = findViewById(R.id.user_turn);
        computerTurn = findViewById(R.id.computer_turn);
        winImg = findViewById(R.id.winimg);
        winMsg = findViewById(R.id.winmsg);
        instruct = findViewById(R.id.instruct);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instruct.setText("WAIT");
                if(flag) {
                    flag = false;
                    if (ball == 1) {
                        msg.setText("Click Start Again Button");
                    } else {
                        userChoice = 1;
                        String message = "You take 1 ball";
                        msg.setText(message);
                        ball -= 1;
                        remainingBall.setText(String.valueOf(ball));
                        userTurn.setVisibility(View.INVISIBLE);
                        timer(2);
                    }
                }
                else
                    instruct.setText("WAIT");


            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instruct.setText("WAIT");
                if(flag) {
                    flag = false;
                    if (ball == 1) {
                        msg.setText("Click Start Again Button");
                    } else {
                        userChoice = 2;
                        String message = "You take 2 ball";
                        msg.setText(message);
                        ball -= userChoice;
                        remainingBall.setText(String.valueOf(ball));
                        userTurn.setVisibility(View.INVISIBLE);
                        timer(2);
                    }
                }
                else
                    instruct.setText("WAIT");

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instruct.setText("WAIT");
                if(flag) {
                    flag = false;
                    if (ball == 1) {
                        msg.setText("Click Start Again Button");
                    } else {
                        userChoice = 3;
                        String message = "You take 3 ball";
                        msg.setText(message);
                        ball -= userChoice;
                        remainingBall.setText(String.valueOf(ball));
                        userTurn.setVisibility(View.INVISIBLE);
                        timer(2);
                    }
                }
                else
                    instruct.setText("WAIT");

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instruct.setText("WAIT");
                if(flag) {
                    flag = false;
                    if (ball == 1) {
                        msg.setText("Click Start Again Button");
                    } else {
                        userChoice = 4;
                        String message = "You take 4 ball";
                        msg.setText(message);
                        ball -= userChoice;
                        remainingBall.setText(String.valueOf(ball));
                        userTurn.setVisibility(View.INVISIBLE);
                        timer(2);
                    }
                }
                else
                    instruct.setText("WAIT");

            }
        });
        startAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one.setVisibility(View.VISIBLE);
                two.setVisibility(View.VISIBLE);
                three.setVisibility(View.VISIBLE);
                four.setVisibility(View.VISIBLE);
                instruct.setVisibility(View.VISIBLE);

                winImg.setVisibility(View.INVISIBLE);
                winMsg.setVisibility(View.INVISIBLE);
                startAgain.setVisibility(View.INVISIBLE);

                ball = 21;
                msg.setText("");
                remainingBall.setText(String.valueOf(ball));

            }
        });
    }

    private void timer(int i) {
        new CountDownTimer(i * 1000 , 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                computerTurn.setVisibility(View.VISIBLE);

            }

            @Override
            public void onFinish() {

                computerChoice = 5-userChoice;
                String message = "Computer take "+computerChoice+" balls";
                msg.setText(message);
                ball -= computerChoice;
                remainingBall.setText(String.valueOf(ball));
                if(ball == 1){
                    winImg.setVisibility(View.VISIBLE);
                    winMsg.setVisibility(View.VISIBLE);
                    one.setVisibility(View.INVISIBLE);
                    two.setVisibility(View.INVISIBLE);
                    three.setVisibility(View.INVISIBLE);
                    four.setVisibility(View.INVISIBLE);
                    startAgain.setVisibility(View.VISIBLE);
                    instruct.setVisibility(View.INVISIBLE);

                }
                computerTurn.setVisibility(View.INVISIBLE);
                userTurn.setVisibility(View.VISIBLE);
                flag = true;
                instruct.setText("PLAY");



            }
        }.start();

    }
}
