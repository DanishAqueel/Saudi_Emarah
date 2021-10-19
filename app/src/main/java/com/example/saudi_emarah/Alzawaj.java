package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Alzawaj extends AppCompatActivity implements View.OnClickListener{
ViewPager alzawaj_viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alzawaj);
        alzawaj_viewpager= findViewById(R.id.Alzawaj_viewpager);
        pager_adapter_Alzawaj pagerAdapterAlzawaj=new pager_adapter_Alzawaj(this,this);
        alzawaj_viewpager.setAdapter(pagerAdapterAlzawaj);
        Alzawaj_PageTransformer alzawaj_pageTransformer= new Alzawaj_PageTransformer();
        alzawaj_viewpager.setPageTransformer(true,alzawaj_pageTransformer);

    }

    @Override
    public void onClick(View view) {
        int position=alzawaj_viewpager.getCurrentItem();
        if(position==0)
        {
            startActivity(new Intent(this,min_ghair_saudi_muqeem.class));
        }
        if(position==1)
        {
            startActivity(new Intent(this,min_ghair_saudi_bilkharij.class));
        }
        if(position==2)
        {
            startActivity(new Intent(this,min_ghair_saudi.class));
        }
        if(position==3)
        {
            startActivity(new Intent(this,min_ghair_saudi_maulood_bissaudi.class));
        }
        if(position==4)
        {
            startActivity(new Intent(this,zawaj_biajnabiya_maulood_bilmulk.class));
        }
    }
    public void onBackPress(View v){
        onBackPressed();
    }
}


class Alzawaj_PageTransformer implements ViewPager.PageTransformer {
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