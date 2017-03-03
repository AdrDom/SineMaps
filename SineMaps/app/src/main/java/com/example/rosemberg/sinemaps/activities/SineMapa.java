package com.example.rosemberg.sinemaps.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

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

        LatLng ifpb = new LatLng(-7.2361805, -35.915807);
        mMap.addMarker(new MarkerOptions().position(ifpb).title("IFPB - Campina Grande"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ifpb));
    }
}
