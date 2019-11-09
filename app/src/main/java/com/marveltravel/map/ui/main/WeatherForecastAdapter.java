package com.marveltravel.map.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.marveltravel.map.R;
import com.marveltravel.map.data.entity.weatherforecast.ForecastWeatherEntity;
import com.marveltravel.map.utils.DateTimeHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastAdapter.MyViewHolder> {
    Context context;
    ForecastWeatherEntity weatherForecast;

    public WeatherForecastAdapter(Context context, ForecastWeatherEntity weatherForecast) {
        this.context = context;
        this.weatherForecast = weatherForecast;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_weather_forecast, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with((context)).load("http://openweathermap.org/img/wn/" + weatherForecast
                .list.get(position).weather.get(0).getIcon() + "@2x.png").centerCrop().into(holder.img_weather);

        holder.txt_data_time.setText(DateTimeHelper.getCurrentDateTime());

        holder.txt_desciption.setText(new StringBuilder(weatherForecast.list.get(position)
                .weather.get(0).getDescription()));
        holder.txt_temperature.setText(new StringBuilder(String.valueOf(weatherForecast.list.get(position)
                .main.getTemp())));
        holder.maxTemp.setText((String.valueOf(weatherForecast.list.get(position).main.getTemp_max())));
        holder.minTemp.setText((String.valueOf(weatherForecast.list.get(position).main.getTemp_min())));
    }

    @Override
    public int getItemCount() {
        return weatherForecast.list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_data_time, txt_desciption, txt_temperature, maxTemp, minTemp;
        ImageView img_weather;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            maxTemp = itemView.findViewById(R.id.max_temp);
            minTemp = itemView.findViewById(R.id.min_temp);
            img_weather = itemView.findViewById(R.id.img_weather);
            txt_data_time = itemView.findViewById(R.id.txt_data);
            txt_desciption = itemView.findViewById(R.id.description1);
            txt_temperature = itemView.findViewById(R.id.temperature);
        }
    }
}
