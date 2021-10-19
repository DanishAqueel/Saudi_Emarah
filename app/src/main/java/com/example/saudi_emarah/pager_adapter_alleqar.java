package com.example.saudi_emarah;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.jetbrains.annotations.NotNull;

public class pager_adapter_alleqar extends PagerAdapter {

    Context aleqar_context;
    public int[] alleqar_images={R.mipmap.iphone40,R.mipmap.iphone41,R.mipmap.iphone42};
    View.OnClickListener aleqar_listener;

    public pager_adapter_alleqar(Context context, View.OnClickListener listener) {
        this.aleqar_context = context;
        this.aleqar_listener = listener;
    }

    @Override
    public int getCount() {
        return alleqar_images.length;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        ImageView imageView=new ImageView(aleqar_context);
        imageView.setImageResource(alleqar_images[position]);
        imageView.setOnClickListener(aleqar_listener);
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
