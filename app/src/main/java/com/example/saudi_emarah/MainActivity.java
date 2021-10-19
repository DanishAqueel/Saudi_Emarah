package com.example.saudi_emarah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      requestWindowFeature(Window.FEATURE_NO_TITLE);
       getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        ImageView info_btn=findViewById(R.id.info);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,About_Page.class);
                startActivity(intent);
            }
        });

        viewPager = (ViewPager) findViewById(R.id.pager);
        SliderAdapter sliderAdapter = new SliderAdapter(this, this);
        viewPager.setAdapter(sliderAdapter);
        CubeOutRotationTransformation cubeOutRotationTransformation= new CubeOutRotationTransformation();
        viewPager.setPageTransformer(true,cubeOutRotationTransformation);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(viewPager.getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        int position=viewPager.getCurrentItem();
        if(position==0)
        {
            startActivity(new Intent(this,Istelam_Anil_Muamlaat.class));
        }
        if(position==1)
        {
            startActivity(new Intent(this,ShurutQadeemMuamlatActivity.class));
        }
        if(position==2)
        {
            startActivity(new Intent(this,AlAkhbar.class));
        }

    }


    static class CubeOutRotationTransformation implements ViewPager.PageTransformer {
        @Override
        public void transformPage(@NonNull View page, float position) {

            if (position < -1){    // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.setAlpha(0);

            }
            else if (position <= 0) {    // [-1,0]
                page.setAlpha(1);
                page.setPivotX(page.getWidth());
                page.setRotationY(-90 * Math.abs(position));

            }
            else if (position <= 1){    // (0,1]
                page.setAlpha(1);
                page.setPivotX(0);
                page.setRotationY(90 * Math.abs(position));

            }
            else {    // (1,+Infinity]
                // This page is way off-screen to the right.
                page.setAlpha(0);

            }
        }
    }
}