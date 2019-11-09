package com.marveltravel.map.utils;

import android.content.Context;

import com.marveltravel.map.R;
import com.marveltravel.map.data.entity.weatherforecast.MyList;

public class StringUtils {

    public static String getImageUrl(Context context, MyList icon){
       return String.format(context.getResources().getString(R.string.image_url),
               icon.weather.get(0).getIcon());
    }
}
