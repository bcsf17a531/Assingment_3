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
import java.util.Collections;
import java.util.Random;

public class quiz extends AppCompatActivity {

    TextView tvQueConter, tvTimer, tvQue,score;

    Button btOpt1, btOpt2, btOpt3, btOpt4;

    //list for que
    ArrayList<QuestionClass> queList = new ArrayList<>();



    //Random rand = new Random();
    int conter=0;
    //= rand.nextInt(9);


   //int counter=0;

    int[] myNum={11};

    int count=0;
    int sco=0;
    int count1=1;
    int n1=0;

    int j=1;

    CountDownTimer tm;

    ArrayList<Integer> arrayList = new ArrayList<Integer>();

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
        queList.add(new QuestionClass("Who is current PM of Pakistan?", "Qamar Javed Bajwa", "Imran Khan",
                "Nawaz Sharif", "Parwez Musharaf", "Imran Khan"));
        queList.add(new QuestionClass("Who among the following persons is called ' Desert Fox '", " Walter Scott", "Erwin Rommel",
                " Eisenhower", " Bismarck", "Erwin Rommel"));
        queList.add(new QuestionClass("Ctrl, Shift and Alt are called .......... keys.", " modifier", "function",
                "alphanumeric", "adjustment", "modifier"));
        queList.add(new QuestionClass("MS-Word is an example of _____", " An operating system", "A processing device",
                " Application software", " An input device", "Application software"));
        queList.add(new QuestionClass("A computer cannot \"boot\" if it does not have the _____", " Compiler", "Loader",
                " Operating system", "Assembler", "Operating system"));
        queList.add(new QuestionClass("________ is the process of dividing the disk into tracks and sectors", " Tracking", " Formatting",
                "  Crashing", "Allotting", " Formatting"));
        queList.add(new QuestionClass("Junk e-mail is also called ______", " Spam", "Spoof",
                "Sniffer Script", " Spool", "Spam"));
        queList.add(new QuestionClass("_____are attempts by individuals to obtain confidential information from you by falsifying their identity", " Phishing trips", "Computer viruses",
                " Phishing scams", " Spyware scams", "Phishing scams"));
        queList.add(new QuestionClass("By default, your documents print in ________ mode", "Landscape", "Portrait",
                " Page Setup", "  Print View", "Portrait"));
        queList.add(new QuestionClass("Which of the following is a popular programming language for developing multimedia webpages.", "  COBOL", "Java",
                " BASIC", " Assembler", "Java"));



//        conter=myNum[j];




        //init conter




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
                btOpt1.setVisibility(View.GONE);
                btOpt2.setVisibility(View.GONE);
                btOpt3.setVisibility(View.GONE);
                btOpt4.setVisibility(View.GONE);
                tvQue.setVisibility(View.GONE);
                tvQueConter.setVisibility(View.GONE);
                tvTimer.setVisibility(View.GONE);



            }


        };
    }


//public int getConter(){
//    ArrayList<Integer> list = new ArrayList<Integer>();
//    for (int i=0; i<10; i++) {
//        list.add(new Integer(i));
//    }
//    Collections.shuffle(list);
//    for (int i=0; i<10; i++) {
//        myNum[i]=list.get(i);
//    }
//    counter=myNum[j];
//    j=j+1;
//    return counter;
//}




    public void loadQuetions(int n) {


        Random random = new Random();


        while (arrayList.size() < 10) { // how many numbers u need - it will 6
            int a = random.nextInt(10); // this will give numbers between 1 and 50.

            if (!arrayList.contains(a)) {
                arrayList.add(a);
                n=a;
            }
        }


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
                    if (conter < (queList.size() - 1))  {
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