package com.iamstmvasan.stick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    Toolbar toolbar2;
    TextView msg_c , winMsg_c , instruct_c , error_c;
    Button remainingBall_c , one_c , two_c , three_c , four_c ,startAgain_c ;
    ImageView userTurn_c , computerTurn_c , winImg_c ;

    private int ball_c = 21;
    private int userChoice_c = 0 , computerChoice_c = 0;
    private boolean flag_c = true , second_flag = true , computer_win = false;
    private  List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar2 = findViewById(R.id.toolbar2);

        setSupportActionBar(toolbar2);
        getSupportActionBar().setTitle("Last Ball");
        toolbar2.setTitleTextColor(Color.parseColor("#34495E"));

        remainingBall_c = findViewById(R.id.remainingBall_c);
        msg_c = findViewById(R.id.msg_c);
        one_c = findViewById(R.id.one_c);
        two_c = findViewById(R.id.two_c);
        three_c = findViewById(R.id.three_c);
        four_c = findViewById(R.id.four_c);
        startAgain_c = findViewById(R.id.startAgain_c);

        userTurn_c = findViewById(R.id.user_turn_c);
        computerTurn_c = findViewById(R.id.computer_turn_c);
        winImg_c = findViewById(R.id.winimg_c);
        winMsg_c = findViewById(R.id.winmsg_c);
        instruct_c = findViewById(R.id.instruct_c);
        error_c = findViewById(R.id.error_c);

        timer_c(2);

        one_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instruct_c.setText("WAIT");
                if(flag_c) {
                    flag_c = false;
                    userChoice_c = 1;
                    String message = "You take 1 ball";
                    msg_c.setText(message);
                    ball_c -= 1;
                    remainingBall_c.setText(String.valueOf(ball_c));
                    userTurn_c.setVisibility(View.INVISIBLE);
                    computerTurn_c.setVisibility(View.VISIBLE);
                    if(ball_c == 1){
                        wining("You Win the Match");
                    }
                    else if(ball_c == 0){
                        wining("Computer Win the Match");
                    }
                    else
                        timer_c(2);
                }
                else
                    instruct_c.setText("WAIT");


            }
        });
        two_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instruct_c.setText("WAIT");
                if (flag_c) {
                    flag_c = false;
                    userChoice_c = 2;
                    String message = "You take 2 Ball's";
                    msg_c.setText(message);
                    ball_c -= 2;
                    remainingBall_c.setText(String.valueOf(ball_c));
                    userTurn_c.setVisibility(View.INVISIBLE);
                    computerTurn_c.setVisibility(View.VISIBLE);
                    if(ball_c == 1){
                        wining("You Win the Match");
                    }
                    else if(ball_c == 0){
                        wining("Computer Win the Match");
                    }
                    else
                        timer_c(2);
                } else
                    instruct_c.setText("WAIT");
            }
        });
        three_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instruct_c.setText("WAIT");
                if(flag_c) {
                    flag_c = false;
                    userChoice_c = 3;
                    if (userChoice_c > ball_c) {
                        error_c.setVisibility(View.VISIBLE);
                        error_c.setTextColor(Color.RED);
                        error_c.setText("Your choice is greater than Remaining ball\n\t\t\t\t\t\tChoose Again");
                        flag_c = true;
                        instruct_c.setText("PLAY");
                    } else {
                        error_c.setVisibility(View.INVISIBLE);
                        String message = "You take 3 Ball's";
                        msg_c.setText(message);
                        ball_c -= 3;
                        remainingBall_c.setText(String.valueOf(ball_c));
                        userTurn_c.setVisibility(View.INVISIBLE);
                        computerTurn_c.setVisibility(View.VISIBLE);
                        if (ball_c == 1) {
                            wining("You Win the Match");
                        }
                        else if (ball_c == 0) {
                            wining("You are Losing");
                        }
                        else
                            timer_c(2);
                    }
                }
                else
                    instruct_c.setText("WAIT");

            }
        });
        four_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instruct_c.setText("WAIT");
                if(flag_c) {
                    flag_c = false;

                    userChoice_c = 4;
                    if (userChoice_c > ball_c) {
                        error_c.setVisibility(View.VISIBLE);
                        error_c.setTextColor(Color.RED);
                        error_c.setText("Your choice is greater than Remaining ball\n\t\t\t\t\t\tChoose Again");
                        flag_c = true;
                        instruct_c.setText("PLAY");
                    } else {
                        error_c.setVisibility(View.INVISIBLE);
                        String message = "You take 4 Ball's";
                        msg_c.setText(message);
                        ball_c -= 4;
                        remainingBall_c.setText(String.valueOf(ball_c));
                        userTurn_c.setVisibility(View.INVISIBLE);
                        computerTurn_c.setVisibility(View.VISIBLE);

                        if (ball_c == 1) {
                            wining("You Win the Match");
                        } else if (ball_c == 0) {
                            wining("Computer Win the Match");
                        } else
                            timer_c(2);
                    }
                }
                else
                    instruct_c.setText("WAIT");

            }
        });

        startAgain_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one_c.setVisibility(View.VISIBLE);
                two_c.setVisibility(View.VISIBLE);
                three_c.setVisibility(View.VISIBLE);
                four_c.setVisibility(View.VISIBLE);
                instruct_c.setVisibility(View.VISIBLE);

                winImg_c.setVisibility(View.INVISIBLE);
                winMsg_c.setVisibility(View.INVISIBLE);
                startAgain_c.setVisibility(View.INVISIBLE);

                userTurn_c.setVisibility(View.INVISIBLE);
                computerTurn_c.setVisibility(View.VISIBLE);
                second_flag = true;
                flag_c = false;
                computer_win = false;

                ball_c = 21;
                msg_c.setText("");
                remainingBall_c.setText(String.valueOf(ball_c));
                timer_c(2);
            }
        });



    }

    private void wining(String winner) {
        startAgain_c.setVisibility(View.VISIBLE);
        winMsg_c.setVisibility(View.VISIBLE);
        winImg_c.setVisibility(View.VISIBLE);
        winMsg_c.setText(winner);

        one_c.setVisibility(View.INVISIBLE);
        two_c.setVisibility(View.INVISIBLE);
        three_c.setVisibility(View.INVISIBLE);
        four_c.setVisibility(View.INVISIBLE);
        instruct_c.setVisibility(View.INVISIBLE);
        error_c.setVisibility(View.INVISIBLE);
    }

    private void timer_c(int i) {
        CountDownTimer countDownTimer = new CountDownTimer(i*1000 , 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if(second_flag){
                    second_flag = false;
                    list = new ArrayList<Integer>();
                    for(int i=1;i<=4;i++)
                        list.add(i);
                    Collections.shuffle(list);
                    computerChoice_c = list.get(0);
                    msg_c.setText("Computer take "+computerChoice_c+" Ball's");
                    ball_c -= computerChoice_c;
                    remainingBall_c.setText(String.valueOf(ball_c));
                    computerTurn_c.setVisibility(View.INVISIBLE);
                    userTurn_c.setVisibility(View.VISIBLE);
                    instruct_c.setText("PLAY");
                    flag_c = true;
                }
                else if(computer_win)
                    computerWin();
                else if((userChoice_c + computerChoice_c) == 5)
                    randomSelection();
                else if((userChoice_c + computerChoice_c) != 5)
                    perfectSelection();



            }
        }.start();
    }

    private void randomSelection() {
        Collections.shuffle(list);
        computerChoice_c = list.get(0);
        msg_c.setText("Computer take "+computerChoice_c+" Ball's");
        ball_c -= computerChoice_c;
        remainingBall_c.setText(String.valueOf(ball_c));
        computerTurn_c.setVisibility(View.INVISIBLE);
        userTurn_c.setVisibility(View.VISIBLE);
        instruct_c.setText("PLAY");
        flag_c = true;
    }
    private void perfectSelection(){
        if(ball_c <= 5){
            computerChoice_c = ball_c - 1;
            msg_c.setText("Computer take "+computerChoice_c+" Ball's");
            ball_c -= computerChoice_c;
            remainingBall_c.setText(String.valueOf(ball_c));
            computerTurn_c.setVisibility(View.INVISIBLE);
            userTurn_c.setVisibility(View.VISIBLE);
            wining("Computer Win the Match");
        }
        else {
            int start = computerChoice_c + userChoice_c;
            int count = 0;
            for (int i = start; i <= 10; i++) {
                if (i % 5 != 0)
                    count++;
                else
                    break;
            }
            computerChoice_c = count;
            msg_c.setText("Computer take "+computerChoice_c+" Ball's");
            ball_c -= computerChoice_c;
            remainingBall_c.setText(String.valueOf(ball_c));
            flag_c = true;
            computer_win = true;
            computerTurn_c.setVisibility(View.INVISIBLE);
            userTurn_c.setVisibility(View.VISIBLE);
            instruct_c.setText("PLAY");
        }

    }
    private void computerWin(){
        computerChoice_c = 5-userChoice_c;
        String message = "Computer take "+computerChoice_c+" balls";
        msg_c.setText(message);
        ball_c -= computerChoice_c;
        remainingBall_c.setText(String.valueOf(ball_c));
        computerTurn_c.setVisibility(View.INVISIBLE);
        userTurn_c.setVisibility(View.VISIBLE);
        instruct_c.setText("PLAY");
        flag_c = true;
        if(ball_c == 1){
            wining("Computer Win");
        }

    }
}
