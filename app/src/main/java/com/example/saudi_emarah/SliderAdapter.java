package com.example.saudi_emarah;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class SliderAdapter extends PagerAdapter{
    Context mContext;

    //list of images

    public int[] images = {R.mipmap.slider1, R.mipmap.slider2,R.mipmap.slider3,R.mipmap.slider4};
    View.OnClickListener listener;

    public SliderAdapter(Context context, View.OnClickListener listener) {
        this.mContext = context;
        this.listener=listener;
    }


    @Override
    public int getCount() {
        return images.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(images[position]);
        imageView.setOnClickListener(listener);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;

    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}
