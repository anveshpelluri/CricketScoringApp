package com.example.nagaa.cricketscore;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Bowling extends AppCompatActivity {
 Button b1,b2,b3,b4,b5,runbtn1,runbtn2,runbtn3,runbtn4,runbtn5,wcktbtn1,wcktbtn2,wcktbtn3,wcktbtn4,wcktbtn5;
 TextView teamNameTV;
 int num=1;
 int runs[]={0,0,0,0,0};
 int wickets[]={0,0,0,0,0};
 String teamName="";
 Toolbar my_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bowling);
        my_toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(my_toolbar);
        b1=findViewById(R.id.b1_btn);
        b2=findViewById(R.id.b2_btn);
        b3=findViewById(R.id.b3_btn);
        b4=findViewById(R.id.b4_btn);
        b5=findViewById(R.id.b5_btn);
        runbtn1=findViewById(R.id.r1_btn);
        runbtn2=findViewById(R.id.r2_btn);
        runbtn3=findViewById(R.id.r3_btn);
        runbtn4=findViewById(R.id.r4_btn);
        runbtn5=findViewById(R.id.r5_btn);
        wcktbtn1=findViewById(R.id.w1_btn);
        wcktbtn2=findViewById(R.id.w2_btn);
        wcktbtn3=findViewById(R.id.w3_btn);
        wcktbtn4=findViewById(R.id.w4_btn);
        wcktbtn5=findViewById(R.id.w5_btn);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null) {
            teamName = bundle.getString("TeamName1");
            runs = bundle.getIntArray("BowlerRuns");
            wickets = bundle.getIntArray("BowlerWickets");
        }
        teamNameTV=findViewById(R.id.team_name);
        if(teamName=="Team-B")
        {
           teamName="Team-A";
        }
        else {
        teamName="Team-B";
        }
        teamNameTV.setText(teamName);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAction(1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAction(2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAction(3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAction(4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAction(5);
            }
        });
        runbtn1.setText(runs[0]+"");
        runbtn2.setText(runs[1]+"");
        runbtn3.setText(runs[2]+"");
        runbtn4.setText(runs[3]+"");
        runbtn5.setText(runs[4]+"");
        wcktbtn1.setText(wickets[0]+"");
        wcktbtn2.setText(wickets[1]+"");
        wcktbtn3.setText(wickets[2]+"");
        wcktbtn4.setText(wickets[3]+"");
        wcktbtn5.setText(wickets[4]+"");
        }
        void btnAction(int num)
        {
            this.num=num;
            navMainActiv(this.num);
            }


        void navMainActiv(int num)
        {
            Intent intent=new Intent(Bowling.this,MainActivity.class);
            intent.putExtra("BowlerNum",num);
            startActivity(intent);
        }
    }

