package com.marveltravel.map.ui.onboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.marveltravel.map.R;
import com.marveltravel.map.data.entity.OnBoardEntity;
import com.marveltravel.map.ui.main.MainActivity;

import java.util.ArrayList;

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
        onNextClick();
        setupClickListener();
        setupViewPager();
    }

    private void setupClickListener() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
    }

    public void setupViewPager() {
        onBoardAdapter = new ViewPagerAdapter(getResource());
        viewPager.setAdapter(onBoardAdapter);
    }

    private ArrayList<OnBoardEntity> getResource() {
        ArrayList<OnBoardEntity> list = new ArrayList<>();
        list.add(new OnBoardEntity("", R.drawable.red2));
        list.add(new OnBoardEntity("", R.drawable.blue));
        list.add(new OnBoardEntity("", R.drawable.orange));
        list.add(new OnBoardEntity("", R.drawable.yellow));
        return list;
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
                    btnNext.setText("Finish");
                    btnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MainActivity.start(OnBoardActivity.this);
                            finish();
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
        viewPager = findViewById(R.id.viewPager);
        btnNext = findViewById(R.id.btnNext);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_skip:
                MainActivity.start(this);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

