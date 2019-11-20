package com.marveltravel.map.ui.base;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.LocationComponentOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.marveltravel.map.R;
import com.marveltravel.map.ui.main.MainActivity;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;

import static android.Manifest.*;
import static androidx.core.content.PermissionChecker.checkSelfPermission;
import static com.marveltravel.map.BuildConfig.MAP_KEY;

public abstract class BaseMapFragment extends BaseFragment implements OnMapReadyCallback, PermissionsListener {
    @BindView(R.id.mapView)
    MapView mapView;
    private MapboxMap mapbox;
    LocationComponent locationComponent;
    private LocationEngine locationEngine;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private LocationManager locationManager;
    String provider;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(requireContext(),
                MAP_KEY);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView.getMapAsync(this);
        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

        provider = locationManager.getBestProvider(new Criteria(), false);

        @SuppressLint("MissingPermission") Location location = null;
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        location = locationManager.getLastKnownLocation(provider);

        if (location != null) {

            Log.i("Location Info", "Location achieved!");

        } else {

            Log.i("Location Info", "No location :(");

        }

    }


    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {
        mapbox = mapboxMap;

        mapboxMap.setStyle(Style.MAPBOX_STREETS, style -> {

            // Toast instructing user to tap on the map
            Toast.makeText(
                    getContext(),
                    "Ok",
                    Toast.LENGTH_LONG
            ).show();
            checkLocationPermission(style);

        });
    }

    private void enableLocationComponent(Style style) {
    }

    @Override
    public boolean onMapClick(@NonNull LatLng point) {
        // Toast instructing user to tap on the map
        Toast.makeText(
                getContext(),
                "MapClick was pushed",
                Toast.LENGTH_LONG
        ).show();

        CameraPosition position = new CameraPosition.Builder()
                .target(new LatLng(51.50550, -0.07520)) // Sets the new camera position
                .zoom(17) // Sets the zoom
                .bearing(180) // Rotate the camera
                .tilt(30) // Set the camera tilt
                .build(); // Creates a CameraPosition from the builder

        mapbox.animateCamera(CameraUpdateFactory
                .newCameraPosition(position), 7000);

        return true;
    }

    public boolean checkLocationPermission(Style style) {
        if (ContextCompat.checkSelfPermission(requireContext(),
                permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),
                    permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(requireContext())
                        .setTitle("")
                        .setMessage("Location permission")
                        .setPositiveButton(R.string.ok, (dialogInterface, i) -> {
                            //Prompt the user once explanation has been shown
                            ActivityCompat.requestPermissions(requireActivity(),
                                    new String[]{permission.ACCESS_FINE_LOCATION},
                                    MY_PERMISSIONS_REQUEST_LOCATION);
                        })
                        .create()
                        .show();
                LocationComponentOptions locationComponentOptions = LocationComponentOptions.builder(requireContext())
                        .elevation(5)
                        .accuracyAlpha(.6f)
                        .accuracyColor(Color.BLUE)
                        .build();

                locationComponent = mapbox.getLocationComponent();
                LocationComponentActivationOptions activationOptions = LocationComponentActivationOptions.builder(requireContext(), style)
                        .locationComponentOptions(locationComponentOptions)
                        .build();
                locationComponent.activateLocationComponent(activationOptions);

                // Enable to make component visible
                locationComponent.setLocationComponentEnabled(true);

                // Set the component's camera mode
                locationComponent.setCameraMode(CameraMode.TRACKING_COMPASS);

                // Set the component's render mode
                locationComponent.setRenderMode(RenderMode.COMPASS);
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(requireActivity(),
                        new String[]{permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(requireContext(),
                            permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        //Request location updates:
                        locationManager.requestLocationUpdates(provider, 400, 1, (LocationListener) requireContext());
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return;
            }

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
//        if (ContextCompat.checkSelfPermission(requireContext(),
//                permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//
//            locationManager.requestLocationUpdates(provider, 400, 1, (LocationListener) Objects.requireNonNull(getActivity()));
//        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
//        if (ContextCompat.checkSelfPermission(requireContext(),
//                permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//
//            locationManager.removeUpdates((LocationListener) requireContext());
//        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mapbox != null) {
            mapbox.removeOnMapClickListener((MapboxMap.OnMapClickListener) requireContext());
        }
        mapView.onDestroy();
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {

    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            enableLocationComponent(mapbox.getStyle());
        }
    }

    @Override
    protected int getViewLayout() {
        return 0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
