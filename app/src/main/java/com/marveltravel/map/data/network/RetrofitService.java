package com.marveltravel.map.data.network;


import com.marveltravel.map.data.entity.weatherforecast.ForecastWeatherEntity;
import com.marveltravel.map.data.entity.wheather.CurrentWeatherEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET(ApiEndpoints.CURRENT_WEATHER)
    Call<CurrentWeatherEntity> getCurrentweather(@Query("q")String city,@Query("appid") String appid,@Query("units")String metric);
    @GET(ApiEndpoints.FORECAST_WEATHER)
    Call<ForecastWeatherEntity> getForecastweather( @Query("q") String city, @Query("appid") String appid, @Query("units") String metric);
}
