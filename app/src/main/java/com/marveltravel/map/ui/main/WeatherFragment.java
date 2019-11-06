package com.marveltravel.map.ui.main;


import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androdocs.httprequest.HttpRequest;
import com.bumptech.glide.Glide;
import com.marveltravel.map.R;
import com.marveltravel.map.data.entity.weatherforecast.WeatherForecast;
import com.marveltravel.map.data.entity.wheather.CurrentWeatherEntity;
import com.marveltravel.map.data.entity.wheather.WeatherEntity;
import com.marveltravel.map.data.network.RetrofitBuilder;
import com.marveltravel.map.ui.main.common.Common;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.marveltravel.map.BuildConfig.WEATHER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {
    Response<CurrentWeatherEntity> response;
    TextView temp, wind, humidity, sunrise, sunset, cloudiness, pressure, date, address, maxTemp, minTemp, description, tempNow;
    private ImageView imageView,imagMore;
    private WeatherEntity wheather;
    private WeatherTask task;

    public WeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        temp = view.findViewById(R.id.weather_nowTemp);
        wind = view.findViewById(R.id.weather_wind);
        sunrise = view.findViewById(R.id.weather_sunrise);
        sunset = view.findViewById(R.id.weather_sunset);
        humidity = view.findViewById(R.id.weather_humidity);
        cloudiness = view.findViewById(R.id.weather_cloudiness);
        pressure = view.findViewById(R.id.weather_pressure);
        date = view.findViewById(R.id.weather_date);
        address = view.findViewById(R.id.weather_country);
        maxTemp = view.findViewById(R.id.weather_maxTemp);
        minTemp = view.findViewById(R.id.weather_minTemp);
        description = view.findViewById(R.id.weather_description);
        imageView = view.findViewById(R.id.weather_imageview);
        imagMore=view.findViewById(R.id.image_more);
        imagMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WeatherForecast weatherForecast=new WeatherForecast();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container,weatherForecast)
                        .addToBackStack(null)
                        .commit();
            }
        });
        showCurrenWeather();
        return view;
    }

    private void showCurrenWeather() {
        RetrofitBuilder.getInstance().getCurrentweather("Bishkek", WEATHER_KEY, "metric")
                .enqueue(new Callback<CurrentWeatherEntity>() {
                    @Override
                    public void onResponse(Call<CurrentWeatherEntity> call, Response<CurrentWeatherEntity> response) {
                        Log.d("TAG", "onResponse: ");
                        CurrentWeatherEntity data = response.body();
                        pressure.setText(data.getMain().getPressure());
                        temp.setText(data.getMain().getTemp());
                        maxTemp.setText(data.getMain().getTemp_max());
                        minTemp.setText(data.getMain().getTemp_min());
                        humidity.setText(data.getMain().getHumidity());
                        wind.setText(data.getWind().getSpeed());
//                        date.setText(data.getDt().length());
                        address.setText(data.getName());
                        Glide.with((getContext())).load("http://openweathermap.org/img/wn/" + response.body().
                                getWeather().get(0).getIcon() + "@2x.png").centerCrop().into(imageView);
                        description.setText(data.getWeather().get(0).getDescription());
                        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
                        Date date1 =new Date();
                        Date date2 =new Date();
                        date1.setTime((long)data.getSys().getSunrise() *1000);
                        date2.setTime((long)data.getSys().getSunset() *1000);
                        String daty=dateFormat.format(date1.getTime());
                        String daty1=dateFormat.format(date2.getTime());
                        sunrise.setText(daty);
                        sunset.setText(daty1);
                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-YYYY Время:HH:MM:SS");
                        String format=sdf.format(cal.getTime());
                        date.setText(format);
                        cloudiness.setText(data.getClouds().getAll());
                    }

                    @Override
                    public void onFailure(Call<CurrentWeatherEntity> call, Throwable t) {
                        Log.d("TAG", "onFailure: ");
                    }
                });
    }

}
