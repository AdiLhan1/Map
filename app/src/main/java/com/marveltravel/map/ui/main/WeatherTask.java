package com.marveltravel.map.ui.main;

import android.os.AsyncTask;

import com.androdocs.httprequest.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WeatherTask extends AsyncTask<String, Void, String> {
    String API = "3c4782a06f52209ea31bc412533c091e";
    private Long updatedAt;
    private String updatedAtText;
    private String temp;
    private String tempMin;
    private String tempMax;
    private String pressure;
    private String humidity;
    private Long sunrise;
    private Long sunset;
    private String windSpeed;
    private String weatherDescription;
    private String address;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        /* Showing the ProgressBar, Making the main design GONE */
//        findViewById(R.id.loader).setVisibility(View.VISIBLE);
////        findViewById(R.id.mainContainer).setVisibility(View.GONE);
////        findViewById(R.id.errorText).setVisibility(View.GONE);
    }

    protected String doInBackground(String... args) {
        String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + "Bishkek" + "&units=metric&appid=" + API);
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            JSONObject jsonObj = new JSONObject(result);
            JSONObject main = jsonObj.getJSONObject("main");
            JSONObject sys = jsonObj.getJSONObject("sys");
            JSONObject wind = jsonObj.getJSONObject("wind");
            JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);

            Long updatedAt = jsonObj.getLong("dt");
            updatedAtText = "Updated at: " + new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000));
            temp = main.getString("temp") + "°C";
            tempMin = "Min Temp: " + main.getString("temp_min") + "°C";
            tempMax = "Max Temp: " + main.getString("temp_max") + "°C";
            pressure = main.getString("pressure");
            humidity = main.getString("humidity");
            sunrise = sys.getLong("sunrise");
            sunset = sys.getLong("sunset");
            windSpeed = wind.getString("speed");
            weatherDescription = weather.getString("description");
            address = jsonObj.getString("name") + ", " + sys.getString("country");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAtText() {
        return updatedAtText;
    }

    public void setUpdatedAtText(String updatedAtText) {
        this.updatedAtText = updatedAtText;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
