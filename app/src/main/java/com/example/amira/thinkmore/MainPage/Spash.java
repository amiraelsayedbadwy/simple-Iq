package com.example.amira.thinkmore.MainPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.amira.thinkmore.Math.QuestionActivity;
import com.example.amira.thinkmore.R;
import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

public class Spash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);
        Thread mythread=new Thread() {

            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        mythread.start();



        CircularFillableLoaders circularFillableLoaders = (CircularFillableLoaders)findViewById(R.id.circularFillableLoaders);
// Set Progress
     /*   circularFillableLoaders.setProgress(60);
// Set Wave and Border Color
        circularFillableLoaders.setColor(Color.RED);
// Set Border Width
       // circularImageView.setBorderWidth(10 * getResources().getDisplayMetrics().density);
// Set Wave Amplitude (between 0.00f and 0.10f)
        circularFillableLoaders.setAmplitudeRatio(0.08);*/
    }
    }

