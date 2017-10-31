package com.example.harfi.googlemapstest2.activity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.harfi.googlemapstest2.R;
import com.example.harfi.googlemapstest2.model.DaoSession;
import com.example.harfi.googlemapstest2.model.EventModel;
import com.example.harfi.googlemapstest2.util.AppController;

public class MapsActivity extends AppCompatActivity implements LocationListener {

    Location location;
    protected LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Log.d("GPS Enabled", "GPS Enabled");
            onLocationChanged(location);
            DaoSession session = ((AppController) this.getApplication()).getDaoSession();
            if(session.getEventModelDao().loadAll().size() == 0){
                session.getEventModelDao().insert(new EventModel(0,"Maintence",false));
            }
        }else {
            Toast.makeText(this, "GPS Failed", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        TextView longitude = (TextView) findViewById(R.id.textView);
        TextView latitude = (TextView) findViewById(R.id.textView1);

        longitude.setText("Current Longitude:" + location.getLongitude());
        latitude.setText("Current Latitude:" + location.getLatitude());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}