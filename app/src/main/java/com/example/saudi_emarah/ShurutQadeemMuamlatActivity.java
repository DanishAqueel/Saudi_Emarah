package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShurutQadeemMuamlatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shurut_qadeem_muamlat);
        ImageView iv=findViewById(R.id.image_title);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_contact_info= new Intent(ShurutQadeemMuamlatActivity.this,About_Page.class);
            startActivity(open_contact_info);
            }

        });

    }
    public void onBackPress(View v)
    {
        onBackPressed();
    }
}