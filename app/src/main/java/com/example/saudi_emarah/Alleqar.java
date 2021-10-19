package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Alleqar extends AppCompatActivity implements View.OnClickListener{
ViewPager alleqar_viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alleqar);
        alleqar_viewpager= findViewById(R.id.Alleqar_viewpager);
        pager_adapter_alleqar alleqarpageradapter=new pager_adapter_alleqar(this,this);
        alleqar_viewpager.setAdapter(alleqarpageradapter);

        Aleqar_PageTransformer aleqar_pageTransformer=new Aleqar_PageTransformer();
        alleqar_viewpager.setPageTransformer(true,aleqar_pageTransformer);
    }

    @Override
    public void onClick(View view) {
        int position=alleqar_viewpager.getCurrentItem();
        if(position==0)
        {
            startActivity(new Intent(this,Fath_Isterahat.class));
        }
        if(position==1)
        {
            startActivity(new Intent(this,tajdeed_maloomat_isterahat.class));
        }
        if(position==2)
        {
            startActivity(new Intent(this,tamlik_ghair_saudi_lilsakin.class));
        }


    }

    public void onBackPress(View v){
        onBackPressed();
    }
}

class Aleqar_PageTransformer implements ViewPager.PageTransformer {
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