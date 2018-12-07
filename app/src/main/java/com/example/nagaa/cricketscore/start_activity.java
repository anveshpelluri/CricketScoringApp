package com.example.nagaa.cricketscore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class start_activity extends AppCompatActivity {
    ProgressBar progressBar;
    RadioGroup r1,r2,r3,r4;
    RadioButton radioButton;
    TextView tvtossRes;
    int toss_result[]=new int[2];
    int toss,res,overs;
    String team_bat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        r1 = findViewById(R.id.rg1);
        r2 = findViewById(R.id.rg2);
        r3 = findViewById(R.id.rg3);
        r4 = findViewById(R.id.rg4);
        tvtossRes = findViewById(R.id.toss_res);
        progressBar = findViewById(R.id.pb);
        r1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.teama_rb) {
                    toss_result[0] = 0;
                } else {
                    toss_result[0] = 1;
                }
            }
        });
        r2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.heads_rb) {
                    toss = 0;
                }
                else {
                    toss = 1;
                }
              /*  progressBar.setVisibility(View.VISIBLE);
                progressBar.setIndeterminate(true);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                int temp = new Random().nextInt(2);
               // progressBar.setVisibility(View.INVISIBLE);
                if (temp == 0) {
                    tvtossRes.setText("It's Heads");
                } else {
                    tvtossRes.setText("It's Tails");
                  //  progressBar.setVisibility(View.VISIBLE);
                }
              /*  try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
               // progressBar.setVisibility(View.INVISIBLE);
                if (temp == toss) {
                    radioButton = findViewById(r1.getCheckedRadioButtonId());
                    tvtossRes.setText(radioButton.getText() + " has won the toss");
                    res = 1;
                } else {
                    radioButton = findViewById(r1.getCheckedRadioButtonId());
                    tvtossRes.setText(radioButton.getText() + " has lost the toss");
                }
            }
        });

        r3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.bat_rb)
                    toss_result[1] = 0;
                else
                    toss_result[1] = 1;
                if (toss_result[0] == 0 && toss_result[1] == 0 && res == 1) {
                    Toast.makeText(start_activity.this, "Team-A has won the toss and chose to BAT ", Toast.LENGTH_SHORT).show();
                    team_bat = "Team-A";
                } else if (toss_result[0] == 0 && toss_result[1] == 0 && res == 0) {
                    Toast.makeText(start_activity.this, "Team-B has won the toss and chose to BAT", Toast.LENGTH_SHORT).show();
                    team_bat = "Team-B";
                } else if (toss_result[0] == 0 && toss_result[1] == 1 && res == 1) {
                    Toast.makeText(start_activity.this, "Team-A has won the toss and chose to BOWL", Toast.LENGTH_SHORT).show();
                    team_bat = "Team-B";
                } else if (toss_result[0] == 0 && toss_result[1] == 1 && res == 0) {
                    Toast.makeText(start_activity.this, "Team-B has won the toss and chose to BOWL", Toast.LENGTH_SHORT).show();
                    team_bat = "Team-A";
                } else if (toss_result[0] == 1 && toss_result[1] == 0 && res == 1) {
                    Toast.makeText(start_activity.this, "Team-B has won the toss and chose to BAT", Toast.LENGTH_SHORT).show();

                    team_bat = "Team-B";
                } else if (toss_result[0] == 1 && toss_result[1] == 0 && res == 0) {
                    Toast.makeText(start_activity.this, "Team-A has won the toss and chose to BAT", Toast.LENGTH_SHORT).show();
                    team_bat = "Team-A";
                } else if (toss_result[0] == 1 && toss_result[1] == 1 && res == 1) {
                    Toast.makeText(start_activity.this, "Team-B has won the toss and chose to BOWl", Toast.LENGTH_SHORT).show();
                    team_bat = "Team-A";
                } else if (toss_result[0] == 1 && toss_result[1] == 1 && res == 0) {
                    Toast.makeText(start_activity.this, "Team-A has won the toss and chose to BOWL ", Toast.LENGTH_SHORT).show();
                    team_bat = "Team-B";
                } else {

                }
            }

        });
        r4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
              if(i==R.id.five_ov) {
                  overs=5;
                  nextActiv();
              }
              else {
                  overs=10;
                  nextActiv();
              }
              }
              });
    }
    void nextActiv()
    {
        Intent intent=new Intent(start_activity.this,MainActivity.class);
        intent.putExtra("Overs",overs);
        intent.putExtra("TeamName",team_bat);
        startActivity(intent);
    }
    }


