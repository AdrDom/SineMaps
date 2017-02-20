package com.example.rosemberg.sinemaps.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.rosemberg.sinemaps.R;
import com.example.rosemberg.sinemaps.listeners.ListaSineBrasilOnClick;
import com.example.rosemberg.sinemaps.listeners.ListaSineCampinaOnClick;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnSineBrasil;
    private ImageButton btnSineCampina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSineBrasil = (ImageButton) findViewById(R.id.btnSineBrasil);
        btnSineCampina = (ImageButton) findViewById(R.id.btnSineCampina);

        btnSineBrasil.setOnClickListener(new ListaSineBrasilOnClick(this));
        btnSineCampina.setOnClickListener(new ListaSineCampinaOnClick(this));
    }
}
