package com.example.saudi_emarah;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.jetbrains.annotations.NotNull;

public class pager_adapter_Alhawadas extends PagerAdapter {

    Context alhawadas_context;
    public int[] alhawadas_images={R.mipmap.iphone20,R.mipmap.iphone21};
    View.OnClickListener alhawadas_listener;

    public pager_adapter_Alhawadas(Context alhawadas_context, View.OnClickListener alhawadas_listener) {
        this.alhawadas_context = alhawadas_context;
        this.alhawadas_listener = alhawadas_listener;
    }

    @Override
    public int getCount() {
        return alhawadas_images.length;
    }


    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {

        ImageView imageView=new ImageView(alhawadas_context);
        imageView.setImageResource(alhawadas_images[position]);
        imageView.setOnClickListener(alhawadas_listener);
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
