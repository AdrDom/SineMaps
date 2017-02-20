package com.example.rosemberg.sinemaps.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.rosemberg.sinemaps.R;

public class Splash extends Activity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(this, 4000);
    }

    public void run(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}