package com.example.rosemberg.sinemaps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iniciaSplash();
    }

    public void iniciaSplash(){
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                counter++;

                try {
                    while(counter == 1 || counter <= 5){
                        Thread.sleep(1000);
                        counter++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(counter == 6){
                    Intent it = new Intent(Splash.this, MainActivity.class);
                    startActivity(it);

                    counter++;
                }
            }
        }).start();
    }
}