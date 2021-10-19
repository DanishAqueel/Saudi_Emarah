 package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class tamlik_ghair_saudi_lilsakin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamlik_ghair_saudi_lilsakin);

        ImageView info_btn=findViewById(R.id.imageView6);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tamlik_ghair_saudi_lilsakin.this,About_Page.class);
                startActivity(intent);
            }
        });

        TextView textView=findViewById(R.id.tv_ghair_saudi_lilsakin);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(R.string.ghair_saudi_lilsakin);
    }

    public void onBackPress(View v){onBackPressed();}
}