package com.example.nagaa.cricketscore;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button  btn0,btn1,btn2,btn3,btn4,btn6,btnwd,btnwkt,btnnb,done;
    static int firstTeamRuns;
   static int i=0;
   static int wkts=0,bowler=1,balls=0,total_score=0,player=1,overs;
   static int playerruns[]={0,0,0,0,0,0,0,0,0,0};
   static int bowlerruns[]={0,0,0,0,0};
   static int bowlerwckts[]={0,0,0,0,0};
   static  String getTeamName="";
   Toolbar my_toolbar;
   TextView teamName,playerNameTV,bowlerTV,wicketsTV,scoreTV,oversTV,runRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle bundle=getIntent().getExtras();
            bowler=bundle.getInt("BowlerNum",1);
            overs=bundle.getInt("Overs",overs);
            getTeamName=bundle.getString("TeamName",getTeamName);
            setContentView(R.layout.activity_main);
            my_toolbar=(Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(my_toolbar);
            teamName=findViewById(R.id.team_name);
            oversTV=findViewById(R.id.overs);
            runRate=findViewById(R.id.run_rate);
            bowlerTV=findViewById(R.id.bowlerTV);
            scoreTV=findViewById(R.id.runs);
            done=findViewById(R.id.done);
            wicketsTV=findViewById(R.id.wickets);
            btn0=findViewById(R.id.run0);
        btn1=findViewById(R.id.run1);
        btn2=findViewById(R.id.run2);
        btn3=findViewById(R.id.run3);
        btn4=findViewById(R.id.run4);
        btn6=findViewById(R.id.run6);
        btnwkt=findViewById(R.id.wckt);
        btnwd=findViewById(R.id.wide);
        btnnb=findViewById(R.id.nb);
            teamName.setText(getTeamName);
            playerNameTV=findViewById(R.id.player);
            bowlerTV.setText("Bowler-"+bowler);
            scoreTV.setText(total_score+"");
            wicketsTV.setText(wkts+"");
            playerNameTV.setText("Player-"+player+" Vs ");
            oversTV.setText("Overs : "+(balls/6)+"."+(balls%6));
            if(balls==0)
            {}
            else {
                runRate.setText("Run rate : " + (float) (total_score / (balls / 6)) + " rpo");
            }
            btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runButtonAction(0,1); }   });
            btn1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) { runButtonAction(1,1); }});
            btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runButtonAction(2,1);

            }
        });
            btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runButtonAction(3,1);

            }
        });
            btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runButtonAction(4,1);

            }
        });
            btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runButtonAction(6,1);

            }
        });
            btnnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runButtonAction(1,0);

            }
        });
            btnwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runButtonAction(1,0);

            }
        });
            btnwkt. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               wicketAction();

            }
        });
            done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0) {
                    firstTeamRuns = total_score;
                    wkts = 0;
                    bowler = 1;
                    balls = 0;
                    total_score = 0;
                    player = 1;
                    for (int i = 0; i < bowlerruns.length; i++) {
                        bowlerruns[i] = 0;
                        bowlerwckts[i] = 0;
                    }
                    for (int i = 0; i < playerruns.length; i++) {
                        playerruns[i] = 0;
                    }
                    if (getTeamName == "Team-B") {
                        getTeamName = "Team-A";
                    } else {
                        getTeamName = "Team-B";
                    }
                    Toast.makeText(MainActivity.this, getTeamName + " has begun", Toast.LENGTH_LONG);
                    i++;
                    recreate();

                }
                else
                {
                    if(total_score>firstTeamRuns)
                    {
                        Intent intent=new Intent(MainActivity.this,endActivity.class);
                        intent.putExtra("Result",getTeamName+" has won the match");
                        startActivity(intent);
                    }
                    else if(total_score==firstTeamRuns)
                    {
                        Intent intent=new Intent(MainActivity.this,endActivity.class);
                        intent.putExtra("Result","The match is tie");
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent=new Intent(MainActivity.this,endActivity.class);
                        if (getTeamName == "Team-B") {
                            getTeamName = "Team-A";
                        } else {
                            getTeamName = "Team-B";
                        }
                        intent.putExtra("Result",getTeamName+" has won the match");
                        startActivity(intent);
                    }
                }
            }
        });

            }
            void overChange()
           {
               oversTV.setText("Overs : "+(balls/6)+"."+(balls%6));
             if(balls%6==0) {
               nextActiv();

             }
             }
              boolean checkInningsend(int balls)
             {
                 if((this.balls/6)==overs)
                 {
                     Toast.makeText(MainActivity.this,"Innings completed press done",Toast.LENGTH_LONG);
                     return false;
                 }
                 else {
                    this.balls+=balls;
                     return true;
                 }
             }

         void wicketAction()
         {
             if(wkts<=9&&checkInningsend(1))
             {
                 wkts=wkts+1;
                 player+=1;
                 bowlerwckts[bowler-1]+=1;
                 playerNameTV.setText("Player-"+player+" Vs ");
                 wicketsTV.setText(wkts+"");
                 if (checkInningsend(0))
                     overChange();
             }
             else
             {
                 Toast.makeText(MainActivity.this,"Innings completed Press done",Toast.LENGTH_LONG).show();
             }
         }
     void runButtonAction(int run,int ball) {
        if (checkInningsend(ball)&&wkts<=9) {
            total_score +=run;
            scoreTV.setText(total_score+"");
            bowlerruns[bowler-1] +=run;
            playerruns[player-1] += run;
            if(i==1&&total_score>firstTeamRuns)

            {
                Intent intent=new Intent(MainActivity.this,endActivity.class);
                intent.putExtra("Result",getTeamName+" has won the match");
                startActivity(intent);
            }
            if (checkInningsend(0))
                overChange();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Innings completed Press done",Toast.LENGTH_LONG).show();
        }
    }

    void nextActiv()
    {
        Intent intent=new Intent(MainActivity.this,Bowling.class);
        intent.putExtra("Bowler",bowler);
        intent.putExtra("BowlerRuns",bowlerruns);
        intent.putExtra("BowlerWickets",bowlerwckts);
        intent.putExtra("TeamName1",getTeamName);
        startActivity(intent);
    }

}
