package com.example.rosemberg.sinemaps.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.example.rosemberg.sinemaps.activities.GpsActivity;

import com.example.rosemberg.sinemaps.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SineMapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sine_mapa);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng CG = new LatLng(getIntent().getDoubleExtra("lat", -7.219204), getIntent().getDoubleExtra("long", -35.882901));
        mMap.addMarker(new MarkerOptions().position(CG).title("Campina Grande"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CG));
    }
}
