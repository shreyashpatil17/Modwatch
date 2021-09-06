package com.example.modwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private ImageView splashIMG;
    private Animation anim,btgone;
    private TextView head,subHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        Find Id Of Elements
        splashIMG = findViewById(R.id.splashIMG);
        head = findViewById(R.id.head);
        subHead = findViewById(R.id.subHead);

//        Add Animation To Button
        anim = AnimationUtils.loadAnimation(this, R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this,R.anim.btgone);

//        Adding Animation To Heading, Sub-Heading, And Image
        head.startAnimation(btgone);
        subHead.startAnimation(btgone);
        splashIMG.startAnimation(anim);

//        Delaying The SplashScreen For 3-Seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(splash);
                finish();
            }
        },3000);
    }
}