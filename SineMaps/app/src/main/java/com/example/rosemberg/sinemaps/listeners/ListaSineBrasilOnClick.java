package com.example.rosemberg.sinemaps.listeners;

import android.content.Intent;
import android.view.View;

import com.example.rosemberg.sinemaps.activities.ListaSineBrasil;
import com.example.rosemberg.sinemaps.activities.MainActivity;

public class ListaSineBrasilOnClick implements View.OnClickListener{
    private MainActivity mainActivity;

    public ListaSineBrasilOnClick(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mainActivity, ListaSineBrasil.class);
        mainActivity.startActivity(intent);
    }
}