package com.example.nagaa.cricketscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class endActivity extends AppCompatActivity {
TextView resultTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Bundle bundle=getIntent().getExtras();
        resultTV=findViewById(R.id.result);
        resultTV.setText(bundle.getString("Result"));
    }
}
