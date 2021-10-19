package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IstedaatAmma extends AppCompatActivity implements View.OnClickListener{
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istedaat_amma);
        viewPager= findViewById(R.id.IstedaatAmma_viewpager);
        pager_adapter_istedaad_amma pagerAdapterShurutQadeemAlmuamlaat=new pager_adapter_istedaad_amma(this,this);
        viewPager.setAdapter(pagerAdapterShurutQadeemAlmuamlaat);
        DepthPageTransformer depthPageTransformer=new DepthPageTransformer();
        viewPager.setPageTransformer(true,depthPageTransformer);


    }

    @Override
    public void onClick(View view) {
        int position=viewPager.getCurrentItem();
        if(position==0)
        {
            startActivity(new Intent(this,tajdeed_tashreeh_aslaha.class));
        }
        if(position==1)
        {
            startActivity(new Intent(this,Talab_istadaa.class));
        }

    }
public void onBackPress(View v){
        onBackPressed();
}
    }

class DepthPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0f);

        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setAlpha(1f);
            view.setTranslationX(0f);
            view.setScaleX(1f);
            view.setScaleY(1f);

        } else if (position <= 1) { // (0,1]
            // Fade the page out.
            view.setAlpha(1 - position);

            // Counteract the default slide transition
            view.setTranslationX(pageWidth * -position);

            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0f);
        }
    }
}
