package com.example.george.stopwatch;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private int second = 0;
private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
        Button BtnPause = (Button) findViewById(R.id.button3);
        BtnPause.setEnabled(false);
        BtnPause.setTextColor(Color.BLUE);
    }
    public void onStrart(View view){
        Button startBtn = (Button) findViewById(R.id.button);
        startBtn.setText("RESUME .");
        startBtn.setBackgroundColor(Color.rgb(255,40,40));
        Button BtnPause = (Button) findViewById(R.id.button3);
        BtnPause.setEnabled(true);
        BtnPause.setBackgroundColor(Color.rgb(255,255,255));
//        startBtn.setBackgroundColor("@colors/accent");
        running = true;
    }
    public void onStop(View view){
      running = false;
      second = 0;
        Button startBtn = (Button) findViewById(R.id.button);
        startBtn.setText("START.");
        startBtn.setBackgroundColor(Color.rgb(0,255,0));
        Button BtnPause = (Button) findViewById(R.id.button3);
        BtnPause.setEnabled(false);
    }
    public void onPause(View view){
       running = false;
    }

    public void runTimer(){
        final TextView timeView = (TextView) findViewById(R.id.time);
        final Handler handler = new Handler();
        handler.post(new Runnable (){
            @Override
            public  void run(){
                int hours = second/3600;
                int seconds = second%60;
                int minutes = second/60;
                String time = String.format("%d : %02d : %02d", hours,minutes,seconds);
                timeView.setText(time);

                if(running){
                    second++;
                }
                handler.postDelayed(this,1000);
            }

        });
    }
}
