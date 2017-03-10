package com.example.rosemberg.sinemaps.listeners;
import android.Manifest;
import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import java.io.Serializable;
import java.util.ArrayList;

import com.example.rosemberg.sinemaps.activities.GpsActivity;
import com.example.rosemberg.sinemaps.activities.MainActivity;
import com.example.rosemberg.sinemaps.activities.SineMapa;
import com.example.rosemberg.sinemaps.sine.Sine;

/**
 * Created by adriell on 04/03/2017.
 */

public class Gps implements View.OnClickListener {
    private GpsActivity gpsActivity = null;

    public Gps(GpsActivity main){
        this.gpsActivity = main;
    }

    @Override
    public void onClick(View view){
        if(gpsActivity != null){
            Intent intent = new Intent(gpsActivity, SineMapa.class);
            intent.putExtra("lat", Double.parseDouble(gpsActivity.getLatitude()));
            intent.putExtra("long", Double.parseDouble(gpsActivity.getLongitude()));
            intent.putExtra("lista", (ArrayList<Sine>) gpsActivity.getListaSines());
            gpsActivity.startActivity(intent);
        }
    }
}
