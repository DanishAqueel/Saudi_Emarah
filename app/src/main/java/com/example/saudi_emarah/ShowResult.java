package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ShowResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        String s1=getIntent().getStringExtra("Key1");
        String s2=getIntent().getStringExtra("Key2");

        EditText et1=findViewById(R.id.editTextTextPersonName3);
        EditText et2=findViewById((R.id.editTextTextPersonName4));

        et1.setText(s1);
        et2.setText(s2);

        Button btn_OK=findViewById(R.id.button6);
        btn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_intent= new Intent(ShowResult.this,Istelam_Anil_Muamlaat.class);
                startActivity(back_intent);

            }
        });

    }
}