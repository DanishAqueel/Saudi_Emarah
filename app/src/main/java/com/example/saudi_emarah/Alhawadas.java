package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Alhawadas extends AppCompatActivity implements View.OnClickListener{
ViewPager alhawadas_viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alhawadas);
        alhawadas_viewpager= findViewById(R.id.Alhawadas_viewpager);
        pager_adapter_Alhawadas pagerAdapterAlhawadas= new pager_adapter_Alhawadas(this,this);
        alhawadas_viewpager.setAdapter(pagerAdapterAlhawadas);
        DepthPageTransformer depthPageTransformer=new DepthPageTransformer();
        alhawadas_viewpager.setPageTransformer(true,depthPageTransformer);
    }

    @Override
    public void onClick(View view) {
        int position=alhawadas_viewpager.getCurrentItem();
        if(position==0)
        {
            startActivity(new Intent(this,Istedua_Hawadis_Marwiya.class));
        }
        if(position==1)
        {
            startActivity(new Intent(this,Tarjeel_jasmaan_muqeem.class));
        }

    }

    public void onBackPress(View v){
        onBackPressed();
    }
}


