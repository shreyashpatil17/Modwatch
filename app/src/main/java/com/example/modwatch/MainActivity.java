package com.example.modwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView clockTick;
    private Chronometer timeDisp;
    private Button startBtn, stopBtn;
    private Animation rounding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Finding IDs Of Elements
        clockTick = findViewById(R.id.clockTick);
        timeDisp = findViewById(R.id.timeDisp);
        startBtn = findViewById(R.id.startBtn);
        stopBtn = findViewById(R.id.stopBtn);

//        Hiding Buttons
        stopBtn.setAlpha(0);

//      Giving Animation File Of Clock Rotation
        rounding = AnimationUtils.loadAnimation(this, R.anim.rounding);

//      Assigning Function To Start Button
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Displaying Time
                    timeDisp.setBase(SystemClock.elapsedRealtime());
//                    Staring Rotating Animation
                    clockTick.startAnimation(rounding);
//                    Un-Hiding Stop Button Through Animation
                    stopBtn.animate().alpha(1).translationY(-80).setDuration(300).start();
//                    Hiding Stop Button Through Animation
                    startBtn.animate().alpha(0).setDuration(300).start();
//                    Starting Chronometer
                    timeDisp.start();

            }
        });


        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Stopping Animation
                clockTick.clearAnimation();
//                Un-Hide Start Button Through Animation
                startBtn.animate().alpha(1).translationY(-80).setDuration(300).start();
//                Hide Stop Button Through Animation
                stopBtn.animate().alpha(0).setDuration(300).start();
//              Stopping Chronometer
                timeDisp.stop();

            }
        });

    }
}