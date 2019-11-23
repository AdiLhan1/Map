package com.marveltravel.map.ui.main;

import android.Manifest;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.marveltravel.map.R;
import com.marveltravel.map.data.entity.weatherforecast.MyList;
import com.marveltravel.map.utils.DateTimeHelper;
import com.marveltravel.map.utils.StringUtils;

public class WeatherForecastViewHolder extends RecyclerView.ViewHolder {
    private TextView txt_data_time, txt_desciption, txt_temperature, maxTemp, minTemp;
    private ImageView img_weather;
    private Listener listener;

    public WeatherForecastViewHolder(@NonNull View itemView, Listener listener) {
        super(itemView);
        maxTemp = itemView.findViewById(R.id.max_temp);
        minTemp = itemView.findViewById(R.id.min_temp);
        img_weather = itemView.findViewById(R.id.img_weather);
        txt_data_time = itemView.findViewById(R.id.txt_data);
        txt_desciption = itemView.findViewById(R.id.description1);
        txt_temperature = itemView.findViewById(R.id.temperature);
        this.listener=listener;
    }

    public void onBind(MyList item) {
        Glide.with((itemView.getContext())).load(StringUtils.getImageUrl(itemView.getContext(), item))
                .centerCrop()
                .into(img_weather);

        txt_data_time.setText(DateTimeHelper.getCurrentDateTime());
        txt_desciption.setText((item.weather.get(0).getDescription()));
        txt_temperature.setText(String.valueOf(item.main.getTemp()));
        maxTemp.setText((String.valueOf(item.main.getTemp_max())));
        minTemp.setText((String.valueOf(item.main.getTemp_min())));
                itemView.setOnClickListener(view -> {
                    listener.onItemClick(item);
                });

    }
}
