package com.marveltravel.map.data.entity.weatherforecast;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marveltravel.map.R;
import com.marveltravel.map.data.network.RetrofitBuilder;
import com.marveltravel.map.ui.main.WeatherCurrentFragment;
import com.marveltravel.map.ui.main.WeatherForecastAdapter;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.marveltravel.map.BuildConfig.WEATHER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherForecastFragment extends Fragment {
    private static final String SAVE_TEXT = "save_text";
    private CompositeDisposable compositeDisposable;
    private TextView txt_city_name, txt_geo_coord;
    private RecyclerView recycler_forecast;
    private String strText;
    private String country = "Bishkek";
    private static final String TAG = "loge_tag";
    Unbinder unbinder;
    ProgressBar progressBar;


    static WeatherForecastFragment instance;
    private SharedPreferences preferences;

    public static WeatherForecastFragment getInstance() {
        if (instance == null)
            instance = new WeatherForecastFragment();
        return instance;
        // Required empty public constructor
    }

    public WeatherForecastFragment() {
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_wather_forecast, container, false);
        showProgressBar();
        initView(itemView);
        getCountryText();
        loadText();
        getForecastWeatherInfo();
//        getInstance();
        return itemView;
    }

    private void showProgressBar() {
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }


    public void getCountryText() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            strText = bundle.getString("key");
            Log.e(TAG, "getCountryText: " + strText);
            if (strText != null) {
                txt_city_name.setText(strText);
                saveText();
            }
        }

    }

    public void initView(View view) {
        progressBar = view.findViewById(R.id.progressBar);
        txt_city_name = view.findViewById(R.id.text_city_name);
        txt_geo_coord = view.findViewById(R.id.text_geo_coord);
        recycler_forecast = view.findViewById(R.id.recyler_forecast);
        recycler_forecast.setHasFixedSize(true);
        recycler_forecast.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

    }

    private void saveText() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            preferences = Objects.requireNonNull(getActivity()).getPreferences(Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor ed = preferences.edit();
        if (txt_city_name != null) {
            ed.putString(SAVE_TEXT, txt_city_name.getText().toString());
            Log.e(TAG, "saveText: " + strText);
            ed.apply();
            country = strText;
        }
    }

    private void loadText() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            preferences = Objects.requireNonNull(getActivity()).getPreferences(Context.MODE_PRIVATE);
        }
        if (txt_city_name != null) {
            String savedText = preferences.getString(SAVE_TEXT, "");
            Log.e(TAG, "loadText: " + savedText);
            txt_city_name.setText(savedText);
            country = savedText;
        }
    }


    private void getForecastWeatherInfo() {
        RetrofitBuilder.getInstance().getForecastweather(country, WEATHER_KEY, "metric")
                .enqueue(new Callback<ForecastWeatherEntity>() {
                    @Override
                    public void onResponse(Call<ForecastWeatherEntity> call, Response<ForecastWeatherEntity> response) {
                        if (response.body() != null) {
                            displayForecastWeather(response.body());
                            Log.e(TAG, "getForecastWeather: " + strText);
                        }
                    }

                    @Override
                    public void onFailure(Call<ForecastWeatherEntity> call, Throwable t) {

                    }
                });
    }

    private void displayForecastWeather(ForecastWeatherEntity weatherEntity) {
//        txt_city_name.setText(new StringBuilder(weatherEntity.city.name));
        txt_city_name.setText(country);
        txt_geo_coord.setText(new StringBuilder("[").append(weatherEntity.city.coord + "]"));
//        weatherEntity.list.get(0).rain

        WeatherForecastAdapter adapter = new WeatherForecastAdapter(weatherEntity);
        recycler_forecast.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        saveText();
    }

}
