package com.marveltravel.map.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.marveltravel.map.R;
import com.marveltravel.map.data.entity.weatherforecast.ForecastWeatherEntity;
import com.marveltravel.map.data.entity.weatherforecast.WeatherForecast;
import com.marveltravel.map.data.entity.wheather.CurrentWeatherEntity;
import com.marveltravel.map.data.network.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.marveltravel.map.BuildConfig.WEATHER_KEY;

public class MainActivity extends AppCompatActivity {
    private Fragment first,second;
    private ViewPager viewPager;
    private WeatherFragment fragmentFirst;
    private MapsFragment fragmentSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewPager_Fragment);
        RetrofitBuilder.getInstance().getCurrentweather("Moscow",WEATHER_KEY,"metric")
                .enqueue(new Callback<CurrentWeatherEntity>() {
                    @Override
                    public void onResponse(Call<CurrentWeatherEntity> call, Response<CurrentWeatherEntity> response) {
                        Log.d("TAG", "onResponse: " );
                        CurrentWeatherEntity data =response.body();
//                        temp.setText(data.getMain().getTemp());
                    }

                    @Override
                    public void onFailure(Call<CurrentWeatherEntity> call, Throwable t) {
                        Log.d("TAG", "onFailure: " );
                    }
                });
        setViewPager();
    }
    public void setViewPager(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ViewPagerAdapterFragment viewPagerAdapter = new ViewPagerAdapterFragment(getSupportFragmentManager());
        fragmentFirst = new WeatherFragment();
        fragmentSecond = new MapsFragment();
        viewPagerAdapter.addFragment(fragmentFirst);
        viewPagerAdapter.addFragment(fragmentSecond);
        viewPagerAdapter.addFragment(WeatherForecast.getInstance());
        viewPager.setAdapter(viewPagerAdapter);
    }


    public static void start(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
