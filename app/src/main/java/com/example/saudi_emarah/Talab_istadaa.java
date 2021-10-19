package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Talab_istadaa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talab_istadaa);

        ImageView info_btn=findViewById(R.id.imageView10);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Talab_istadaa.this,About_Page.class);
                startActivity(intent);
            }
        });

        TextView talabIstedaa_text= findViewById(R.id.textView_talabIstedaa);
        talabIstedaa_text.setText(R.string.TalabIstedaaText);

    }
    public void onBackPress(View v){
        onBackPressed();
    }
}