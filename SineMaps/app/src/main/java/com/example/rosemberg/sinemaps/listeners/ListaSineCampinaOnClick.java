package com.example.rosemberg.sinemaps.listeners;

import android.content.Intent;
import android.view.View;

import com.example.rosemberg.sinemaps.activities.ListaSineCampina;
import com.example.rosemberg.sinemaps.activities.MainActivity;

public class ListaSineCampinaOnClick implements View.OnClickListener{
    private MainActivity mainActivity;

    public ListaSineCampinaOnClick(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mainActivity, ListaSineCampina.class);
        mainActivity.startActivity(intent);
    }
}
