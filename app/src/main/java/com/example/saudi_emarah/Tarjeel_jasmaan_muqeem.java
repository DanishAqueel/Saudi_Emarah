package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Tarjeel_jasmaan_muqeem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjeel_jasmaan_muqeem);

        ImageView info_btn=findViewById(R.id.imageView8);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Tarjeel_jasmaan_muqeem.this,About_Page.class);
                startActivity(intent);
            }
        });

        TextView textView=findViewById(R.id.tv_TarjeelJasmaanMuqeem);
        textView.setText(R.string.TarjeelJasmaanMuqeem);
    }
    public void onBackPress(View v){
        onBackPressed();
    }
    }
