package com.example.assingment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class quiz extends AppCompatActivity {

    TextView tvQueConter, tvTimer, tvQue,score;

    Button btOpt1, btOpt2, btOpt3, btOpt4;

    //list for que
    ArrayList<QuestionClass> queList = new ArrayList<>();

    int conter = 0;

    int sco=0;

    CountDownTimer tm;


    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        drawerLayout = findViewById(R.id.drawer_layout);

        tvQue = findViewById(R.id.tvQue);
        tvQueConter = findViewById(R.id.tvQueConter);
        tvTimer = findViewById(R.id.tvTimer);
        score=findViewById(R.id.Score);

        btOpt1 = findViewById(R.id.btOpt1);
        btOpt2 = findViewById(R.id.btOpt2);
        btOpt3 = findViewById(R.id.btOpt3);
        btOpt4 = findViewById(R.id.btOpt4);

        //load data
        queList.add(new QuestionClass("This is dummy Que 1", "ans 1", "ans 2",
                "ans 3", "ans 4", "ans 1"));
        queList.add(new QuestionClass("This is dummy Que 2", "ans 1", "ans 2",
                "ans 3", "ans 4", "ans 2"));
        queList.add(new QuestionClass("This is dummy Que 3", "ans 1", "ans 2",
                "ans 3", "ans 4", "ans 3"));
        queList.add(new QuestionClass("This is dummy Que 4", "ans 1", "ans 2",
                "ans 3", "ans 4", "ans 4"));
        //init conter
        //Random rand = new Random();
        conter =0;
                //rand.nextInt(2); // Gives n such that 0 <= n < 20


        //load ques and ans
        loadQuetions(conter);

        tvTimer.setText("12");
        //countdown time
        tm = new CountDownTimer(12 * 1000, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {

                Toast.makeText(getBaseContext(), "Quiz Over!",
                        Toast.LENGTH_LONG).show();
                score.setText("Score: "+ sco);


                //recreate();
            }


        };
    }



    public void loadQuetions(int n) {

        final QuestionClass q = queList.get(n);

        tvQueConter.setText((n + 1) + "/" + queList.size());

        tvTimer.setText("" + 12);
        if (tm != null) {
            tm.start();
        }

        tvQue.setText("#" + (n + 1) + " " + q.getQue());
        btOpt1.setText("" + q.getOpt1());
        btOpt2.setText("" + q.getOpt2());
        btOpt3.setText("" + q.getOpt3());
        btOpt4.setText("" + q.getOpt4());

        btOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt1.getText().equals(q.getRightOpt())) {
                    Toast.makeText(getBaseContext(), "Correct Answer!",
                            Toast.LENGTH_LONG).show();
                    sco=sco+1;

                    if (conter < (queList.size() - 1)) {
                        tm.cancel();
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(getBaseContext(), "All Question Completed!",
                                Toast.LENGTH_LONG).show();
                        score.setText("Score: "+ sco);
                        //MainActivity.redirectActivityS(this,Score.class);
                        //recreate();
                    }


                } else {
                    Toast.makeText(getBaseContext(), "Wrong Answer!",
                            Toast.LENGTH_LONG).show();
                    if (conter < (queList.size() - 1)) {
                        tm.cancel();
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(getBaseContext(), "All Question Completed!",
                                Toast.LENGTH_LONG).show();
                        score.setText("Score: "+ sco);
                        //MainActivity.redirectActivityS(this,Score.class);
                        //recreate();
                    }
                }


            }
        });

        //btn2
        btOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt2.getText().equals(q.getRightOpt())) {

                    Toast.makeText(getBaseContext(), "Correct Answer!",
                            Toast.LENGTH_LONG).show();
                    sco=sco+1;

                    if (conter < (queList.size() - 1)) {
                        tm.cancel();
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(getBaseContext(), "All Que Completed!", Toast.LENGTH_SHORT).show();
                        score.setText("Score: "+ sco);
                        //MainActivity.redirectActivityS(this,Score.class);
                        //recreate();
                    }

                } else {
                    Toast.makeText(getBaseContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();

                    if (conter < (queList.size() - 1)) {
                        tm.cancel();
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(getBaseContext(), "All Question Completed!",
                                Toast.LENGTH_LONG).show();
                        score.setText("Score: "+ sco);
                        //MainActivity.redirectActivityS(this,Score.class);
                        //recreate();
                    }
                }

            }
        });

        //btn 3
        btOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt3.getText().equals(q.getRightOpt())) {

                    Toast.makeText(getBaseContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                    sco=sco+1;
                    if (conter < (queList.size() - 1)) {
                        tm.cancel();
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(getBaseContext(), "All Que Completed!", Toast.LENGTH_SHORT).show();
                        score.setText("Score: "+ sco);
                        //MainActivity.redirectActivityS(this,Score.class);
                        //recreate();
                    }

                } else {
                    Toast.makeText(getBaseContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();

                    if (conter < (queList.size() - 1)) {
                        tm.cancel();
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(getBaseContext(), "All Question Completed!",
                                Toast.LENGTH_LONG).show();
                        score.setText("Score: "+ sco);
                        //MainActivity.redirectActivityS(this,Score.class);
                        //recreate();
                    }
                }

            }
        });

        //btn4
        btOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt4.getText().equals(q.getRightOpt())) {

                    Toast.makeText(getBaseContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                    sco=sco+1;
                    if (conter < (queList.size() - 1)) {
                        tm.cancel();
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(getBaseContext(), "All Que Completed!", Toast.LENGTH_SHORT).show();
                        score.setText("Score: "+ sco);
                        //MainActivity.redirectActivityS(this,Score.class);
                        //recreate();

                    }

                } else {
                    Toast.makeText(getBaseContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();

                    if (conter < (queList.size() - 1)) {
                        tm.cancel();
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(getBaseContext(), "All Question Completed!",
                                Toast.LENGTH_LONG).show();
                        score.setText("Score: "+ sco);
                        //MainActivity.redirectActivityS(this,Score.class);
                        //recreate();
                    }
                }

            }
        });

    }












    public void ClickMenu(View view){

        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickCal(View view){
        MainActivity.redirectActivity(this,Calculator.class);
    }
    public void ClickQuiz(View view){
        recreate();
    }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }
    @Override
    protected void onPause() {
        super.onPause();

        MainActivity.closeDrawer(drawerLayout);
    }



}