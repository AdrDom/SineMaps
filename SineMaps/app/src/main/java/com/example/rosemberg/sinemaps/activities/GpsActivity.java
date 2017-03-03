package com.example.rosemberg.sinemaps.activities;
import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.rosemberg.sinemaps.R;
import com.example.rosemberg.sinemaps.asynctasks.ListaSineAsyncTask;
import com.example.rosemberg.sinemaps.sine.Sine;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Adriell on 28/02/2017.
 */

public class GpsActivity extends Activity implements LocationListener{
    private String longitude;
    private String latitude;
    //localização
    private final int REQUEST_LOCATION = 200;
    private LocationManager lManager;
    private Location location;
    //AsyncTask
    private ListaSineAsyncTask ListaSineAsyncTask;
    //Lists
    private ListView lista;
    private List<Sine> ListaSines;
    private ArrayAdapter<Sine> adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_gps); criar activity
        ListaSineAsyncTask = new ListaSineAsyncTask();
        init();
    }

    public ArrayAdapter<Sine> getAdapter() {
        return adapter;
    }

    public void setAdapter(ArrayAdapter<Sine> adapter) {
        this.adapter = adapter;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setListaSines(List<Sine> ListaSines) {
        this.ListaSines = ListaSines;
    }

    public List<Sine> getListaSines() {
        return ListaSines;
    }

    public ListView getLista() {
        return lista;
    }

    public void setLista(ListView lista) {
        this.lista = lista;//precisa do adapter
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = String.valueOf(location.getLatitude());
        longitude = String.valueOf(location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public void init(){
        //iniciando comunicação com o gps do celular
        lManager = (LocationManager) this.getSystemService(Service.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                      new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                             Manifest.permission.ACCESS_FINE_LOCATION},
                      REQUEST_LOCATION);
        } else {
            // Se ja tiver a permissão
            lManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 2, this);

            if (lManager != null) {
                // Localização atualizada
                location = lManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }
        }


    }
    private void showGPSDisabledAlertToUser() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("habilite o GPS")
                .setCancelable(false)
                .setPositiveButton("Direcione para as configurações para habilitar o GPS.", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent callGPSSettingIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(callGPSSettingIntent);
                    }
                });

        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }


}

