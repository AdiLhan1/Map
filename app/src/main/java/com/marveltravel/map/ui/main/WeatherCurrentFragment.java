package com.marveltravel.map.ui.main;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.marveltravel.map.R;
import com.marveltravel.map.data.entity.weatherforecast.WeatherForecastFragment;
import com.marveltravel.map.data.entity.wheather.CurrentWeatherEntity;
import com.marveltravel.map.data.network.RetrofitBuilder;
import com.marveltravel.map.ui.base.BaseFragment;
import com.marveltravel.map.utils.DateTimeHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.marveltravel.map.BuildConfig.WEATHER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherCurrentFragment extends BaseFragment {
    private static final String SAVE_TEXT = "text_key";

    @BindView(R.id.weather_nowTemp)
    TextView temp;

    @BindView(R.id.weather_wind)
    TextView wind;

    @BindView(R.id.weather_sunrise)
    TextView sunrise;

    @BindView(R.id.weather_sunset)
    TextView sunset;

    @BindView(R.id.weather_humidity)
    TextView humidity;

    @BindView(R.id.weather_cloudiness)
    TextView cloudiness;

    @BindView(R.id.weather_pressure)
    TextView pressure;

    @BindView(R.id.weather_date)
    TextView date;

    @BindView(R.id.address)
    TextView address;

    @BindView(R.id.weather_maxTemp)
    TextView maxTemp;

    @BindView(R.id.weather_minTemp)
    TextView minTemp;

    @BindView(R.id.weather_description)
    TextView description;

    @BindView(R.id.weather_imageview)
    ImageView imageView;

    @BindView(R.id.change_place)
    ImageView changedPlace;

    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;

    @BindView(R.id.consts)
    ConstraintLayout constraintLayout;

    @BindView(R.id.bottom_sheet)
    View view1;

    public String youEditTextValue;
    private String countryText = "Bishkek";
    private SharedPreferences preferences;
    private BottomSheetBehavior bottomSheetBehavior;

    public WeatherCurrentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        onClick();
        loadText();
        showCurrenWeather();
        openForecast();
    }

    @Override
    protected int getViewLayout() {
        return R.layout.fragment_weather;
    }

    private void onClick() {
        changedPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                alertDialog.setTitle("Выбор страны");
                alertDialog.setMessage("Напишите страну, где вы хотите проверить погоду?");
                final EditText editText = new EditText(getContext());
                alertDialog.setView(editText);
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                youEditTextValue = editText.getText().toString();
                                Toast.makeText(getActivity(), youEditTextValue, Toast.LENGTH_SHORT).show();
                                address.setText(youEditTextValue);
                                countryText = youEditTextValue;
                                saveText();
                                showCurrenWeather();
                                sendCodeCountry();

                            }
                        });
                alertDialog.show();
            }
        });
    }

    private void initView(View view) {
        bottomSheetBehavior = BottomSheetBehavior.from(view1);
    }

    public void sendCodeCountry() {
        if (youEditTextValue != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key", youEditTextValue);
            WeatherForecastFragment forecastFragment = new WeatherForecastFragment();
            forecastFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container2, forecastFragment)
                    .commit();
        }
    }

    private void openForecast() {
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch (i) {
                    case BottomSheetBehavior.STATE_EXPANDED:
                        imageView.setVisibility(View.INVISIBLE);
                        linearLayout.setVisibility(View.INVISIBLE);
                        constraintLayout.setVisibility(View.INVISIBLE);
                        WeatherForecastFragment weatherForecastFragment = new WeatherForecastFragment();
                        sendCodeCountry();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .add(R.id.container2, weatherForecastFragment)
                                .addToBackStack(null)
                                .commit();
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        imageView.setVisibility(View.VISIBLE);
                        linearLayout.setVisibility(View.VISIBLE);
                        constraintLayout.setVisibility(View.VISIBLE);
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        imageView.setVisibility(View.INVISIBLE);
                        linearLayout.setVisibility(View.INVISIBLE);
                        constraintLayout.setVisibility(View.INVISIBLE);
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                Log.e("TAG", "onSlide: ");
            }
        });
    }

    private void saveText() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            preferences = Objects.requireNonNull(getActivity()).getPreferences(Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor ed = preferences.edit();
        String text = address.getText().toString();
        ed.putString(SAVE_TEXT, text);
        Log.e("TAG", "saveText: " + youEditTextValue);
        ed.apply();
        countryText = youEditTextValue;

    }

    private void loadText() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            preferences = Objects.requireNonNull(getActivity()).getPreferences(Context.MODE_PRIVATE);
        }
        String savedText = preferences.getString(SAVE_TEXT, "");
        Log.e("TAG", "loadText: " + savedText);
        address.setText(savedText);
        countryText = savedText;


    }

    private void showCurrenWeather() {
        RetrofitBuilder.getInstance().getCurrentweather(countryText, WEATHER_KEY, "metric")
                .enqueue(new Callback<CurrentWeatherEntity>() {
                    @Override
                    public void onResponse(Call<CurrentWeatherEntity> call, Response<CurrentWeatherEntity> response) {
                        Log.d("TAG", "onResponse: ");
                        CurrentWeatherEntity data = response.body();
                        if (data != null) {
                            pressure.setText(data.getMain().getPressure());
                            temp.setText(data.getMain().getTemp());
                            maxTemp.setText(data.getMain().getTemp_max());
                            minTemp.setText(data.getMain().getTemp_min());
                            humidity.setText(data.getMain().getHumidity());
                            wind.setText(data.getWind().getSpeed());
                            Glide.with((getContext())).load("http://openweathermap.org/img/wn/" + response.body().
                                    getWeather().get(0).getIcon() + "@2x.png").centerCrop().into(imageView);
                            description.setText(data.getWeather().get(0).getDescription());

                            sunrise.setText(DateTimeHelper.parseDateToTime(data.getSys().getSunrise()));
                            sunset.setText(DateTimeHelper.parseDateToTime( data.getSys().getSunset()));
                            date.setText(DateTimeHelper.getCurrentDateTime());
                            cloudiness.setText(data.getClouds().getAll());
                        }
                    }

                    @Override
                    public void onFailure(Call<CurrentWeatherEntity> call, Throwable t) {

                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        saveText();
    }
}
