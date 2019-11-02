package com.marveltravel.map.ui.onboard;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.marveltravel.map.R;
import com.marveltravel.map.ui.main.MainActivity;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
//    private TextView textView;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        context = container.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.view_red, null);
        ImageView imageView = view.findViewById(R.id.red1);
//        textView = view.findViewById(R.id.text_view);

        Log.d("poss", position + "");
        switch (position) {
            case 0:
                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.red2));
//                textView.setText("В данном приложении вы можете учиться");
                break;
            case 1:
                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.blue));
//                textView.setText("В данном приложении вы можете обновлять");
                break;
            case 2:
                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.yellow));
//                textView.setText("В данном приложении вы можете удалять");
                break;
            case 3:
                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.orange));
//                textView.setText("Спасибо");
                break;
            default:
                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.red2));
//                textView.setText("Спасибо");
        }
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
