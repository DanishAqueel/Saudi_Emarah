package com.example.saudi_emarah;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.jetbrains.annotations.NotNull;

public class pager_adapter_istedaad_amma extends PagerAdapter {

    Context mcontext;
public int[] images={R.mipmap.iphone53,R.mipmap.iphone52};
View.OnClickListener listener;

public pager_adapter_istedaad_amma(Context context, View.OnClickListener listener){
this.mcontext=context;
this.listener=listener;

}

    @Override
    public int getCount() {
        return images.length;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {

    ImageView imageView=new ImageView(mcontext);
    imageView.setImageResource(images[position]);
    imageView.setOnClickListener(listener);
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
