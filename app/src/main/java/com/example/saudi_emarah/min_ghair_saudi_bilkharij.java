package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class min_ghair_saudi_bilkharij extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_ghair_saudi_bilkharij);

        ImageView info_btn=findViewById(R.id.imageView5);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(min_ghair_saudi_bilkharij.this,About_Page.class);
                startActivity(intent);
            }
        });

        TextView tv_minghairsaudibilkharij=findViewById(R.id.tv_min_ghair_saudi_bilkharij);
        tv_minghairsaudibilkharij.setText(R.string.MinGhairSaudiBilkharij);
    }

    public void onBackPress(View v){onBackPressed();}

}