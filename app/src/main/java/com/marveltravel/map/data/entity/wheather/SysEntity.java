package com.marveltravel.map.data.entity.wheather;

public class SysEntity {
    private String country;

    private double sunrise;

    private double sunset;

    private String id;

    private String type;

    private String message;

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public double getSunrise ()
    {
        return sunrise;
    }

    public void setSunrise (double sunrise)
    {
        this.sunrise = sunrise;
    }

    public double getSunset ()
    {
        return sunset;
    }

    public void setSunset (double sunset)
    {
        this.sunset = sunset;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [country = "+country+", sunrise = "+sunrise+", sunset = "+sunset+", id = "+id+", type = "+type+", message = "+message+"]";
    }
}
