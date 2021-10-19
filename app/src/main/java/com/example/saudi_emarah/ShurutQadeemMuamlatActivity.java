package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShurutQadeemMuamlatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shurut_qadeem_muamlat);
        ImageView iv=findViewById(R.id.image_title);
        TextView istedaad_amma=findViewById(R.id.IstedaadAmma);
        TextView alhawadas=findViewById(R.id.tv_alhawadas);
        TextView alzawaj=findViewById(R.id.tv_alzawaj);
        TextView aleqar=findViewById(R.id.Aleqar);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_contact_info= new Intent(ShurutQadeemMuamlatActivity.this,About_Page.class);
            startActivity(open_contact_info);
            }

        });

        istedaad_amma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_istedaat_amma=new Intent(ShurutQadeemMuamlatActivity.this,IstedaatAmma.class);
                startActivity(open_istedaat_amma);
            }
        });

        alhawadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_Alhawadas=new Intent(ShurutQadeemMuamlatActivity.this,Alhawadas.class);
                startActivity(open_Alhawadas);
            }
        });

        alzawaj.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
         Intent open_Alzawaj=new Intent(ShurutQadeemMuamlatActivity.this,Alzawaj.class);
         startActivity(open_Alzawaj);
    }
});

        aleqar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_aleqar=new Intent(ShurutQadeemMuamlatActivity.this,Alleqar.class);
                startActivity(open_aleqar);
            }
        });
    }

    public void onBackPress(View v)
    {
        onBackPressed();
    }
}