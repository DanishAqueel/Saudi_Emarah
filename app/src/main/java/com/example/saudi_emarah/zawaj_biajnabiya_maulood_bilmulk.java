package com.example.saudi_emarah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class zawaj_biajnabiya_maulood_bilmulk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zawaj_biajnabiya_maulood_bilmulk);
        TextView tv_zawajbiajnabiyamauloodbilmulk=findViewById(R.id.tv_azwaj_5);
        tv_zawajbiajnabiyamauloodbilmulk.setMovementMethod(new ScrollingMovementMethod());
        tv_zawajbiajnabiyamauloodbilmulk.setText(R.string.MauloodBilmulk);
    }
    public void onBackPress(View v){onBackPressed();}
}