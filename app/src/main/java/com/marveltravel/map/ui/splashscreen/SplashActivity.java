package com.marveltravel.map.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.marveltravel.map.App;
import com.marveltravel.map.R;
import com.marveltravel.map.ui.main.MainActivity;
import com.marveltravel.map.ui.onboard.OnBoardActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timerForSplashActivity();

    }
    private void timerForSplashActivity(){
        int delayMillis = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                selectMethod();
            }
        }, delayMillis);
    }
    private void selectMethod(){
        if (App.getPreferences().getFirstLaunch()){
            App.getPreferences().setFirstLaunch();
            OnBoardActivity.start(this);
        }else {
//            OnBoardActivity.start(this);
            MainActivity.start(this);
        }
        finish();
    }
}
