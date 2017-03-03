package com.example.rosemberg.sinemaps.listeners;

import android.content.Intent;
import android.view.View;

import com.example.rosemberg.sinemaps.activities.MainActivity;
import com.example.rosemberg.sinemaps.activities.SineMapa;

public class SineMapaOnClick implements View.OnClickListener{
    private MainActivity mainActivity;

    public SineMapaOnClick(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mainActivity, SineMapa.class);
        mainActivity.startActivity(intent);
    }
}