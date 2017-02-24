package com.example.rosemberg.sinemaps.listeners;

import android.content.Intent;
import android.view.View;

import com.example.rosemberg.sinemaps.activities.MainActivity;
import com.example.rosemberg.sinemaps.activities.PesqSinePorCod;

public class PesqSinePorCodOnClick implements View.OnClickListener{
    MainActivity mainActivity;

    public PesqSinePorCodOnClick(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mainActivity, PesqSinePorCod.class);
        mainActivity.startActivity(intent);
    }
}
