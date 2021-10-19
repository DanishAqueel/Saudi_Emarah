package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Fath_Isterahat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fath_isterahat);

        ImageView info_btn=findViewById(R.id.imageView3);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Fath_Isterahat.this,About_Page.class);
                startActivity(intent);
            }
        });

        TextView textView=findViewById(R.id.tv_fath_isterahat);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(R.string.Fath_Isterahat);
    }
    public void onBackPress(View v){onBackPressed();}
}