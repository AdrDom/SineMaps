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
import android.widget.TextView;

import com.example.rosemberg.sinemaps.activities.MainActivity;

/**
 * Created by adriell on 28/02/2017.
 */

public class Gps {
    private MainActivity main;
    private String latitude;
    private String longitude;
    //location
    private LocationManager lManager;
    private Location location;

    public Gps(MainActivity main){
        this.main = main;
    }
}
