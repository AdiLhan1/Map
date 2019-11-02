package com.marveltravel.map;

import android.app.Application;

import com.marveltravel.map.data.SharedPreferencesHelper;

public class App extends Application {
    private static SharedPreferencesHelper preferencesHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        preferencesHelper = new SharedPreferencesHelper(this);

    }

    public static SharedPreferencesHelper getPreferences() {
        return preferencesHelper;
    }
}
