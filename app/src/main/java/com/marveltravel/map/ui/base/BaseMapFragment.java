package com.marveltravel.map.ui.base;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
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
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncher;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncherOptions;
import com.mapbox.services.android.navigation.ui.v5.route.NavigationMapRoute;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;
import com.marveltravel.map.R;
import com.marveltravel.map.utils.PermissionUtils;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

import static android.Manifest.permission;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconOffset;
import static com.marveltravel.map.BuildConfig.MAP_KEY;

//import android.location.Address;
//import com.mapbox.mapboxsdk.plugins.annotation.Symbol;
//import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager;

public abstract class BaseMapFragment extends BaseFragment implements OnMapReadyCallback, MapboxMap.OnMapClickListener {
    @BindView(R.id.mapView)
    MapView mapView;
    @BindView(R.id.start_navigating)
    Button startButton;
    private MapboxMap mapbox;
    //    private Symbol symbol;
//    private SymbolManager symbolManager;
    private Marker destinationMarker;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private static final LatLng locationOne = new LatLng(42.8700000, 74.5900000);
    private static final LatLng locationTwo = new LatLng(44.837058, 76.646234);
    private static final String TAG = "BaseMapFragment";
    private LocationComponent originLocation;
    private Point destinationPosition;
    private Point originPosition;
    private DirectionsRoute currentRoute;
    private NavigationMapRoute navigationMapRoute;
    private LatLng currentPosition = new LatLng();
    private ValueAnimator animator;
    private GeoJsonSource geoJsonSource;
    private FusedLocationProviderClient fusedLocationClient;
    private LocationComponent locationComponent;

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
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
    }

    private void clickListener() {
        startButton.setOnClickListener(view -> {
            boolean simulateRoute = true;
            NavigationLauncherOptions options = NavigationLauncherOptions.builder()
                    .directionsRoute(currentRoute)
                    .shouldSimulateRoute(simulateRoute)
                    .build();
// Call this method with Context from within an Activity
            NavigationLauncher.startNavigation(requireActivity(), options);
            //SOMETHING
        });
    }

    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {
        mapboxMap.setStyle(Style.SATELLITE_STREETS, style -> {
            mapbox = mapboxMap;
//            symbolManager = new SymbolManager(mapView,mapboxMap,style);
            enableLocationComponent(style);
//            addMarkerIconsToMap(style);
            clickListener();
            mapboxMap.addOnMapClickListener(this);
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(getActivity(), location -> {
                        if (location != null) {
                            cameraUpdate(new LatLng(location.getLatitude(), location.getLongitude()));

                        }
                    });
        });
    }

    private void cameraUpdate(LatLng latLng) {
        CameraPosition position = new CameraPosition.Builder()
                .target(latLng) // Sets the new camera position
                .zoom(17) // Sets the zoom
//                .bearing(180) // Rotate the camera
                .tilt(30) // Set the camera tilt
                .build(); // Creates a CameraPosition from the builder

        mapbox.animateCamera(CameraUpdateFactory
                .newCameraPosition(position), 7000);
    }

    /* private void createSymbol(LatLng point){
         SymbolOptions symbolOptions = new SymbolOptions()
                 .withLatLng(new LatLng(6.687337, 0.381457))
                 .withIconImage("icon-id")
                 .withSymbolSortKey(10.0f);
         if (symbol!=null) symbolManager.delete(symbol);
         symbol=symbolManager.create(symbolOptions);
     }
 */
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

            LocationComponent locationComponent = mapbox.getLocationComponent();

            LocationComponentActivationOptions activationOptions = LocationComponentActivationOptions.builder(
                    requireContext(), style
            ).locationComponentOptions(componentOptions)
                    .build();
            locationComponent.activateLocationComponent(activationOptions);
            locationComponent.setLocationComponentEnabled(true);

            locationComponent.setRenderMode(RenderMode.COMPASS);
            locationComponent.setCameraMode(CameraMode.TRACKING_COMPASS);
