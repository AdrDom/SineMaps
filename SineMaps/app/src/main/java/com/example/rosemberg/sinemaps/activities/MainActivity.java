package com.example.rosemberg.sinemaps.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.rosemberg.sinemaps.R;
import com.example.rosemberg.sinemaps.listeners.ListaSineBrasilOnClick;
import com.example.rosemberg.sinemaps.listeners.ListaSineCampinaOnClick;
import com.example.rosemberg.sinemaps.listeners.SineMapaOnClick;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnSineBrasil;
    private ImageButton btnSineCampina;
    private ImageButton btnSineMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSineBrasil = (ImageButton) findViewById(R.id.btnSineBrasil);
        btnSineCampina = (ImageButton) findViewById(R.id.btnSineCampina);
        btnSineMapa = (ImageButton) findViewById(R.id.btnSineMapa);

        btnSineBrasil.setOnClickListener(new ListaSineBrasilOnClick(this));
        btnSineCampina.setOnClickListener(new ListaSineCampinaOnClick(this));
        btnSineMapa.setOnClickListener(new SineMapaOnClick(this));
    }
}
