package com.example.jenny.raitsn;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private Marker marcador;
    double lat = 0;
    double lng = 0;
    private Object Bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_maps );
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById( R.id.map );
        mapFragment.getMapAsync( this );
        String coordenadasx = null, coordenadasy = null;
    }




     @Override
     public void onMapReady(GoogleMap googleMap) {
         mMap = googleMap;
         miUbicacion();


     }


     private void agregarMarcadores(double lat, double lng) {
         LatLng coordenadas = new LatLng(lat, lng);
         CameraUpdate miubicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 16);
         if (marcador != null) marcador.remove();
         marcador = mMap.addMarker(new MarkerOptions().position(coordenadas).title("Pocision actual")
                 .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
         mMap.animateCamera(miubicacion);
     }

     private void actualizarUbicacion(Location location) {
         if (location != null) {
             lat = location.getLatitude();
             lng = location.getLongitude();
             agregarMarcadores(lat, lng);
         }

     }



     private String downloadUrl(String strUrl) throws IOException {
         String data = "";
         InputStream iStream = null;
         HttpURLConnection urlConnection = null;
         try{
             URL url = new URL(strUrl);

             // Creamos una conexion http
             urlConnection = (HttpURLConnection) url.openConnection();

             // Conectamos
             urlConnection.connect();

             // Leemos desde URL
             iStream = urlConnection.getInputStream();

             BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

             StringBuffer sb = new StringBuffer();

             String line = "";
             while( ( line = br.readLine()) != null){
                 sb.append(line);
             }

             data = sb.toString();

             br.close();

         }catch(Exception e){
             Log.d("Exception", e.toString());
         }finally{
             iStream.close();
             urlConnection.disconnect();
         }
         return data;
     }
   
     LocationListener locationListener = new LocationListener() {
         @Override
         public void onLocationChanged(Location location) {
             actualizarUbicacion(location);
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
     };

     private void miUbicacion() {

         if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

             return;
         }
         LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
         Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
         actualizarUbicacion(location);
         locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,15000,0,locationListener);
     }


 }











