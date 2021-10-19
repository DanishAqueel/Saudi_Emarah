package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Istelam_Anil_Muamlaat extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istelam_anil_muamlaat);
        Log.i("Istelam_Anil_Muamlat","Inside Istelam_Anil_Muamlat Activity");
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button btn_id_year = findViewById(R.id.button4);
        Button btn_id = findViewById(R.id.button3);
        Frag_ID_Year frag1 = new Frag_ID_Year();
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container_frag,frag1).commit();
         btn_id_year.setBackgroundColor(Color.BLACK);
         btn_id_year.setTextColor(Color.WHITE);
         btn_id.setBackgroundColor(Color.WHITE);
         btn_id.setTextColor(Color.BLACK);


        btn_id.setOnClickListener(view -> {
            Frag_ID frag2 = new Frag_ID();
           btn_id.setBackgroundColor(Color.BLACK);
           btn_id.setTextColor(Color.WHITE);
           btn_id_year.setBackgroundColor(Color.WHITE);
           btn_id_year.setTextColor(Color.BLACK);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container_frag,frag2).commit();
        });

        btn_id_year.setOnClickListener(view -> {
            Log.i("Istelam_Anil_Muamlat","id_year button clicked");
            btn_id_year.setBackgroundColor(Color.BLACK);
            btn_id_year.setTextColor(Color.WHITE);
            btn_id.setBackgroundColor(Color.WHITE);
            btn_id.setTextColor(Color.BLACK);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container_frag,frag1).commit();
        });

    }
    public void onBackPress(View v){onBackPressed();};
}