//            mapbox.animateCamera(CameraUpdateFactory.newCameraPosition(position), 7000);
        } else {
            requestAndCheckPermission();
        }
    }

    private void requestAndCheckPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), permission.ACCESS_FINE_LOCATION)) {
            new AlertDialog.Builder(requireContext())
                    .setTitle("Нужно Разрешение")
                    .setMessage("Нажмите на 'ok' и выберет действие")
                    .setPositiveButton("ok", (dialogInterface, i) -> ActivityCompat.requestPermissions(requireActivity(), new String[]{permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION)).setNegativeButton("cancel", (dialogInterface, i) -> dialogInterface.dismiss())
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
        }
    }

    @Override
    public boolean onMapClick(@NonNull LatLng point) {
        if (destinationMarker != null) {
            mapbox.removeMarker(destinationMarker);
        }
        destinationMarker = mapbox.addMarker(new MarkerOptions().position(point));
        Point destinationPoint = Point.fromLngLat(point.getLongitude(), point.getLatitude());
        Point originPoint = Point.fromLngLat(locationComponent.getLastKnownLocation().getLongitude(),
                locationComponent.getLastKnownLocation().getLatitude());
        if (animator != null && animator.isStarted()) {
            currentPosition = (LatLng) animator.getAnimatedValue();
            animator.cancel();
        }

        animator = ObjectAnimator
                .ofObject(latLngEvaluator, currentPosition, point)
                .setDuration(1500);
        animator.addUpdateListener(animatorUpdateListener);
        animator.start();

        currentPosition = point;

        CameraPosition position = new CameraPosition.Builder()
                .target(currentPosition) // Sets the new camera position
                .zoom(17) // Sets the zoom
                .bearing(360) // Rotate the camera
                .tilt(30) // Set the camera tilt
                .build(); // Creates a CameraPosition from the builder

        mapbox.animateCamera(CameraUpdateFactory
                .newCameraPosition(position), 7000);
        getRoute(originPoint, destinationPoint);
        startButton.setEnabled(true);
        startButton.setBackgroundResource(R.color.mapbox_blue);
//        LatLngBounds latLngBounds = new LatLngBounds.Builder()
//                .include(locationOne) // Northeast
//                .include(locationTwo) // Southwest
//                .build();
//        createSymbol(point);
//        mapbox.easeCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 50), 5000);/**/
        return true;
    }

    private void getRoute(Point origin, Point destination) {
        assert Mapbox.getAccessToken() != null;
        NavigationRoute.builder(requireContext())
                .accessToken(Mapbox.getAccessToken())
                .origin(origin)
                .destination(destination)
                .build()
                .getRoute(new Callback<DirectionsResponse>() {
                    @Override
                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                        Log.d(TAG, "Response code: " + response.code());
                        if (response.body() == null) {
                            Log.e(TAG, "No routes found, make sure you set the right user and access token.");
                            return;
                        } else if (response.body().routes().size() < 1) {
                            Log.e(TAG, "No routes found");
                            return;
                        }

                        currentRoute = response.body().routes().get(0);

// Draw the route on the map
                        if (navigationMapRoute != null) {
                            navigationMapRoute.removeRoute();
                        } else {
                            navigationMapRoute = new NavigationMapRoute(null, mapView, mapbox, R.style.NavigationMapRoute);
                        }
                        navigationMapRoute.addRoute(currentRoute);
                    }

                    @Override
                    public void onFailure(@NotNull Call<DirectionsResponse> call, @NotNull Throwable t) {
                        Timber.e("onFailure: %s", t.getMessage());
                    }
                });
    }

    private final ValueAnimator.AnimatorUpdateListener animatorUpdateListener =
            new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LatLng animatedPosition = (LatLng) valueAnimator.getAnimatedValue();
                    geoJsonSource.setGeoJson(Point.fromLngLat(animatedPosition.getLongitude(), animatedPosition.getLatitude()));
                }
            };

    // Class is used to interpolate the marker animation.
    private static final TypeEvaluator<LatLng> latLngEvaluator = new TypeEvaluator<LatLng>() {

        private final LatLng latLng = new LatLng();

        @Override
        public LatLng evaluate(float fraction, LatLng startValue, LatLng endValue) {
            latLng.setLatitude(startValue.getLatitude()
                    + ((endValue.getLatitude() - startValue.getLatitude()) * fraction));
            latLng.setLongitude(startValue.getLongitude()
                    + ((endValue.getLongitude() - startValue.getLongitude()) * fraction));
            return latLng;
        }
    };

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
    public void onSaveInstanceState(@NotNull Bundle outState) {
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
