package com.marveltravel.map.data.entity.wheather;

import java.util.List;

public class CurrentWeatherEntity {
    private String dt;

    private CoordEntity coord;

    private String visibility;

    private List<WeatherEntity>weather;

    private String name;

    private String cod;

    private MainEntity main;

    private CloudEntity clouds;

    private String id;
//@SerializedName("")
    private SysEntity sys;

    private String base;

    private WindEntity wind;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public CoordEntity getCoord() {
        return coord;
    }

    public void setCoord(CoordEntity coord) {
        this.coord = coord;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public List<WeatherEntity> getWeather() {
        return weather;
    }

    public void setWeatherEntity1(List<WeatherEntity> weather)
    {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public MainEntity getMain() {
        return main;
    }

    public void setMain(MainEntity main) {
        this.main = main;
    }

    public CloudEntity getClouds() {
        return clouds;
    }

    public void setClouds(CloudEntity clouds) {
        this.clouds = clouds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SysEntity getSys() {
        return sys;
    }

    public void setSys(SysEntity sys) {
        this.sys = sys;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public WindEntity getWind() {
        return wind;
    }

    public void setWind(WindEntity wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "ClassPojo [dt = " + dt + ", coord = " + coord + ", visibility = " + visibility + ", weather = " + weather + ", name = " + name + ", cod = " + cod + ", main = " + main + ", clouds = " + clouds + ", id = " + id + ", sys = " + sys + ", base = " + base + ", wind = " + wind + "]";
    }
}
