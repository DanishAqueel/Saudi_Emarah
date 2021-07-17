package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ShurutQadeemMuamlatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shurut_qadeem_muamlat);
    }
    public void onBackPress(View v)
    {
        onBackPressed();
    }
}