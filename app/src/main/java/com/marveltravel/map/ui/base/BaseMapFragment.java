package com.marveltravel.map.ui.base;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.LocationComponentOptions;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.plugins.annotation.Symbol;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager;
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import com.marveltravel.map.R;
import com.marveltravel.map.utils.PermissionUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;

import static android.Manifest.*;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconOffset;
import static com.marveltravel.map.BuildConfig.MAP_KEY;

public abstract class BaseMapFragment extends BaseFragment implements OnMapReadyCallback, MapboxMap.OnMapClickListener {
    @BindView(R.id.mapView)
    MapView mapView;
    private MapboxMap mapbox;
    LocationComponent locationComponent;
    private Symbol symbol;
    SymbolManager symbolManager;

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private static final LatLng locationOne = new LatLng(42.8700000, 74.5900000);
    private static final LatLng locationTwo = new LatLng(25.837058, -106.646234);


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

    }


    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {
        mapboxMap.setStyle(Style.SATELLITE_STREETS, style -> {
            mapbox = mapboxMap;
            symbolManager = new SymbolManager(mapView, mapboxMap,style);
            enableLocationComponent(style);
            addMarkerIconsToMap(style);
            mapboxMap.addOnMapClickListener(this);
        });
    }
    private void createSymbol(LatLng point){
        SymbolOptions symbolOptions = new SymbolOptions()
                .withLatLng(new LatLng(6.687337, 0.381457))
                .withIconImage("icon-id")
                .withSymbolSortKey(10.0f);
        if (symbol!=null) symbolManager.delete(symbol);
        symbol=symbolManager.create(symbolOptions);
    }

    private void addMarkerIconsToMap(@NonNull Style loadedMapStyle) {
        loadedMapStyle.addImageAsync("icon-id", Objects.requireNonNull(BitmapUtils.getBitmapFromDrawable(
                getResources().getDrawable(R.drawable.red_marker))));

        loadedMapStyle.addSource(new GeoJsonSource("source-id",
                FeatureCollection.fromFeatures(new Feature[]{
                        Feature.fromGeometry(Point.fromLngLat(locationOne.getLongitude(), locationOne.getLatitude())),
                        Feature.fromGeometry(Point.fromLngLat(locationTwo.getLongitude(), locationTwo.getLatitude())),
                })));

        loadedMapStyle.addLayer(new SymbolLayer("layer-id",
                "source-id").withProperties(
                iconImage("icon-id"),
                iconOffset(new Float[]{0f, -8f})
        ));
    }

    private void enableLocationComponent(Style style) {
        if (PermissionUtils.isPermissionGranted(getContext())) {
            Toast.makeText(requireContext(), "Вы имеете разрешение", Toast.LENGTH_SHORT).show();
            LocationComponentOptions componentOptions = LocationComponentOptions.builder(requireContext())
                    .elevation(5)
                    .accuracyAlpha(.6f)
                    .accuracyColor(Color.BLUE)
                    .build();

            locationComponent = mapbox.getLocationComponent();

            LocationComponentActivationOptions activationOptions = LocationComponentActivationOptions.builder(
                    requireContext(), style
            ).locationComponentOptions(componentOptions)
                    .build();

            locationComponent.activateLocationComponent(activationOptions);
            locationComponent.setLocationComponentEnabled(true);

            locationComponent.setRenderMode(RenderMode.COMPASS);
            locationComponent.setCameraMode(CameraMode.TRACKING_COMPASS);
            CameraPosition position = new CameraPosition.Builder()
                    .target(new LatLng(42.8700000, 74.5900000))
                    .zoom(16)
                    .bearing(180)
                    .tilt(20)
                    .build();
            mapbox.setCameraPosition(position);
            mapbox.animateCamera(CameraUpdateFactory.newCameraPosition(position), 7000);
        } else {
            requestAndCheckPermission();
        }
    }

    private void requestAndCheckPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), permission.ACCESS_FINE_LOCATION)) {
            new AlertDialog.Builder(requireContext())
                    .setTitle("Нужно Разрешение")
                    .setMessage("Нажмите на 'ok' и выберет действие")
                    .setPositiveButton("ok", (dialogInterface, i) -> {
                        ActivityCompat.requestPermissions(requireActivity(), new String[]{permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                    }).setNegativeButton("cancel", (dialogInterface, i) -> {
                dialogInterface.dismiss();
            })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
        }
    }

    @Override
    public boolean onMapClick(@NonNull LatLng point) {
//        LatLngBounds latLngBounds = new LatLngBounds.Builder()
//                .include(locationOne) // Northeast
//                .include(locationTwo) // Southwest
//                .build();
        createSymbol(point);
//        mapbox.easeCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 50), 5000);/**/
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(requireContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
                enableLocationComponent(mapbox.getStyle());
            } else {
                Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
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
            mapbox.removeOnMapClickListener(point -> false);
        }
        if (mapView != null) {
            mapView.onDestroy();
        }

    }


    @Override
    protected int getViewLayout() {
        return 0;
    }


}
