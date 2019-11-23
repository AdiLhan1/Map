package com.marveltravel.map.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marveltravel.map.R;
import com.marveltravel.map.data.entity.weatherforecast.ForecastWeatherEntity;
import com.marveltravel.map.data.entity.weatherforecast.MyList;

import java.util.ArrayList;
import java.util.List;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastViewHolder> {
    private List<MyList> weatherForecast=new ArrayList<>();
    private Listener listener;

    public WeatherForecastAdapter( Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public WeatherForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_forecast, parent, false);
        return new WeatherForecastViewHolder(itemView, listener);
    }
    public void update(List<MyList> weatherForecast){
        this.weatherForecast=weatherForecast;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherForecastViewHolder holder, int position) {
        holder.onBind(weatherForecast.get(position));
    }

    @Override
    public int getItemCount() {return weatherForecast.size();}
}

