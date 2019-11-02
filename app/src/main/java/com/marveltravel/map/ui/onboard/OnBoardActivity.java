package com.marveltravel.map.ui.onboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.marveltravel.map.R;
import com.marveltravel.map.ui.main.MainActivity;

import java.util.zip.Inflater;

public class OnBoardActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private ViewPagerAdapter onBoardAdapter;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        initViews();
        onBoardAdapter = new ViewPagerAdapter();
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(onBoardAdapter);
        @SuppressLint("InflateParams") View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.view_red, null);
        btnNext = view.findViewById(R.id.btnNext);
        onNextClick();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, OnBoardActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onNextClick() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (viewPager.getCurrentItem() == 3) {
                    btnNext.setText("Finsh");
                    btnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MainActivity.start(OnBoardActivity.this);
                        }
                    });
                } else {
                    btnNext.setText(R.string.next);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbatTransparent);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_skip:
                MainActivity.start(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

