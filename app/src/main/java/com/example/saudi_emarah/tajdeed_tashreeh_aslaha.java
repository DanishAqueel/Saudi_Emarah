package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class tajdeed_tashreeh_aslaha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajdeed_tashreeh_aslaha);

        ImageView info_btn=findViewById(R.id.imageView9);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tajdeed_tashreeh_aslaha.this,About_Page.class);
                startActivity(intent);
            }
        });

        TextView textView=findViewById(R.id.textView2);
        textView.setText(R.string.TajdeedTashreehAslahaText);
    }
public void onBackPress(View v){
onBackPressed();
}
}