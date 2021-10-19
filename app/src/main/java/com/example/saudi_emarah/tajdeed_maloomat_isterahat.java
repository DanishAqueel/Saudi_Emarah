package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class tajdeed_maloomat_isterahat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajdeed_maloomat_isterahat);

        ImageView info_btn=findViewById(R.id.imageView4);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tajdeed_maloomat_isterahat.this,About_Page.class);
                startActivity(intent);
            }
        });

        TextView textView=findViewById(R.id.tv_tajdeed_maloomat_isterahat);
        textView.setText(R.string.Tajdeed_Maloomat_Isterahat);
    }
    public void onBackPress(View v){onBackPressed();}
}