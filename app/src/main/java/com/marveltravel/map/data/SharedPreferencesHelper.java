package com.marveltravel.map.data;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesHelper {
    public final String PREFERENCES_NAME = "androidThree";
    public final String FIRST_LAUNCH = "first_launch";
    private Context context;
    private SharedPreferences preferences;

    public SharedPreferencesHelper(Context context) {
        this.context = context;
        createSharedPreferences();
    }

    private void createSharedPreferences() {
        preferences = context.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);

    }
    public void setFirstLaunch(){
        preferences.edit().putBoolean(FIRST_LAUNCH,false).apply();
    }
    public boolean getFirstLaunch(){
       return preferences.getBoolean(FIRST_LAUNCH,true);
    }
}
