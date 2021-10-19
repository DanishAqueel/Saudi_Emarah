package com.example.saudi_emarah;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.jetbrains.annotations.NotNull;

public class pager_adapter_Alzawaj extends PagerAdapter {
    Context alzawaj_context;
    public int[] alzawaj_images={R.mipmap.iphone30,R.mipmap.iphone31,R.mipmap.iphone32,R.mipmap.iphone33,R.mipmap.iphone34};
    View.OnClickListener alzawaj_listener;

    public pager_adapter_Alzawaj(Context alzawaj_context, View.OnClickListener alzawaj_listener) {
        this.alzawaj_context = alzawaj_context;
        this.alzawaj_listener = alzawaj_listener;
    }

    @Override
    public int getCount() {
        return alzawaj_images.length;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        ImageView imageView=new ImageView(alzawaj_context);
        imageView.setImageResource(alzawaj_images[position]);
        imageView.setOnClickListener(alzawaj_listener);
        container.addView(imageView,0);
        return imageView;
    }
    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((ImageView)object);
    }

}
