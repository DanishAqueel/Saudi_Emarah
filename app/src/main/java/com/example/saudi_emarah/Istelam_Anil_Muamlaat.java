package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Istelam_Anil_Muamlaat extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istelam_anil_muamlaat);
        Button btn_id_year = findViewById(R.id.button4);
        Button btn_id = findViewById(R.id.button3);
        Frag_ID_Year frag1 = new Frag_ID_Year();
     fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container_frag,frag1).commit();

        btn_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Frag_ID frag2 = new Frag_ID();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container_frag,frag2).commit();
            }
        });

        btn_id_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container_frag,frag1).commit();
            }
        });
                                }
    }
