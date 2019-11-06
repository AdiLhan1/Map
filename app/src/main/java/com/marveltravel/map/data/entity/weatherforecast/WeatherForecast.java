package com.marveltravel.map.data.entity.weatherforecast;


import android.location.Location;
import android.os.Bundle;

import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marveltravel.map.R;
import com.marveltravel.map.data.entity.wheather.CurrentWeatherEntity;
import com.marveltravel.map.data.network.RetrofitBuilder;
import com.marveltravel.map.data.network.RetrofitService;
import com.marveltravel.map.ui.main.WeatherForecastAdapter;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.marveltravel.map.BuildConfig.WEATHER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherForecast extends Fragment {
    CompositeDisposable compositeDisposable;
    RetrofitService mService;
    TextView txt_city_name,txt_geo_coord;
    RecyclerView recycler_forecast;

    static WeatherForecast instance;

    public static WeatherForecast getInstance() {
        if (instance==null)
            instance=new WeatherForecast();
        return instance;
        // Required empty public constructor
    }
    public WeatherForecast(){
        compositeDisposable=new CompositeDisposable();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView=inflater.inflate(R.layout.fragment_wather_forecast, container, false);
        txt_city_name=itemView.findViewById(R.id.text_city_name);
        txt_geo_coord=itemView.findViewById(R.id.text_geo_coord);

        recycler_forecast=itemView.findViewById(R.id.recyler_forecast);
        recycler_forecast.setHasFixedSize(true);
        recycler_forecast.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        getForecastWeatherInfo();
    return itemView;
    }

    private void getForecastWeatherInfo() {
        RetrofitBuilder.getInstance().getForecastweather("Bishkek", WEATHER_KEY, "metric")
                .enqueue(new Callback<ForecastWeatherEntity>() {
                    @Override
                    public void onResponse(Call<ForecastWeatherEntity> call, Response<ForecastWeatherEntity> response) {
                        displayForecastWeather(response.body());
                    }

                    @Override
                    public void onFailure(Call<ForecastWeatherEntity> call, Throwable t) {

                    }
                });
    }
    private void displayForecastWeather(ForecastWeatherEntity weatherEntity){
        txt_city_name.setText(new StringBuilder(weatherEntity.city.name));
        txt_geo_coord.setText(new StringBuilder("[").append(weatherEntity.city.coord));

        WeatherForecastAdapter adapter=new WeatherForecastAdapter(getContext(),weatherEntity);
        recycler_forecast.setAdapter(adapter);
    }

}
