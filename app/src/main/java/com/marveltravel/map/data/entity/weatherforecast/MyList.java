package com.marveltravel.map.data.entity.weatherforecast;

import com.marveltravel.map.data.entity.wheather.CloudEntity;
import com.marveltravel.map.data.entity.wheather.MainEntity;
import com.marveltravel.map.data.entity.wheather.SysEntity;
import com.marveltravel.map.data.entity.wheather.WeatherEntity;
import com.marveltravel.map.data.entity.wheather.WindEntity;

import java.util.List;

public class MyList {
    public int dt;
    public MainEntity main;
    public List<WeatherEntity> weather;
    public CloudEntity clouds;
    public WindEntity wind;
    public Rain rain;
    public SysEntity sys;
    public String dt_txt;
}
