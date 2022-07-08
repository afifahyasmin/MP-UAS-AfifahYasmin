package com.afifah.uas_afifah_yasmin;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.afifah.uas_afifah_yasmin.databinding.ActivityMapsBinding;


public class Maps extends FragmentActivity implements OnMapReadyCallback{
    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng unpam = new LatLng(-6.347891, 106.741158);
        mMap.setMaxZoomPreference(1000);
        mMap.setMinZoomPreference(10);
        mMap.addMarker(new MarkerOptions().position(unpam).title("Marker in Universitas Pamulang"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(unpam));
    }
}
