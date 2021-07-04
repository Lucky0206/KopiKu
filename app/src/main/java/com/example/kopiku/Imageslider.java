package com.example.kopiku;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Imageslider extends PagerAdapter {
    Context context;

    Imageslider (Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return imageSlide.length;
    }
    private int[] imageSlide = new int[] {
            R.drawable.ca, R.drawable.aff, R.drawable.ame, R.drawable.es, R.drawable.la, R.drawable.moca
    };

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(imageSlide[position]);
        container.addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull  Object object) {
container.removeView((ImageView) object);
    }
}
